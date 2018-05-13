(function(ng){
    
    var mod = ng.module("clienteModule");
    mod.constant("calificacionTiendaContext", "api/calificacionesTienda");
    
    mod.controller("editarComentarioCtrl", ["$scope", "$http", "calificacionTiendaContext", "$state", "dataTransfer", 
    function ($scope, $http, calificacionTiendaContext, $state, dataTransfer){
     
        $scope.pc = dataTransfer.get();
                
        var address = calificacionTiendaContext + "/" + $state.params.idComentario;
        
        
        
        $scope.nuevoTexto = $scope.pc.texto;
       
        
        
        console.log("--------------");
        console.log($scope.nuevoTexto);
        console.log("---------------")
        
        $scope.editarCalificacion = function(){
            $http.put(address, $scope.pc).then(function(response){
                
              
                
            });
        };
        
        $scope.cambioInfo = function(){
         
          console.log($scope.nuevoTexto);  
            
          $scope.pc.texto = $scope.nuevoTexto;
          
          
        };
        
    }]);
})(window.angular);

