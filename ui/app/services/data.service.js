/**
 * Created by pablo on 21/12/16.
 */
'use strict';

angular.module('vm').factory('dataService', ['$http', function($http) {
    var service = {
        getUser : getUser
    };

    return service;

    function getUser(userId) {
        return $http({
            method: "POST",
            url: 'http://localhost:8080/vm-api/profile/userData',
            data: userId
        }).then(function(response) {
            return response.data;
        });
    }
}]);