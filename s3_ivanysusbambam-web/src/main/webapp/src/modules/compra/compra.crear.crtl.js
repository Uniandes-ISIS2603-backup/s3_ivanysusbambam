(function(ng){
    
    var mod = ng.module("compraModule");
    
    mod.constant("compraContext", "api/compras");
    
    mod.controller("compraCrearCtrl", ["$scope", "$http", "compraContext", "$state",
    function($scope, $http, compraContext, $state){
        
        $scope.data={};
        
        
     $http.get("api/clientes").then(function(response){
            $scope.listaClientes = response.data;
        });
           
     $http.get("api/puntosDeVenta").then(function(response){
            $scope.listaPv = response.data;
        });
           
     $http.get("api/vendedores").then(function(response){
            $scope.listaVendedores = response.data;
        });
        
         $scope.crearCompra = function(){
   
            $http.post(compraContext, $scope.data).then(function(response){
                $state.go("AdminCompraGetAll",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);