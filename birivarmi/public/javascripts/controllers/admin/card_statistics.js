'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:CardCtrl
 * @description
 * # CardCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
  .controller('CardStatisticsCtrl', function ($scope) {
	  $scope.selectedItemChanged = function(){
		    for( var i = 0 ; i<2;i++){
		    	if(parseInt($scope.selectedchart, 10) === i){
		    		$scope.cardobjects[i].showchart = true;
		    	}else{
		    		$scope.cardobjects[i].showchart = false;
		    	}
		    }
		  };
  });