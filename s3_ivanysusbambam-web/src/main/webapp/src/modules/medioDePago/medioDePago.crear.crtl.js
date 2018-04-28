(function(ng){
    
    var mod = ng.module("medioDePagoModule");
    
    mod.constant("medioDePagoContext", "api/mediosDePago");
    
    mod.controller("medioDePagoCrearCtrl", ["$scope", "$http", "medioDePagoContext", "$state",
    function($scope, $http, medioDePagoContext, $state){
        
        $scope.data={};
        
         $http.get("api/clientes").then(function(response){
            $scope.listaClientes = response.data;
        });
     
        
         $scope.crearMdp = function(){
          
            //Id que será reemplazado por el autogenerado
            
            
            console.log($scope.data);
            
            $http.post(medioDePagoContext, $scope.data).then(function(response){
                $state.go("AdminMedioDePagoGetAll",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);