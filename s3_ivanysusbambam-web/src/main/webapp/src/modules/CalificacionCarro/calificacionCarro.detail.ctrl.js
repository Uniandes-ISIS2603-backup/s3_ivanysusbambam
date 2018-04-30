(function(ng){   
   var mod = ng.module("calificacionCarroModule");
   
   mod.constant("calificacionCarroContext", "api/calificacionesCarro");
   mod.controller("calificacionCarroDetailCtrl", ["$scope", "$http", "calificacionCarroContext", "$state", "$filter",
    function($scope, $http, calificacionCarroContext, $state, $filter){               
        if(($state.params.calificacionCarroId !== undefined) && ($state.params.calificacionCarroId !==null)){
            
            $http.get("data/calificacionesCarro.json").then(function(response){
                $scope.calificacionesCarro = response.data;
                $scope.currentCalificacionCarro= $filter('filter')($scope.calificacionesCarro, {id: $state.params.calificacionCarroId}, true)[0];
            });
            
        }
    }]);
})(window.angular);


