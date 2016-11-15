'use strict';

// Declare app level module which depends on views, and components
angular
    .module('vm', [
        'ngRoute',
        'vm.index',
        'vm.view2',
        'ngMaterial'
    ])
    .config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider.otherwise({redirectTo: '/index'});
    }])
    .controller('VmController', function($scope, $mdSidenav) {
        $scope.toggleSidenav = function() {
            $mdSidenav('left').toggle();
        }
        $scope.close = function() {
            $mdSidenav('left').close();
        }
    })
;

function buildToggler(navID) {
    return function() {
        // Component lookup should always be available since we are not using `ng-if`
        $mdSidenav(navID).toggle();
    }
}