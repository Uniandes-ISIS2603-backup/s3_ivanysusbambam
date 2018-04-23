/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){
    
   var mod = ng.module("ventaModule");
   
   mod.constant("ventaContext", "api/ventas");
   mod.controller("ventaDetailCtrl", ["$scope", "$http", "ventaContext", "$state", 
    function($scope, $http, ventaContext, $state){
               
        if($state.params.ventaId !== undefined && $state.params.ventaId !==null){
            var address = ventaContext + "/"+$state.params.ventaId;
            
            $http.get(address).then(function(response){
                $scope.venta = response.data;
            });
        }
        
    }]);
            

            
    
})(window.angular);