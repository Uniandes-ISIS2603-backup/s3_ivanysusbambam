(function(ng){
    
    var mod = ng.module("pcModule");
    
    mod.constant("pcContext", "api/prospectoscompra");
    
    mod.controller("pcCrearCtrl", ["$scope", "$http", "pcContext", "$state",
    function($scope, $http, pcContext, $state){
        
        $scope.data={};
        
        
        $http.get("api/vendedores").then(function(response){
          
               $scope.listaVendedores=response.data;
               
        });
        
        $http.get("api/clientes").then(function(response){
            $scope.listaClientes = response.data;
        });
        
        $http.get("api/automoviles").then(function(response){
            $scope.listaAutos = response.data;
        });
        
        $scope.crearPc = function(){
          
            //Id que será reemplazado por el autogenerado
            $scope.data.id = Number.MAX_SAFE_INTEGER;
            
            $http.post(pcContext, $scope.data).then(function(response){
                $state.go("listPc",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);