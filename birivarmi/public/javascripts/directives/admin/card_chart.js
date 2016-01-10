/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardChart', function (){
		
		'use strict';
		return {
			restrict: 'E',
			//replace: true,
			scope: 
			{
				header : '@header',
				subheader: '@subheader',
				footerlink:'@footerlink',
				footerlinktitle:'@footerlinktitle',
				labels: '=labels',
				series: '=series',
				data: '=data'
			},
			templateUrl: '/views/admin/templates/card_chart.html',
			controller: 'CardChartCtrl'		
		};
	});
			