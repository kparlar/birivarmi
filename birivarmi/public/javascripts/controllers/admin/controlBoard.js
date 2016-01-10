'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
.controller('ControlBoardCtrl',   function ($scope, adminUserService, $location, $log, $http, $window, $translate) {
	 $scope.statistics = [
			              {id:'0' , value: $translate.instant('admin.controlBoard.card.2.statistics.id.1.value')},
			              {id:'1' , value: $translate.instant('admin.controlBoard.card.2.statistics.id.2.value')}
			              ];
	 $scope.selectedchart= null;
	 $scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
	  $scope.series = ['Series A', 'Series B'];

	  $scope.data = [
	    [65, 59, 80, 81, 56, 55, 40],
	    [28, 48, 40, 19, 86, 27, 90]
	  ];
	  $scope.onClick = function (points, evt) {
	    console.log(points, evt);
	  };
	
	$scope.cardobjects = [{
				
					title2: "title2_1",
					title3: "title3_1",
					footerlink: "footerlink_1",
					footerlinktitle: "footerlinktitle_1",
					labels:$scope.labels,
					series: $scope.series,
					data:$scope.data,
					showchart:false
				},
				{
					title2: "title2_2",
					title3: "title3_2",
					footerlink: "footerlink_2",
					footerlinktitle: "footerlinktitle_2",
					labels:$scope.labels,
					series: $scope.series,
					data:$scope.data,	
					showchart:true
				}
			
	];
	  
	  
    $scope.isAuthenticated = function() {
  	  $log.debug("ControlBoardCtrl");
  	 var email = $location.path();
  	 
     var authKey = $location.search();
     $log.debug("email"+email+"; authKey:"+authKey);
//     if(autKey!=null) {
//       $log.debug("Username:"+adminUserService.username+"; Email: "+email+";AuthKey:"+autKey);
//       $http({
//       	method  : 'GET',
//       	url     : 'http://localhost:8088/birivarmi/birivarmiapp/app/v1/admin/isAuthenticated',
//       	data    : 'email='+this.email+'&authKey='+this.password, //forms user object
//       	headers : {'Content-Type': 'application/x-www-form-urlencoded'}
//       
//       }).error(function(data, status){
//       	$window.location.href = 'http://localhost:9000/views/admin/index.html';
//       	})
//           .success(function(data){
//           	 adminUserService.username = data.username;
//           	 adminUserService.email = data.email;
//           	 adminUserService.authKey = data.authenticateKey;
//           });
//     }else{
//   	  $window.location.href = 'http://localhost:9000/views/admin/index.html';
//     }
  };

  //$scope.isAuthenticated();	
  
  var parseLocation = function(location) {
	    var pairs = location.substring(1).split("&");
	    var obj = {};
	    var pair;
	    var i;

	    for ( i in pairs ) {
	      if ( pairs[i] === "" ) continue;

	      pair = pairs[i].split("=");
	      obj[ decodeURIComponent( pair[0] ) ] = decodeURIComponent( pair[1] );
	    }

	    return obj;
	  };

});