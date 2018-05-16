


(function (ng) {

    var mod = ng.module("automovilModule");

    mod.constant("automovilContext", "api/automoviles");

    mod.controller("automovilAdminDeleteCtrl", ["$scope", "$http", "$rootScope", "automovilContext", "$state", function ($scope, $http, $rootScope, automovilContext, $state) {

            $http.get(automovilContext).then(function (response) {
                $scope.automoviles = response.data;

            });

                $http.delete("api/automoviles/"+$state.params.idAuto , {}).then(function (response) {
                    $state.go('adminAutos', {}, {reload: true});
                });
            


        }]);

})(window.angular);