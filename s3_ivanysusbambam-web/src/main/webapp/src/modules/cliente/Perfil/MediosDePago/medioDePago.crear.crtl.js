(function(ng){
    
    var mod = ng.module("medioDePagoModule");
    
    mod.constant("medioDePagoContext", "api/mediosDePago");
    
    mod.controller("medioDePagoCreateClienteCtrl", ["$scope", "$http", "medioDePagoContext", "$state",
    function($scope, $http, medioDePagoContext, $state){
        
        
        
         $http.get("api/clientes/"+$state.params.clienteId).then(function(response){
          
             $scope.data.cliente = response.data;
           
            
        });
     $scope.data={};
        
         $scope.crearMdp = function(){
          
            //Id que será reemplazado por el autogenerado
                        
            $http.post(medioDePagoContext, $scope.data).then(function(response){
                $state.go("mediosDePagoCliente("+$state.params.clienteId+")",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);