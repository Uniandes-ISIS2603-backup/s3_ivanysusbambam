(function(ng){
    
    var mod = ng.module("compraModule");
    
    mod.constant("compraContext", "api/compras");
    
    mod.controller("compraCrearCtrl", ["$scope", "$http", "compraContext", "$state",
    function($scope, $http, compraContext, $state){
        
        $scope.data={};
        
        
     $http.get("api/clientes").then(function(response){
            $scope.listaClientes = response.data;
        });
        
         $scope.crearCompra = function(){
   
            
            console.log($scope.data);
            
            $http.post(compraContext, $scope.data).then(function(response){
                $state.go("AdminCompraGetAll",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);