(function(ng){

    var mod = ng.module("medioDePagoModule");
    mod.constant("medioDePagoContext", "api/mediosDePago");
    
    mod.controller("medioDePagoGetAllCtrl",["$scope","$http","medioDePagoContext", function($scope, $http, medioDePagoContext){
            
            
            
            
               $http.get(medioDePagoContext).then(function(response){
               $scope.mediosDePago = response.data; 
             
 
            });
            
    }]);
    
})(window.angular);


