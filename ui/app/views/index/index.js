'use strict';

angular.module('vm.index', ['ngRoute']).config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/index', {
    template: require('./index.html'),
    controller: 'IndexController'
  });
}])

.controller('IndexController', [function() {

}]);