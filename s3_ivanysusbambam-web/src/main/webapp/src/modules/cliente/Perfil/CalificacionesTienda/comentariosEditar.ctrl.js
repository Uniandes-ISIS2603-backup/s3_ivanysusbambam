(function(ng){
    
    var mod = ng.module("clienteModule");
    mod.constant("calificacionTiendaContext", "api/calificacionesTienda");
    
    mod.controller("editarComentarioCtrl", ["$scope", "$http", "calificacionTiendaContext", "$state", 
    function ($scope, $http, calificacionTiendaContext, $state){
     
        var address = calificacionTiendaContext;
        
         var calificacion = {
                            id: $state.params.idComentario,
                            comentario: "",
                            puntaje: 0.0};
        
        $scope.editarCalificacion = function(){
            $http.put(address, calificacion).then(function(response){
              $state.go("ComentariosCliente",{clienteId: $state.params.clienteId},{reload: true}); 
                
            });
        };
        
        $scope.cambioInfo = function(){
          calificacion.comentario = $scope.nuevoComentario;
          calificacion.puntaje = $scope.nuevoPuntaje;
          
          
        };
        
    }]);
})(window.angular);

