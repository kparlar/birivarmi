'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:CardCtrl
 * @description
 * # CardCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
  .controller('CategoriesCtrl', function ($scope, $translate, alertService) {
	 
	  $scope.questionMarkAlertAction = function(){
		  var message_1_1 = $translate.instant('admin.menu.settings.categories.questionmark.message_1.0');
		  var message_1_2 = $translate.instant('admin.menu.settings.categories.questionmark.message_1.1');
		  var message_1_3 = $translate.instant('admin.menu.settings.categories.questionmark.message_1.2');
		  alertService.add('warning', message_1_1);
		  alertService.add('warning', message_1_2);
		  alertService.add('warning', message_1_3);
	  }
	  
	  
	  $scope.tasks = [
		          		{
		          			title : 'ForSale 1',
		          			id: '1',		  		
		          		  	isOpen: false,
		          		  	isDisabled: false,
		          		    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
		          		    enableDisableCssElementText: 'enabled',
		          		    children: [
		       	          				{
		       	          					title : 'ForSale 2',
		       	    	          			id: '2',		  		
		       	    	          		  	isOpen: false,
		       	    	          		  	isDisabled: false,
		       	    	          		    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
		       	    	          		    enableDisableCssElementText: 'enabled',
		       	    	          		    children: [
       	    	          		               {
												title : 'ForSale 7',
												id: '7',		  		
											  	isOpen: false,
											  	isDisabled: false,
											    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
											    enableDisableCssElementText: 'enabled',
											    children: [
													{
														title : 'ForSale 8',
														id: '8',		  		
													  	isOpen: false,
													  	isDisabled: false,
													    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
													    enableDisableCssElementText: 'enabled',
													    children: []
													        }      
											    ]
       	    	          		               }       
		       	    	          		    ]
		       	          				}
		       	          				]
	          		    	
		          		}, 
		          		{
		          			title : 'ForSale 3',
		          			id: '3',		  		
		          		  	isOpen: false,
		          		  	isDisabled: false,
		          		    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
		          		    enableDisableCssElementText: 'enabled',
		          		    children: [
		       	          				{
		       	          					title : 'ForSale 4',
		       	    	          			id: '4',		  		
		       	    	          		  	isOpen: false,
		       	    	          		  	isDisabled: false,
		       	    	          		    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
		       	    	          		    enableDisableCssElementText: 'enabled',
		       	    	          		    children: []
		       	          				}
		       	          				]
		          		    	
		          		}, 
		          		{
		          			title : 'ForSale 5',
		          			id: '5',		  		
		          		  	isOpen: false,
		          		  	isDisabled: false,
		          		    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
		          		    enableDisableCssElementText: 'enabled',
		          		    children: [
		       	          				{
		       	          					title : 'ForSale 6',
		       	    	          			id: '6',		  		
		       	    	          		  	isOpen: false,
		       	    	          		  	isDisabled: false,
		       	    	          		    enableDisableText: $translate.instant('admin.menu.settings.categories.disabled'),
		       	    	          		    enableDisableCssElementText: 'enabled',
		       	    	          		    children: []
		       	          				}
		       	          				]
		          		    	
		          		}
		          	];
		  
		  
		
  });