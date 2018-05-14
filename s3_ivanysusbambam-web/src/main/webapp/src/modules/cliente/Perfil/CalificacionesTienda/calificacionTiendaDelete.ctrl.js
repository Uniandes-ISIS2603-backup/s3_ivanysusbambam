(function(ng){
    
    var mod = ng.module("compraModule");
    mod.controller("calificacionDeleteCtrl", ["$scope", "$http", "$state", 
    
      function ($scope, $http, $state) {
            
            var dir = "api/calificacionesTienda/";
            
          
           /**
             * @ngdoc function
             * @name deleteAuthor
             * @methodOf authors.controller:authorDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar el autor.
             * @param {String} id El ID del autor a eliminar.
             */
            $scope.deleteCalificacion = function () {
                $http.delete(dir + $state.params.idComentario, {}).then(function (response) {
                    $state.go('ComentariosCliente', {clienteId: $state.params.clienteId}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);


