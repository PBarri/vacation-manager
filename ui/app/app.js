'use strict';

// Declare app level module which depends on views, and components
angular
    .module('vm', [
        'ngRoute',
        'vm.index',
        'vm.view2',
        'ngMaterial',
        'md.data.table'
    ])
    .constant('baseUrl', "/vm-api")
    .config(['$locationProvider', '$routeProvider', '$mdThemingProvider', function($locationProvider, $routeProvider, $mdThemingProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider.otherwise({redirectTo: '/index'});
        $mdThemingProvider
            .theme('default')
            .primaryPalette('grey')
            .accentPalette('pink')
            .warnPalette('red')
            .backgroundPalette('grey');
    }])
    .controller('VmController', function($scope) {
    })
;