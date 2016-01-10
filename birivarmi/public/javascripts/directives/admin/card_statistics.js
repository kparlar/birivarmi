/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardStatistics', function (){
		
		'use strict';
		return {
			restrict: 'E',
			//replace: true,
			scope: 
			{
				title1: '@title1',
				cardobjects: '=cardobjects',
				selections: '=',
				selectedchart: '=',
				showselection: '@showselection',
				showtitle:'@showtitle',				
				
			},
			templateUrl: '/views/admin/templates/card_statistics.html',
			controller: 'CardStatisticsCtrl'		
		};
	});
			