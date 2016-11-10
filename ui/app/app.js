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
        $scope.toggleLeft = buildDelayedToggler('left');
        $scope.close = function() {
            $mdSidenav('left').close();
        }
    })
;


/**
 * Supplies a function that will continue to operate until the
 * time is up.
 */
function debounce(func, wait, context) {
    var timer;

    return function debounced() {
        var context = $scope,
            args = Array.prototype.slice.call(arguments);
        $timeout.cancel(timer);
        timer = $timeout(function() {
            timer = undefined;
            func.apply(context, args);
        }, wait || 10);
    };
}

/**
 * Build handler to open/close a SideNav; when animation finishes
 * report completion in console
 */
function buildDelayedToggler(navID) {
    return debounce(function() {
        // Component lookup should always be available since we are not using `ng-if`
        $mdSidenav(navID).toggle();
    }, 200);
}

function buildToggler(navID) {
    return function() {
        // Component lookup should always be available since we are not using `ng-if`
        $mdSidenav(navID).toggle();
    }
}