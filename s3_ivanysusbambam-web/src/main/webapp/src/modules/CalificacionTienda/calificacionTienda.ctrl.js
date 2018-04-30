(function(ng){
    var mod = ng.module("calificacionTiendaModule");
    mod.constant("calificacionTiendaContext", "api/calificacionesTienda");
    mod.controller("calificacionesTiendaCtrl", ["$scope", "$http", "calificacionTiendaContext", "$rootScope", "$state",
        function($scope, $http, calificacionTiendaContext){
            $http.get("data/calificacionesTienda.json").then(function(response){
                $scope.calificacionesTienda = response.data;
            });
        }
    ]);
})(window.angular);


