(function (ng) {

    var mod = ng.module("clienteModule");

    mod.constant("clienteContext", "api/clientes");
    mod.controller("clienteDetailCtrl", ["$scope", "$http", "clienteContext", "$state", "dataTransfer",
        function ($scope, $http, clienteContext, $state, dataTransfer) {






            if ($state.params.clienteId !== undefined && $state.params.clienteId !== null) {
                var address = clienteContext + "/" + $state.params.clienteId;


                $http.get(address).then(function (response) {
                    $scope.elCliente = response.data;
                    $scope.compras = response.data.compras;
                    $scope.ventas = response.data.ventas;
                    $scope.mediosDePago = response.data.mediosDePago;
                    $scope.prospectos = response.data.prospectosCompra;
                    $scope.quejas = response.data.quejasReclamos;
                    $scope.calificaciones = response.data.calificacionesTienda;
                });
            }




            $scope.subirInfoCliente = function () {
                dataTransfer.set($scope.cliente);
            };

        }]);




})(window.angular);