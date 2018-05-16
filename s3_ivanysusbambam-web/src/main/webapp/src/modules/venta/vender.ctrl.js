(function(ng){
    
   var mod = ng.module("ventaModule");
   
   mod.constant("automovilContext", "api/automoviles");
   mod.controller("venderCtrl", ["$scope","$rootScope","$http", "automovilContext", "$state", 
    function($scope,$rootScope, $http, automovilContext, $state){
            
        $scope.data = {};
        
        if($state.params.idAuto !== undefined && $state.params.idAuto !==null){
            var address = automovilContext + "/"+$state.params.idAuto;
            
            $http.get(address).then(function(response){
                $scope.automovil = response.data;
                $scope.data.automovil=response.data;
                $scope.data.puntoDeVenta=$scope.automovil.puntoDeVenta;
                $scope.data.idVenta=$scope.automovil.id;
            });
        }
        
        if($state.params.clienteId !== undefined && $state.params.clienteId !==null){
            var address2 = "api/clientes" + "/"+$state.params.clienteId;
            
           
            $http.get(address2).then(function(response){
                $scope.elCliente = response.data;
                $scope.data.cliente=response.data;
                
                
            });
            
                
         
            
        }
        $scope.crearVenta = function(){
               $http.post("api/ventas", $scope.data).then(function(){
                   //esto tenia un response, si se quiere mandar excepcion se deberia incluir en la function del then
                  $state.go("adminVentaGetAll", {reload: true}); 
               });  
            };
        
    }]);
            

            
    
})(window.angular);