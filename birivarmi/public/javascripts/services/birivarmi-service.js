/**
 * Global Define
 */

define(['angular', 'service-module'], function(angulear, services){
	
	'use-strict';
	
	services.factory('BirivarmiService', ['$http', '$q', function($http, $q){
		
		var birivarmiAppDS = VRuntime.services.datasource.get('BirivarmiAppService');
		var birivarmiDataDS = VRuntime.services.datasource.get('BirivarmiDataService');
		var birivarmiData = null;
		return {
			fetchBirivarmiDetails : function(birivarmiId, refresh){
				var deferred = $q.defer();
				/* var refresh = true;*/
				if(birivarmiData == null || refresh == true){
					birivarmiDataDS.getById(birivarmiId,{}).done(function(response){
						birivarmiData = response;
						deferred.resolve(birivarmiData);
					}).fail(function(error){
						console.log("Error: Could not retrieve Birivarmi Details"+status);
						deferred.resolve({});
					});
				}else{
					deffered.resolve(birivarmiData);
				}
				return deferred.promise;
			}
			
		}
	}]);
	return services;
});