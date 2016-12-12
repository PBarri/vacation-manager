'use strict';

angular.module('vm.index', ['ngRoute', 'mwl.calendar']).config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/index', {
    template: require('./index.html'),
    controller: 'IndexController'
  });
}])

.controller('IndexController', function($scope) {
  $scope.user =
    {
      name: 'Pablo Barrientos',
      vacationDays: 22,
      team: 'Crossfield'
    };

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
});