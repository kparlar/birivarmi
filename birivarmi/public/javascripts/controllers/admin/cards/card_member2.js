'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:CardCtrl
 * @description
 * # CardCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
  .controller('CardMember2Ctrl', function ($scope, $translate, alertService) {
	  $scope.enableDisableCardCategory = function(){
		  if($scope.member.isDisabled === true){
			  $scope.member.isDisabled = false;
			  $scope.member.enableDisableText = $translate.instant('admin.menu.settings.categories.disabled');
			  $scope.member.enableDisableCssElementText = "enabled";
			  var message = $translate.instant('admin.menu.settings.categories.enabled.message');
			  alertService.add('info', message);
		  }else{
			  $scope.member.isDisabled = true;
			  $scope.member.enableDisableText = $translate.instant('admin.menu.settings.categories.enabled');
			  $scope.member.enableDisableCssElementText = "disabled";
			  var message = $translate.instant('admin.menu.settings.categories.disabled.message');
			  alertService.add('info', message);
		  }  
	  };
	  $scope.openCloseCardCategory = function(){
		  if($scope.member.isOpen === true){
			  $scope.member.isOpen = false;
		  }else{
			  $scope.member.isOpen = true;
		  }
	  }
	  
	  
	  var obj = {
			  title : '',
    			id: '',		  		
    		  	isOpen: false,
    		  	isDisabled: false,
    		    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
    		    enableDisableCssElementText: 'enabled',
    		    placeholder: false,
    		    content:'',
    		    group:'',
    		    children: []
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