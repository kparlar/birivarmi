////////
// This sample is published as part of the blog article at www.toptal.com/blog
// Visit www.toptal.com/blog and subscribe to our newsletter to read great posts
////////

'use strict';

/**
 * @ngdoc function
 * @name birivarmiAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the birivarmiAdminApp
 */
angular.module('birivarmiAdminApp')
    .controller('MainCtrl', function ($scope, $http) {
      $scope.getPosts = function() {
        $http.get('/admin/posts')
            .success(function(data) {
              $scope.posts = data;
            });
      };

      $scope.getPosts();

    });
