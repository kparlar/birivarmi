/**
 * 
 */
angular.module('birivarmiAdminApp')
	.directive('cardDroppable', function (){
		
		'use strict';
		return {
			restrict: 'E',
	        scope: {
	        	 drop: '&' // parent
	        },
	        link: function(scope, element) {
	            // again we need the native object
	            var el = element[0];
	            el.addEventListener(
	            	    'dragover',
	            	    function(e) {
	            	        e.dataTransfer.dropEffect = 'move';
	            	        // allows us to drop
	            	        if (e.preventDefault) e.preventDefault();
	            	        this.classList.add('over');
	            	        return false;
	            	    },
	            	    false
	            	);
	            el.addEventListener(
	            	    'dragenter',
	            	    function(e) {
	            	        this.classList.add('over');
	            	        return false;
	            	    },
	            	    false
	            	);

	            	el.addEventListener(
	            	    'dragleave',
	            	    function(e) {
	            	        this.classList.remove('over');
	            	        return false;
	            	    },
	            	    false
	            	);
	            	el.addEventListener(
	            		    'drop',
	            		    function(e) {
	            		        // Stops some browsers from redirecting.
	            		        if (e.stopPropagation) e.stopPropagation();

	            		        this.classList.remove('over');

	            		        var item = document.getElementById(e.dataTransfer.getData('Text'));
	            		        this.appendChild(item);
	            		        
	            		        //Note the use of $apply(), if we simply did scope.drop() an error would occur 
	            		        //if no drop attribute was present, using $apply() prevents this.
	            		        
	            		        //call the drop passed drop function
	                            scope.$apply('drop()');
	                            
	            		        return false;
	            		    },
	            		    false
	            		);
	        }
	    };
	});
			