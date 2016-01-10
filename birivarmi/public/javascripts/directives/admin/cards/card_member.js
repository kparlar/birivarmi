/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardMember', function ($compile){
		
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
			link: function (scope, element, attrs, ctrlr, transFn) {
				if (angular.isArray(scope.member.children)) {
					var newElement = angular.element("<card-categories categories='member.children'></card-categories>");
					element.append(newElement); 
					$compile(newElement)(scope);
				}
//				 var el = element[0];
//			      
//			      el.draggable = true;
//			      
//			      el.addEventListener('dragstart', function(e) {
//			        e.dataTransfer.effectAllowed = 'move';
//			        e.dataTransfer.clearData('member');
//			        e.dataTransfer.setData('member', this.member);
//			        this.classList.add('drag');
//			        return false;
//			      }, false);
//			      
//			      el.addEventListener('dragend', function(e) {
//			        this.classList.remove('drag');
//			        return false;
//			      }, false);
				
				   // get the content from the transclusion function
		        transFn(scope,function(clone,innerScope){
		          // need to compile the content to make sure we get any HTML that was transcluded
		          var dummy = angular.element('<div></div>');
		          dummy.append($compile(clone)(innerScope));
		          scope.member.content = dummy.html();
		          dummy = null;
		          
		          // remove ng-scope spans/classes & empty class attributes added by angular to get true content
		          scope.member.content = scope.member.content.replace(/<span class="ng\-scope">([^<]+)<\/span>/gi,"$1");
		          scope.member.content = scope.member.content.replace(/\s*ng\-scope\s*/gi,'');
		          scope.member.content = scope.member.content.replace(/\s*class\=\"\"\s*/gi,'');
		        });
		     // save the object's id if there is one
		        if(angular.isDefined(attrs.id))
		          scope.member.id = attrs.id;
		        
		        if(angular.isDefined(attrs.placeholder))
		          scope.member.placeholder = scope.$eval(attrs.placeholder);
		      
		        // setup the options object to pass to jQuery UI's draggable method
		        var opts = (angular.isDefined(attrs.options)) ? scope.$eval(attrs.options) : {};
		        
		        // assign the object's group if any
		        if(angular.isDefined(attrs.group)){
		          scope.member.group = attrs.group;
		          opts.stack = '.' + attrs.group;
		        }
		      
		        var evts = {
		          start: function(evt,ui){
		            if(scope.placeholder)
		              ui.helper.wrap('<div class="dragging"></div>');
		            scope.$apply(function(){ scope.$emit('drag.started',{obj: scope.member}); });
		          },
		          drag: function(evt){
		            scope.$apply(function(){ scope.$emit('drag.dragging',{obj: scope.member}); });
		          },
		          stop: function(evt,ui){
		            if(scope.placeholder)
		              ui.helper.unwrap();
		            scope.$apply(function(){ scope.$emit('drag.stopped',{obj: scope.member}); });
		          }
		        };
		      
		        // combine options passed through element attributes with events
		        var options = $.extend({},opts,evts);
		        element.draggable(options); // make element draggable
				
				
			}
		};
	});
			