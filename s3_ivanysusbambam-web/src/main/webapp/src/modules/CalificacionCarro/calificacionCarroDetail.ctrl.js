(function(ng){
    var mod = ng.module("calificacionCarroModule");
    mod.constant("calificacionCarroContext", "api/calificacionCarro");
    mod.controller('calificacionCarroDetailCtrl', ['$scope' ,'$http' ,'calificacionCarroContext' ,'$state', '$filter', 'dataTransfer',
        function($scope, $http, calificacionCarroContext, $state, $filter){
            if (($state.params.calificacionCarroId !== undefined) && ($state.params.calificacionCarroId !== null)) {
                $http.get('data/calificacionCarro.json').then(function (response) {
                    $scope.calificacionesCarro = response.data;
                });
            }
        }
    ]);
})(window.angular);


