(function(ng){
    var mod = ng.module("calificacionCarroModule");
    mod.constant("calificacionCarroContext", "api/calificacionesCarro");
    mod.controller("calificacionesCarroCtrl", ["$scope", "$http", "calificacionCarroContext", "$rootScope", "$state",
        function($scope, $http, calificacionCarroContext,$rootScope){
           
            
            $http.get(calificacionCarroContext).then(function(response){
                $scope.calificacionesCarroBack = response.data;
            });
        }
    ]);
})(window.angular);


