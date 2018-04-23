(function(ng){
    
    var mod = ng.module("pcModule");
    
    mod.constant("pcContext", "api/prospectoscompra");
    
    mod.controller("pcCrearCtrl", ["$scope", "$http", "pcContext", "$state",
    function($scope, $http, pcContext, $state){
        
        $scope.data={};
        
        $scope.idVendedor = null;
        $scope.idCliente =null;
        $scope.idAutomovil = null;
        
        $scope.buscarVendedor = function(){
            
            if($scope.idVendedor !== undefined && $scope.idVendedor !== null){
                $http.get("api/vendedores/"+$scope.idVendedor).then(function(response){
               
                    var vendedorDDto = response.data;
                
                    var vendedorDto = {
                    
                        carnetVendedor: vendedorDDto.carnetVendedor,
                        cedula: vendedorDDto.cedula,
                        nombre: vendedorDDto.nombre
                    
                    };
       
                    $scope.data.vendedor = vendedorDto;
              });
          }
        };
        
        $scope.buscarCliente = function(){
          
          if($scope.idCliente !== undefined && $scope.idCliente !== null){
                $http.get("api/clientes/"+$scope.idCliente).then(function(response){
                    
                    var clienteDDto = response.data;
                    
                    var clienteDto = {
                      cedula: clienteDDto.cedula,
                      nombre: clienteDDto.nombre
                    };
                    
                    $scope.data.cliente = clienteDto;
                });
            
          }
        };
        
        $scope.buscarAutomovil = function(){
            
            if($scope.idAutomovil !== undefined && $scope.idAutomovil !== null){
                $http.get("api/automoviles/"+$scope.idAutomovil).then(function(response){
                    
                    var automovilDDto = response.data;
                    
                    var automovilDto = {
                        
                        anio: automovilDDto.anio,
                        chasis: automovilDDto.chasis,
                        color: automovilDDto.color,
                        id: automovilDDto.id,
                        name: automovilDDto.name,
                        placa: automovilDDto.placa,
                        valorListado: automovilDDto.valorListado
                        
                    };
                    
                    $scope.data.automovil = automovilDto;
                });
            
          }
        };
        
        $scope.crearPc = function(){
          
            //Id que será reemplazado por el autogenerado
            $scope.data.id = Number.MAX_SAFE_INTEGER;
            
            console.log($scope.data);
            
            $http.post(pcContext, $scope.data).then(function(response){
                $state.go("listPc",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);