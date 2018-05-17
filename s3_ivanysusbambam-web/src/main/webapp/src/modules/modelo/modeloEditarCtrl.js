(function (ng) {

    var mod = ng.module("modeloModule");

    mod.constant("modeloContext", "api/modelos");

    mod.controller("modeloEditarCtrl", ["$scope", "$http", "modeloContext", "$state", "dataTransfer",

    function ($scope, $http, modeloContext, $state, dataTransfer) {

            
            console.log("DML");

            $scope.modelo = dataTransfer.get();


            var address = modeloContext + "/" + $state.params.ModeloId;

            $scope.editarModelo = function () {
                $http.put(address, $scope.modelo).then(function (response) {

                    $state.go("listModelo", {}, {
                        reload: true
                    });

                });


            };

            $scope.cambioInfo = function () {
                $scope.modelo.referencia = $scope.nuevaReferencia;
                $scope.modelo.numeroPuertas = $scope.nuevoNumeroPuertas;
                $scope.modelo.cilindraje = $scope.nuevoCilindraje;
                $scope.modelo.transmision = $scope.nuevaTransmision;
            };


    }

    ]);

})(window.angular);
