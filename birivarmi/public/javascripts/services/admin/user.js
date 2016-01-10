////////
// This sample is published as part of the blog article at www.toptal.com/blog
// Visit www.toptal.com/blog and subscribe to our newsletter to read great posts
////////

'use strict';

/**
 * @ngdoc service
 * @name birivarmiApp.user
 * @description
 * # user
 * Service in the birivarmiApp.
 */
angular.module('birivarmiAdminApp')
    .factory('adminUserService', function() {
      var username = '';
      var email = '';
      var authKey = '';
      return {
        username : username
      };
    });
