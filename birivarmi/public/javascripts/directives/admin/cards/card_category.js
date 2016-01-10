/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardCategory', function ($translate){
		
		'use strict';
		return {
			restrict: 'E',
			//replace: true,
			scope: 
			{
				
					title : '@title',
					id: '@id',		  		
				  	isOpen: '&isOpen',
				  	isDisabled: '@isDisabled',
				    enableDisableText: '@enableDisableText',
				    enableDisableCssElementText: '@enableDisableCssElementText'
				
				
			},
			templateUrl: '/views/admin/templates/card_category.html',
			controller: 'CardCategoryCtrl'		
		};
	});
			