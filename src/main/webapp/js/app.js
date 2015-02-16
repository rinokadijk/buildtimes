var app = angular.module('wastedTimeApp', ['chart.js']);

app.run(function ($rootScope) {
    'use strict';
    $rootScope.resourcePath = '/buildtimes/resources/';
});

app.controller('WastedTimePerScriptCtrl', function ($scope, $rootScope, $http) {
    'use strict';

    var resourceUrl = $rootScope.resourcePath + 'builds';

    $scope.series = ['Test'];
    $scope.labels = [];

    $http({
        method: 'GET',
        url: resourceUrl
    }).success(function (data) {
        $scope.data = [data.map(function (run) {
           return run.duration; 
        })];
        $scope.labels = data.map(function (run) {
           return run.date; 
        });
    }).error(function (data) {
        // ignore
    });
});

app.controller('WastedTimePerScriptCumulativeCtrl', function ($scope, $rootScope, $http) {
    'use strict';

    var resourceUrl = $rootScope.resourcePath + 'builds/cumulative';

    $scope.series = [];
    $scope.labels = ['Cumulative time wasted per script'];

    $http({
        method: 'GET',
        url: resourceUrl
    }).success(function (data) {
        var durationsPerScript = data.durationPerScript.entry;
        $scope.data = durationsPerScript.map(function (dps) {
           return [dps.value]; 
        });
        $scope.series = durationsPerScript.map(function (dps) {
           return dps.key; 
        });
    }).error(function (data) {
        // ignore
    });
});




