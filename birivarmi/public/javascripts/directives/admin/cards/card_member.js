/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardMember', function ($compile){
		
		'use strict';
		return {
			restrict: 'E',
			//terminal: true, // prevent ng-repeat from compiled twice
			//priority: 9, // must higher than ng-repeat
			//replace: true,
			scope: 
			{
				member:'=member'
			},
			templateUrl: '/views/admin/templates/card_member.html',
			controller: 'CardMemberCtrl',
			link: function (scope, element, attrs) {
				if (angular.isArray(scope.member.children)) {
					var newElement = angular.element("<card-categories categories='member.children'></card-categories>");
					element.append(newElement); 
					$compile(newElement)(scope);
				}
				 var el = element[0];
			      
			      el.draggable = true;
			      
			      el.addEventListener('dragstart', function(e) {
			        e.dataTransfer.effectAllowed = 'move';
			        e.dataTransfer.clearData('member');
			        e.dataTransfer.setData('member', this.member);
			        this.classList.add('drag');
			        return false;
			      }, false);
			      
			      el.addEventListener('dragend', function(e) {
			        this.classList.remove('drag');
			        return false;
			      }, false);
				
				
			}
		};
	});
			