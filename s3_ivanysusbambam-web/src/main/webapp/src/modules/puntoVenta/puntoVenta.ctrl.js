(function(ng) {
    var mod = ng.module("puntoVentaModule");
    mod.constant("puntoVentaContext", "api/puntoVenta");
    mod.controller('puntosVentaMasterCtrl', ['$scope', '$http', 'puntoVentaContext',
        function ($scope, $http, puntoVentaContext){
            $http.get("data/puntoVenta.json").then(function(response){
                $scope.puntosDeVenta = response.data;
            });
        }
    ]);
})(window.angular);


