/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardStatistic', function (){
		
		'use strict';
		return {
			restrict: 'E',
			//replace: true,
			scope: 
			{
				title1: '@title1',
				title2: '@title2',
				title3: '@title3',
				selections: '=',
				selected:'=',
				showselection: '@showselection',
				showtitle:'@showtitle',				
				footerlink:'@footerlink',
				footerlinktitle:'@footerlinktitle',
				labels: '=labels',
				series: '=series',
				data: '=data'
				
				
			},
			templateUrl: '/views/admin/templates/card_statistic.html',
			controller: 'CardStatisticCtrl'		
		};
	});
			