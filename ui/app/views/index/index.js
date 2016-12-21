'use strict';

angular.module('vm.index', ['ngRoute', 'mwl.calendar']).config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/index', {
    template: require('./index.html'),
    controller: 'IndexController'
  });
}])

.controller('IndexController', ['$scope', 'dataService', function($scope, dataService) {

  $scope.user = undefined;
  $scope.vacations = undefined;
  $scope.events = undefined;
  $scope.calendarView = undefined;
  $scope.viewDate = undefined;

  var init = function() {
    $scope.user = dataService.getUser("t1");
    $scope.vacations = [
      {
        startDate: '10/10/2016',
        endDate: '11/10/2016',
        days: 1,
        year: 2016,
        status: 'Approved'
      },
      {
        startDate: '10/10/2016',
        endDate: '11/10/2016',
        days: 1,
        year: 2016,
        status: 'Approved'
      },
      {
        startDate: '10/10/2016',
        endDate: '11/10/2016',
        days: 1,
        year: 2016,
        status: 'Approved'
      }
    ];

    $scope.calendarView = 'month';
    $scope.events = [];
    $scope.viewDate = new Date();
  }

  init();

}]);