/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardCategories', function ($translate){
		
		'use strict';
		return {
			restrict: 'E',
			//replace: true,
			scope: 
			{
				categories:'=categories'
			},
			templateUrl: '/views/admin/templates/card_categories.html',
			controller: 'CardCategoriesCtrl'		
		};
	});
			