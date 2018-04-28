(function(ng) {
    var mod = ng.module("puntoVentaModule");
    mod.constant("puntoVentaContext", "api/puntosDeVenta");
    mod.controller("puntosVentaMasterCtrl",
        ["$scope", "$http",
        "puntoVentaContext","$rootScope","$state",
        function($scope, $http, puntoVentaContext, $state){
            
            $http.get("data/puntoVenta.json").then(function(response){
                $scope.puntosDeVenta = response.data;
               });
            
            $http.get(puntoVentaContext).then(function(response){
                $scope.puntosDeVentaBack = response.data;
            });
        }
    ]);
})(window.angular);


