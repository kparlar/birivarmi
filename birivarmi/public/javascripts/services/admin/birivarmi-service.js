/**
 * Global Define
 */
angular.module('birivarmiAdminApp')
  .service('BirivarmiService', function ($q, $http, $translate) {
	  
	  var createCategory = function (name, updaterId) {
		  var deferred = $q.defer();
//		  $http.put('http://localhost:8088/birivarmi/birivarmiapp/data/v1/category',
//		          	{'updaterId': updaterId , 'name':name , 'localCode': 'en_US'}
//		          
//		          )
		  $http({
          	method  : 'POST',
          	url     : 'http://localhost:8088/birivarmi/birivarmiapp/data/v1/category',
          	data    : 'updaterId='+updaterId+'&name='+name+'&localCode=en_US', //forms user object
          	headers : {'Content-Type': 'application/x-www-form-urlencoded'}
          
          }).error(function(data, status){
          	  var message = $translate.instant('error.notInserted')+' '+$translate.instant('error.errorMessage');
              var response = {
              		success: false,
              		message: message
              	};
              deferred.resolve(response);
              
              return deferred.promise;
              })
              .success(function(data){
                var response = {
              		  success: true, 
              		  message:"", 
              		  data:data
              		 };
                deferred.resolve(response);
                
                
              });
		  return deferred.promise;
		  

	  };
	  
	  var getCategories = function(){
		  var deferred = $q.defer();
		  $http({
	          	method  : 'GET',
	          	url     : 'http://localhost:8088/birivarmi/birivarmiapp/app/v1/category'
	          
	          }).error(function(data, status){
	          	  var message = $translate.instant('categories')+' '+$translate.instant('error.notGet');
	              var response = {
	              		success: false,
	              		message: message
	              	};
	              deferred.resolve(response);
	              
	              return deferred.promise;
	              })
	              .success(function(dataResponse){
	            	  var data = [];
	            	  for(var i = 0; i < dataResponse.length; i++){
	            		 var tempData = [];
	            		 tempData.id = dataResponse[i].id;
	            		 tempData.descriptions = [];
	            		 var dataDescriptions = dataResponse[i].categoryDescriptionDtos;
	            		 for(var k=0; k < dataDescriptions.length; k++){
	            			 var tempDescription = [];
	            			 tempDescription.name = dataDescriptions[k].name;
	            			 tempDescription.description = dataDescriptions[k].description;
	            			 tempDescription.local =  $translate.instant('local.'+dataDescriptions[k].localCode);
	            			 tempData.descriptions.push(tempDescription);
	            		 }
	            		 tempData.title = dataDescriptions[0].name;
	            		
	            		 
	            		 if(dataResponse[i].enabled ==='T'){
	            			 tempData.isDisabled =  false;
	            			 tempData.enableDisableCssElementText = 'angular-ui-tree-handle';
	            			 tempData.enableDisableText = $translate.instant('admin.menu.settings.categories.disabled');
	            		 }else{
	            			 tempData.isDisabled =  true;
	            			 tempData.enableDisableCssElementText = 'angular-ui-tree-handle-disabled';
	            			 tempData.enableDisableText = $translate.instant('admin.menu.settings.categories.enabled');
	            		 }
	            		 tempData.nodrop= true;
	            		 tempData.nodes=[];
	            		 data.push(tempData);
	            		 
	            	  }
	            	  
	                var response = {
	              		  success: true, 
	              		  message:"", 
	              		  data:data
	              		 };
	                deferred.resolve(response);
	                
	                
	              });
			  return deferred.promise;
	  }
	  
	  return {
		  createCategory: createCategory,
		  getCategories: getCategories
		  };
	  
  });
//define(['angular', 'service-module'], function(angular, services){
//	
//	'use-strict';
//	
//	services.factory('BirivarmiService', ['$http', '$q', function($http, $q){
//		
//		var birivarmiAppDS = VRuntime.services.datasource.get('BirivarmiAppService');
//		var birivarmiDataDS = VRuntime.services.datasource.get('BirivarmiDataService');
//		var birivarmiData = null;
//		return {
//			fetchBirivarmiDetails : function(birivarmiId, refresh){
//				var deferred = $q.defer();
//				/* var refresh = true;*/
//				if(birivarmiData == null || refresh == true){
//					birivarmiDataDS.getById(birivarmiId,{}).done(function(response){
//						birivarmiData = response;
//						deferred.resolve(birivarmiData);
//					}).fail(function(error){
//						console.log("Error: Could not retrieve Birivarmi Details"+status);
//						deferred.resolve({});
//					});
//				}else{
//					deffered.resolve(birivarmiData);
//				}
//				return deferred.promise;
//			}
//			
//		}
//	}]);
//	return services;
//});