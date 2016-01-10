/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('card', function (){
		
		'use strict';
		return {
			restrict: 'E',
			//replace: true,
			scope: 
			{
				title : '@title',
			},
			templateUrl: '/views/admin/templates/card.html',
			controller: 'CardCtrl'		
		};
	});
			