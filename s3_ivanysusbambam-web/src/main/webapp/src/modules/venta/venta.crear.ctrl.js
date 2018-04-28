/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng){
    
    var mod = ng.module("ventaModule");
    
    mod.constant("ventaContext", "api/ventas");
    
    mod.controller("ventaCrearCtrl", ["$scope", "$http", "ventaContext","$rootScope","$state", function($scope, $http, ventaContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            
            
            $scope.crearVenta = function(){
               $http.post(ventaContext, $scope.data).then(function(response){
                  $state.go("adminVentaGetAll", {reload: true}); 
               });  
            };
            
            
    }]);
    
})(window.angular);
