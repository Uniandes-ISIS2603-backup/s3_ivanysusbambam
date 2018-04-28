(function (ng) {
    var mod = ng.module("puntoVentaModule");
    mod.constant("puntoVentaContext", "api/puntosDeVenta");
    mod.controller('puntoVentaDetailCtrl', ['$scope', '$http', 'puntoVentaContext', '$state', '$filter',
        function ($scope, $http, puntoVentaContext, $state, $filter) {

            if (($state.params.puntoVentaId !== undefined) && ($state.params.puntoVentaId !== null)) {
                $http.get('data/puntoVenta.json').then(function (response) {
                    $scope.puntosDeVenta = response.data;
                    $scope.currentPuntoVenta = $filter('filter')($scope.puntosDeVenta, {id: $state.params.puntoVentaId}, true)[0];
                });
            }
        }
    ]);
}
)(window.angular);


