/**
 * Global Define
 */
angular.module('birivarmiAdminApp')
  .service('BirivarmiService', function () {
	  return{
	  
	  
	  this.createCategory = funtion (name, updaterId) {
		  $http({
          	method  : 'PUT',
          	url     : 'http://localhost:8088/birivarmi/birivarmiapp/app/v1/category',
          	data    : 'updaterId='+updaterId+'&name='+name+'&localCode=en_US'+, //forms user object
          	headers : {'Content-Type': 'application/x-www-form-urlencoded'}
          
          }).error(function(data, status){
          	  var message = $translate.instant('error.notInserted')+' '+$translate.instant('error.errorMessage');
              var response = {
              		success: false,
              		message: message
              	};
              return response;
              })
              .success(function(data){
                var response = {
              		  success: true, 
              		  message:"", 
              		  data:data
              		 };
                return response;
              });

	  }
	  }
	 
	  
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