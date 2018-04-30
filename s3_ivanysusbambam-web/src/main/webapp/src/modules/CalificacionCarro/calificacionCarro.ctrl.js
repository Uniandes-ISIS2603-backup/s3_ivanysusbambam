(function(ng){
    var mod = ng.module("calificacionCarroModule");
    mod.constant("calificacionCarroContext", "api/calificacionesCarro");
    mod.controller("calificacionesCarroCtrl", ["$scope", "$http", "calificacionCarroContext", "$rootScope", "$state",
        function($scope, $http, calificacionCarroContext){
            $http.get("data/calificacionesCarro.json").then(function(response){
                $scope.calificacionesCarro = response.data;
            });
            
            $http.get(calificacionCarroContext).then(function(response){
                $scope.calificacionesCarroBack = response.data;
            });
        }
    ]);
})(window.angular);


