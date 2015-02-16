var app = angular.module('wastedHoursApp', ['chart.js']);

app.run(function ($rootScope) {
    'use strict';
    $rootScope.resourcePath = '/buildtimes/resources/';
});

app.controller('WastedHoursPerScriptCtrl', function ($scope, $rootScope, $http) {
    'use strict';

    var resourceUrl = $rootScope.resourcePath + 'builds';

    $scope.series = ['Test'];
    $scope.labels = [];

    $http({
        method: 'GET',
        url: resourceUrl
    }).success(function (data) {
        console.log(data);
        $scope.data = [data.map(function (run) {
           return run.duration; 
        })];
        $scope.labels = data.map(function (run) {
           return run.id; 
        });
        console.log($scope.labels);
        console.log($scope.data);
    }).error(function (data) {
        // ignore
    });
});




