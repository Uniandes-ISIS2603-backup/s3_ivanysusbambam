(function(ng){   
   var mod = ng.module("calificacionCarroModule");
   
   mod.constant("calificacionCarroContext", "api/calificacionesCarro");
   mod.controller("calificacionCarroDetailBackCtrl", ["$scope", "$http", "calificacionCarroContext", "$state","$rootScope", "$filter",
    function($scope, $http,$rootScope, calificacionCarroContext, $state){               
            
        if(($state.params.calificacionCarroBackId !== undefined) && ($state.params.calificacionCarroBackId !==null)){
            var route = calificacionCarroContext + "/"+$state.params.calificacionCarroBackId;
            
            $http.get(route).then(function(response){
                $scope.currentCalificacionCarroBack = response.data;
                $scope.coment = $scope.currentCalificacionCarroBack.comentario.split(":::")[0];
                $scope.rutaImagen = $scope.currentCalificacionCarroBack.comentario.split(":::")[1];
            });
        }
        
    }]);
})(window.angular);



