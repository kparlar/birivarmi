////////
// This sample is published as part of the blog article at www.toptal.com/blog
// Visit www.toptal.com/blog and subscribe to our newsletter to read great posts
////////

'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the clientApp
 */
angular.module('birivarmiAdminApp')
    .controller('AdminLoginCtrl', function ($scope, adminUserService, $location, $log, $http, alertService,  $translate, $window,
    		 $rootScope, AuthenticationService) {
    
    	
        $scope.isAuthenticated = function() {
      	  $log.debug("koray");
      };

      $scope.isAuthenticated();	
        AuthenticationService.ClearCredentials();
      
    	$scope.login = function() {
       
    	$scope.dataLoading = true;
    	AuthenticationService.Login($scope.email, $scope.password, function(response) {
                if(response.success) {
                    AuthenticationService.SetCredentials(response.data);
                    $location.path('/home');
					//$window.location.href = 'http://localhost:9000/views/admin/home.html';
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
					alertService.add('danger', $scope.error);
                }
            });
    	
    	
    	
//    	
//        var payload = {
//          email : this.email,
//          password : this.password
//        };
//        
//        $http({
//        	method  : 'POST',
//        	url     : 'http://localhost:8088/birivarmi/birivarmiapp/app/v1/admin',
//        	data    : 'email='+this.email+'&password='+this.password, //forms user object
//        	headers : {'Content-Type': 'application/x-www-form-urlencoded'}
//        
//        }).error(function(data, status){
//        	var errorValue = "";
//              if(status === 404) {            	  
//            	  errorValue = $translate.instant('error.invalidMailOrPassword');
//                alertService.add('danger', errorValue);
//              } else if(status === 500) {
//            	  errorValue =  $translate.instant('error.invalidMailOrPassword');
//                alertService.add('danger', errorValue);
//              } else {
//                alertService.add('danger', data);
//              }
//            })
//            .success(function(data){
//              $log.debug(data);
//              adminUserService.username = data.username;
//              $window.location.href = 'http://localhost:9000/views/admin/home.html?email='+data.email+'&authKey='+data.authenticateKey;
//            });
      };
    });
