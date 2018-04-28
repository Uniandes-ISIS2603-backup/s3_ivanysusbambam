(function(ng){ 
    
var mod = ng.module('marcaModule');
mod.constant("marcaContext", "api/marcas");
mod.controller("marcaListCtrl", ["$scope", "$http", "marcaContext",  function($scope, $http, marcaContext){
         $http.get(marcaContext).then(function(Response){
            $scope.darMarcas = Response.data;
        });
}]);


})(window.angular);