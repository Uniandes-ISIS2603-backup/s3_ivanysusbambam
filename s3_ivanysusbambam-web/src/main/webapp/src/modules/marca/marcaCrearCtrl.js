(function (ng) {

    var mod = ng.module("marcaModule");

    mod.constant("marcaContext", "api/marcas");

    mod.controller("marcaCrearCtrl", ["$scope", "$http", "marcaContext", "$rootScope", "$state",

        function ($scope, $http, marcaContext, $rootScope, $state) {

            $scope.data = {};
            $scope.crearMarca = function () {



                $http.post(marcaContext, $scope.data).then(function (response) {
                    $state.go("listMarca", {
                        reload: true
                    });
                });
            };

        }]);

})(window.angular);
