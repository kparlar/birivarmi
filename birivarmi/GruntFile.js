module.exports = function(grunt) {
	'use strict';
	
	//local server ports
	var LIVERELOAD_PORT = 35724;
	var SERVER_PORT = 9000;
	var RUNNER_PORT = 9002;
	
	//Project Config
	var CONFIG = {
		name: 'birivarmi',
		app:	'public',
		test:	'test',
		server:	'server',
		src:	'public/javascripts',
		dist:	'dist',
		bower:	'public/bower_components',
		tmp:	'.tmp',
		artifactory: {
			
		}
	};
	
  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    config: CONFIG,
    
  //Concat task
    concat: {
  	  options:{
  	  	//banner : '<%= meta.banner %>',
  		  stripBanners: true
  	  },
  	  dist: {
  		  src: [ '<%= config.src %>/<%= pkg.name %>.js'],
  		  dest: '<%= config.dist %>/<%= pkg.name %>.js'
  	  }
    },
    
    
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      build: {
        src: '<%= concat.dist.dest %>',
        dest: '<%= config.dist %>/<%= pkg.name %>.min.js'
      }
    }
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-contrib-uglify');

  // Default task(s).
  grunt.registerTask('default', ['uglify']);
  

};