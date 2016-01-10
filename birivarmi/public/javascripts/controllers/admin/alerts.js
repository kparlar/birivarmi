////////
// This sample is published as part of the blog article at www.toptal.com/blog
// Visit www.toptal.com/blog and subscribe to our newsletter to read great posts
////////
'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:AlertsCtrl
 * @description
 * # AlertsCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
  .controller('AlertsCtrl', function ($scope, alertService) {
      $scope.alerts = alertService.get();
  });
