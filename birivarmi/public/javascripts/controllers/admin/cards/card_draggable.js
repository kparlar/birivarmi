'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:CardCtrl
 * @description
 * # CardCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
  .controller('CardDraggableCtrl', function ($scope, $translate, alertService) {
//	  $scope.handleDrop = function() {
//	        alert('Item has been dropped');
//	    }
	  		var obj = {
			    id: null,
			    content: null,
			    group: null
			  };
			  
			  $scope.obj = angular.copy(obj);
			  
			  // listeners
			  
			  $scope.$on('drag.started',function(evt,data){
			    if(angular.isDefined(data.obj))
			      $scope.obj = data.obj;
			  });
			  
			  $scope.$on('drag.stopped',function(evt,data){
			    $scope.obj = angular.copy(obj); // reset controller's object
			  });
  });