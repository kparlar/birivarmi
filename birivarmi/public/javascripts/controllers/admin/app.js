////////
// This sample is published as part of the blog article at www.toptal.com/blog
// Visit www.toptal.com/blog and subscribe to our newsletter to read great posts
////////

'use strict';

/**
 * @ngdoc overview
 * @name birivarmiAdminApp
 * @description
 * # birivarmiAdminApp
 *
 * Main module of the application.
 */
angular
    .module('birivarmiAdminApp', [
      'ngAnimate',
      'ngCookies',
      'ngResource',
      'ngRoute',
      'ngSanitize',
      'ngTouch',
      'ui.bootstrap',
      'pascalprecht.translate',// angular-translate
      'tmh.dynamicLocale',// angular-dynamic-locale
      'chart.js',
      'ngSanitize',
      'ui.tree'
    ]).constant('DEBUG_MODE', /*DEBUG_MODE*/true/*DEBUG_MODE*/)
    .constant('VERSION_TAG', /*VERSION_TAG_START*/new Date().getTime()/*VERSION_TAG_END*/)
    .constant('LOCALES', {
        'locales': {
        	'en_US': 'English',
        	'tr_TR': 'Turkish'
            
          },
          'preferredLocale': 'tr_TR'
        })// Angular debug info
        .config(function ($compileProvider, DEBUG_MODE) {
            if (!DEBUG_MODE) {
              $compileProvider.debugInfoEnabled(false);// disables AngularJS debug info
            }
          }) // Angular Translate
        .config(function ($translateProvider, DEBUG_MODE, LOCALES) {
            if (DEBUG_MODE) {
              $translateProvider.useMissingTranslationHandlerLog();// warns about missing translates
            }

            $translateProvider.useStaticFilesLoader({
              prefix: '../../../resources/admin/locale-',
              suffix: '.json'
            });

            $translateProvider.preferredLanguage(LOCALES.preferredLocale);
            $translateProvider.useLocalStorage();
            
            //below sanitize written for this purpose.
            //angular.js:11715 pascalprecht.translate.$translateSanitization: 
            //No sanitization strategy has been configured. This can have serious security implications. 
            //See http://angular-translate.github.io/docs/#/guide/19_security for details.
            $translateProvider.useSanitizeValueStrategy('escape');
          })
          // Angular Dynamic Locale
          .config(function (tmhDynamicLocaleProvider) {
            tmhDynamicLocaleProvider.localeLocationPattern('../../bower_components/angular-i18n/angular-locale_{{locale}}.js');
          })
          .config(function($httpProvider) {
        	  //Enable cross domain calls
        	  $httpProvider.defaults.useXDomain = true;

        	  //Remove the header used to identify ajax call  that would prevent CORS from working
        	  delete $httpProvider.defaults.headers.common['X-Requested-With'];
          })
    .config(function ($routeProvider, $locationProvider) {
      $routeProvider
	      .when('/', {
	          templateUrl: '/views/admin/login.html',
	          controller: 'AdminLoginCtrl'
	        })
	      .when('/home', {
            templateUrl: '/views/admin/home.html',
            controller: 'HomeCtrl'
          })
	      .when('/controlBoard', {
            templateUrl: '/views/admin/controlBoard.html',
            controller: 'ControlBoardCtrl'
          })
           .when('/settings/categories', {
            templateUrl: '/views/admin/settings/categories.html',
            controller: 'CategoriesCtrl'
          })
          .when('/main', {
            templateUrl: '/views/admin/main.html',
            controller: 'MainCtrl'
          })
          .when('/signup', {
            templateUrl: '/views/admin/signup.html',
            controller: 'SignupCtrl'
          })
          .when('/login', {
            templateUrl: '/views/admin/login.html',
            controller: 'AdminLoginCtrl'
          })
          .when('/addpost', {
            templateUrl: '/views/admin/addpost.html',
            controller: 'AddpostCtrl'
          })
          .when('/viewpost/:postId', {
            templateUrl: '/views/admin/viewpost.html',
            controller: 'ViewpostCtrl'
          })
          .otherwise({
            redirectTo: '/'
          });
      
      $locationProvider.html5Mode(true);
    })
    
    .run(
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
    	//$rootScope.globals = $cookieStore.get('globals') || {};
    	$rootScope.authenticated = false;
//        if ($rootScope.globals.currentUser) {
//            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
//        }
//  
//        $rootScope.$on('$locationChangeStart', function (event, next, current) {
//            // redirect to login page if not logged in
//            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
//                $location.path('/login');
//            }
//        });
    });


