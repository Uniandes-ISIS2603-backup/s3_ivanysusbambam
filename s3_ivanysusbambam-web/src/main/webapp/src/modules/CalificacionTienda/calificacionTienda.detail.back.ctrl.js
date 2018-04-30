(function(ng){   
   var mod = ng.module("calificacionTiendaModule");
   
   mod.constant("calificacionTiendaContext", "api/calificacionesTienda");
   mod.controller("calificacionTiendaDetailBackCtrl", ["$scope", "$http", "calificacionTiendaContext", "$state", "$filter",
    function($scope, $http, calificacionTiendaContext, $state){               
            
        if(($state.params.calificacionTiendaBackId !== undefined) && ($state.params.calificacionTiendaBackId !==null)){
            var route = calificacionTiendaContext + "/"+$state.params.calificacionTiendaBackId;
            
            $http.get(route).then(function(response){
                $scope.currentCalificacionTiendaBack = response.data;
                //$scope.coment = $scope.currentCalificacionTiendaBack.comentario.split(":::")[0];
                //$scope.rutaImagen = $scope.currentCalificacionTiendaBack.comentario.split(":::")[1];
                //console.log($scope.rutaImagen);
            });
        }
        
    }]);
})(window.angular);



