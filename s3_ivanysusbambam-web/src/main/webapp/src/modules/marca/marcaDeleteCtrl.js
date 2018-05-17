(function(ng){ 
    
var mod = ng.module('marcaModule');
mod.constant("marcaContext", "api/marcas");
mod.controller("marcaDeleteCtrl", ["$scope", "$http", "marcaContext","$state",  function($scope, $http, marcaContext,$state){
         $http.get(marcaContext).then(function(Response){
            $scope.darMarcas = Response.data;
        });
         $http.delete(marcaContext + '/' + $state.params.idMarca, {}).then(function (response) {
                    $state.go('listMarca', {}, {reload: true});
                });
}]);


})(window.angular);