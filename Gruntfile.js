module.exports = function(grunt) {
	grunt.loadNpmTasks("grunt-contrib-concat");
	grunt.loadNpmTasks('grunt-contrib-cssmin');
	grunt.loadNpmTasks('grunt-contrib-uglify');

	grunt.initConfig({
		concat: {
			dist: {
				files: [
					{ src: ['src/main/resources/static/js/*.js'], dest: 'src/main/resources/static/js/main.js' }, 
					{ src: ['src/main/resources/static/css/*.css'], dest: 'src/main/resources/static/css/main.css' }
				]
			}
		},
		uglify: {
			dist: {
				files: [
					{ src: ['src/main/resources/static/js/main.js'], dest: 'src/main/resources/static/js/main-min.js'}
				]
			}
		},
		cssmin: {
			target: {
				files: [
					{ src: ['src/main/resources/static/css/*.css'], dest: 'src/main/resources/static/css/main-min.css' }
				]	
			}
		}
	});
};