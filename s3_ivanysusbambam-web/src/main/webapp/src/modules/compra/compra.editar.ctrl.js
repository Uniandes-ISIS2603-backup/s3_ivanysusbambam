(function (ng) {

    var mod = ng.module("compraModule");

    mod.constant("compraContext", "api/clientes");

    mod.controller("compraEditarCtrl", ["$scope", "$http", "compraContext", "$rootScope", "$state", "dataTransfer",

    function ($scope, $http, compraContext, $rootScope, $state, dataTransfer, $route) {

            $scope.compra = dataTransfer.get();

            var address = clienteContext + "/" + $state.params.clienteId;


            $scope.editarCompra = function () {
                $http.put(address, $scope.compra).then(function (response) {});
            };
    }
    ]);
})(window.angular);
