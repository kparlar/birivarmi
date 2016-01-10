angular.module('birivarmiAdminApp')
   .controller('SignupCtrl', function ($scope, $http, $log) {
	 $scope.date = new Date();
     $scope.signup = function() {
       var payload = {
         email : $scope.email,
         password : $scope.password
       };

       $http.post('/admin/signup', payload)
           .success(function(data) {
             $log.debug(data);
           });
     };
   });