'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
.controller('HomeCtrl', function ($rootScope, $scope, adminUserService, $location, $log, $http, alertService,  $translate, $window) {

	
    $scope.isAuthenticated = function() {
    	
    	
    		 
        
  	  $log.debug("koray2");
  };

  $scope.isAuthenticated();	
  $rootScope.authenticated = true;
});