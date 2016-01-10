'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:CardCtrl
 * @description
 * # CardCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
  .controller('CardDroppableCtrl', function ($scope, $translate, alertService) {
	  $scope.handleDrop = function() {
	        alert('Item has been dropped');
	    }
	  
  });