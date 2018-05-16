(function(ng){
    
    var mod = ng.module("medioDePagoModule");
    
    mod.constant("medioDePagoContext", "api/mediosDePago");
    
    mod.controller("medioDePagoCrearCtrl", ["$scope", "$http", "medioDePagoContext", "$state",
    function($scope, $http, medioDePagoContext, $state){
        
        $scope.data={};
        
         $http.get("api/clientes").then(function(response){
            
        });
     
        
         $scope.crearMdp = function(){
          
            //Id que será reemplazado por el autogenerado
            
            $http.post(medioDePagoContext, $scope.data).then(function(){
                //aqui habia un response en la function del then, esta se deberia usar para mandar una excepcion
                $state.go("AdminMedioDePagoGetAll",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);