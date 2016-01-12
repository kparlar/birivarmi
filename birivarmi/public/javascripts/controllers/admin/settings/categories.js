'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:CardCtrl
 * @description
 * # CardCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
  .controller('CategoriesCtrl', function ($scope, $translate, alertService, BirivarmiService) {
	 
	  $scope.questionMarkAlertAction = function(){
		  var message_1_1 = $translate.instant('admin.menu.settings.categories.questionmark.message_1.0');
		  var message_1_2 = $translate.instant('admin.menu.settings.categories.questionmark.message_1.1');
		  var message_1_3 = $translate.instant('admin.menu.settings.categories.questionmark.message_1.2');
		  alertService.add('warning', message_1_1);
		  alertService.add('warning', message_1_2);
		  alertService.add('warning', message_1_3);
	  }
	  $scope.getSelectedNode = function (data, id) {
          angular.forEach(data, function (obj) {
        	  if($scope.selectedObject != null){
        		  return;
        	  }else{
        		  if(obj.id === id){
                  	return $scope.selectedObject = obj;
                  }else{
                  	$scope.getSelectedNode(obj.nodes, id);
                  }  
        	  } 
          });
        };
	  
	  $scope.enableDisableCardCategory = function(id){
		
		 $scope.getSelectedNode($scope.data, id);		 
		 var tempObj = $scope.selectedObject;
		 if(tempObj != null){
			 $scope.selectedObject = null;
			  if(tempObj.isDisabled === true){
				  tempObj.isDisabled = false;
				  tempObj.enableDisableText = $translate.instant('admin.menu.settings.categories.disabled');
				  tempObj.enableDisableCssElementText = "angular-ui-tree-handle";
				  var message = $translate.instant('admin.menu.settings.categories.enabled.message');
				  alertService.add('info', message);
			  }else{
				  tempObj.isDisabled = true;
				  tempObj.enableDisableText = $translate.instant('admin.menu.settings.categories.enabled');
				  tempObj.enableDisableCssElementText = "angular-ui-tree-handle-disabled";
				  var message = $translate.instant('admin.menu.settings.categories.disabled.message');
				  alertService.add('info', message);
			  } 
		 }else{
			 var message = $translate.instant('category')+" "+$translate.instant('error.notFound');
			  alertService.add('error', message);
		 }
		  
	  };
	  
	 
	  
	     $scope.remove = function (scope) {
	         scope.remove();
	       };

	       $scope.toggle = function (scope) {
	         scope.toggle();
	       };

	       $scope.moveLastToTheBeginning = function () {
	         var a = $scope.data.pop();
	         $scope.data.splice(0, 0, a);
	       };

	       $scope.newSubItem = function (scope) {
	         var nodeData = scope.$modelValue;
	         nodeData.nodes.push({
	           id: nodeData.id * 10 + nodeData.nodes.length,
	           title: nodeData.title + '.' + (nodeData.nodes.length + 1),
	           nodes: []
	         });
	       };
	       
	       $scope.newItem = function (scope) {
	    	   var name = $translate.instant('admin.menu.settings.categories.newCategory');
	    	   var updaterId = 1;
	    	   var promise = BirivarmiService.createCategory(name, updaterId);
	    	   promise.then(function(response){
	    		   if(response.success === true){
		    		   var data = scope.data;
				         data.push({
				           id: response.id,
					       title: name,
					       enableDisableCssElementText: 'angular-ui-tree-handle',
					       enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
					       isDisabled: false,
					       nodrop: true, // An arbitrary property to check in custom template for nodrop-enabled
					       nodes: []
				         });
				         var message = $translate.instant('success.successfullyInserted');
						 alertService.add('success', message);
		    	   }else{
		    		   var message = response.message;
						alertService.add('danger', message);
		    	   }
	    		   
	    	   });
	    	 
		       };

	       $scope.collapseAll = function () {
	         $scope.$broadcast('collapseAll');
	       };

	       $scope.expandAll = function () {
	         $scope.$broadcast('expandAll');
	       };
	       
	       $scope.populateData = function (scope){
	    	   var promise = BirivarmiService.getCategories();
	    	   promise.then(function(response){
	    		   if(response.success === true){
	    			   $scope.data = response.data;				         
		    	   }else{
		    		   var message = response.message;
					   alertService.add('danger', message);
		    	   }
	    	   });
	    	 
		       };
		   $scope.populateData();
	       
//	       $scope.data = [{
//	         'id': 1,
//	         'title': 'node1',
//	         'enableDisableCssElementText': 'angular-ui-tree-handle',
//	         'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	         'isDisabled': false,
//	         'nodes': [
//	           {
//	             'id': 11,
//	             'title': 'node1.1',
//	             'enableDisableCssElementText': 'angular-ui-tree-handle',
//	             'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	             'isDisabled': false,
//	             'nodes': [
//	               {
//	                 'id': 111,
//	                 'title': 'node1.1.1',
//	                 'enableDisableCssElementText': 'angular-ui-tree-handle',
//	                 'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	                 'isDisabled': false,
//	                 'nodes': []
//	               }
//	             ]
//	           },
//	           {
//	             'id': 12,
//	             'title': 'node1.2',
//	             'enableDisableCssElementText': 'angular-ui-tree-handle',
//	             'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	             'isDisabled': false,
//	             'nodes': []
//	           }
//	         ]
//	       }, {
//	         'id': 2,
//	         'title': 'node2',
//	         'enableDisableCssElementText': 'angular-ui-tree-handle',
//	         'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	         'isDisabled': false,
//	         'nodrop': true, // An arbitrary property to check in custom template for nodrop-enabled
//	         'nodes': [
//	           {
//	             'id': 21,
//	             'title': 'node2.1',
//	             'enableDisableCssElementText': 'angular-ui-tree-handle',
//	             'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	             'isDisabled': false,
//	             'nodes': []
//	           },
//	           {
//	             'id': 22,
//	             'title': 'node2.2',
//	             'enableDisableCssElementText': 'angular-ui-tree-handle',
//	             'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	             'isDisabled': false,
//	             'nodes': []
//	           }
//	         ]
//	       }, {
//	         'id': 3,
//	         'title': 'node3',
//	         'enableDisableCssElementText': 'angular-ui-tree-handle',
//	         'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	         'isDisabled': false,
//	         'nodes': [
//	           {
//	             'id': 31,
//	             'title': 'node3.1',
//	             'enableDisableCssElementText': 'angular-ui-tree-handle',
//	             'enableDisableText': $translate.instant('admin.menu.settings.categories.disabled'),
//	             'isDisabled': false,
//	             'nodes': []
//	           }
//	         ]
//	       }];
	    
		  
		  
		
  });