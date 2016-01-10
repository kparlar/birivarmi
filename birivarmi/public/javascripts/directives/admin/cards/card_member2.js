/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardMember2', function ($compile){
		
		'use strict';
		return {
			restrict: 'E',
			transclude: true,
			 replace: true,
			//terminal: true, // prevent ng-repeat from compiled twice
			//priority: 9, // must higher than ng-repeat
			//replace: true,
			scope: 
			{
				member:'=member'
			},
			templateUrl: '/views/admin/templates/card_member.html',
			controller: 'CardMemberCtrl',
		};
	});
			