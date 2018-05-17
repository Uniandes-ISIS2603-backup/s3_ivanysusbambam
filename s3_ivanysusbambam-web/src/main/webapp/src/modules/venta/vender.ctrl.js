(function(ng){
    
   var mod = ng.module("ventaModule");
   
   mod.constant("automovilContext", "api/automoviles");
   mod.controller("venderCtrl", ["$scope","$rootScope","$http", "automovilContext", "$state", 
    function($scope,$rootScope, $http, automovilContext, $state){
            
        $scope.data = {};
       
        
        var address = automovilContext + "/"+$state.params.idAuto;
        $http.get(address).then(function(response){
                $scope.automovil = response.data;
              
            });
            var address2 = "api/clientes" + "/"+$state.params.clienteId;
             $http.get(address2).then(function(response){
                $scope.elCliente = response.data;
               
                
                
            });
        
        $scope.crearVenta = function(){
           
            
            
            if($state.params.idAuto !== undefined && $state.params.idAuto !==null){
            
            
            $http.get(address).then(function(response){
                
                $scope.data.automovil=response.data;
                $scope.data.puntoDeVenta=$scope.automovil.puntoDeVenta;
                $scope.data.idVenta=$scope.automovil.id;
                
            });
        }
        
        if($state.params.clienteId !== undefined && $state.params.clienteId !==null){
            
            
           
            $http.get(address2).then(function(response){
               
                $scope.data.cliente=response.data;

            });
        
        }
        
       $scope.data.medioDePago = $scope.medioDePago;
        
               $http.post("api/ventas", $scope.data).then(function(response){
                   //esto tenia un response, si se quiere mandar excepcion se deberia incluir en la function del then
                   
                  $state.go('ccCrear', {venta:response.data}, {reload: true});
               });  
            };
        
    }]);
            

            
    
})(window.angular);