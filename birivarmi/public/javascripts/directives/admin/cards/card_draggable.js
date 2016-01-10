/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardDraggable', function ($compile, $rootScope, $log){
		
		'use strict';
		return {
			restrict: 'E',
			//terminal: true, // prevent ng-repeat from compiled twice
			//priority: 9, // must higher than ng-repeat
			//replace: true,
			scope:{
				title:"@title",
				content:"@content"
			},
			templateUrl: '/views/admin/templates/card.html',
			compile: function compile(tElement, tAttrs, transclude) {
		      return {
		        post: function preLink(scope, iElement, iAttrs, controller) { 
		        	 var el = iElement[0];
				      
				      el.draggable = true;
				      
				      el.addEventListener('dragstart', function(e) {
				        e.dataTransfer.effectAllowed = 'move';
				        //e.dataTransfer.clearData('Text');
				        e.dataTransfer.setData('Text', this);
				        $log.debug("Text: "+this.id);
				        this.classList.add('drag');
				        return false;
				      }, false);
				      
				      el.addEventListener('dragend', function(e) {
				        this.classList.remove('drag');
				        return false;
				      }, false);
		        }
		        }
		        //post: function postLink(scope, iElement, iAttrs, controller) { ... }
		      }
			
		}
	});
	
			