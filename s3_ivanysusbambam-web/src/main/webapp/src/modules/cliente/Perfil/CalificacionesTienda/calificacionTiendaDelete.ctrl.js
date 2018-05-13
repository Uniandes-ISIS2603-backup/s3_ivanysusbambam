(function(ng){
    
    var mod = ng.module("compraModule");
    console.log("hola");
    mod.constant("compraContext", "api/compras");
    mod.controller("calificacionDeleteCtrl", ["$scope", "$http", "compraContext", "$state", "dataTransfer", 
    
      function ($scope, $http, compraContext, $state) {
            var idCompra = $state.params.idCompra;
            /**
             * @ngdoc function
             * @name deleteAuthor
             * @methodOf authors.controller:authorDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar el autor.
             * @param {String} id El ID del autor a eliminar.
             */
            $scope.deleteCalificacion = function () {
                $http.delete(compraContext + '/' + idCompra, {}).then(function (response) {
                    $state.go('AdminCompraGetAll', {authorId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);


