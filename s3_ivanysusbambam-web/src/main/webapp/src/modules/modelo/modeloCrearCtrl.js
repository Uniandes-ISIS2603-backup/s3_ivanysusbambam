(function (ng) {

    var mod = ng.module("modeloModule");

    mod.constant("modeloContext", "api/modelos");

    mod.controller("modeloCrearCtrl", ["$scope", "$http", "modeloContext", "$state",

                                      function ($scope, $http, modeloContext, $state) {

            $scope.crearModelo = function () {

                $scope.data = {
                    referencia: $scope.nombre,
                    numeroPuertas:$scope.numeroPuertas,
                    transmision:$scope.transmision,
                    cilindraje:$scope.cilindraje
                };

                $http.post(modeloContext, $scope.data).then(function (response) {
                    $state.go("listModelo", {
                        reload: true
                    });
                });
            };

    }]);

})(window.angular);