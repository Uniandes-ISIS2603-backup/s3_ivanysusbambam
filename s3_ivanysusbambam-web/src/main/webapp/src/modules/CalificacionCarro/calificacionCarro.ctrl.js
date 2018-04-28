(function (ng){
    var mod = ng.module("calificacionCarroModule");
    mod.constant("calificacionCarroContext", "api/calificacionCarro");
    mod.controller('calificacionCarroSenseiCtrl', ['$scope', '$http', 'calificacionCarroContext',
        function($scope, $http, $calificacionCarroContext){
            $http.get("data/calificacionCarro.json").then(function(response){
                $scope.calificacionesCarro = response.data;
            });
        }
]);
})(window.angular);


