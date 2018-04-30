(function(ng){   
   var mod = ng.module("calificacionTiendaModule");
   
   mod.constant("calificacionTiendaContext", "api/calificacionesTienda");
   mod.controller("calificacionTiendaDetailCtrl", ["$scope", "$http", "calificacionTiendaContext", "$state", "$filter",
    function($scope, $http, calificacionTiendaContext, $state, $filter){               
        if(($state.params.calificacionTiendaId !== undefined) && ($state.params.calificacionTiendaId !==null)){
            
            $http.get("data/calificacionesTienda.json").then(function(response){
                $scope.calificacionesTienda = response.data;
                $scope.currentCalificacionTienda = $filter('filter')($scope.calificacionesTienda, {id: $state.params.calificacionTiendaId}, true)[0];
            });
        }
    }]);
})(window.angular);


