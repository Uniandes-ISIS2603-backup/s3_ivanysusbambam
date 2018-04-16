/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){

    var mod = ng.module("ventaModule");
    
    mod.constant("ventaContext", "api/ventas");
    
    mod.controller("ventaGetAll",["$scope","$http","ventaContext", function($scope, $http, ventaContext){
      
            $http.get(ventaContext).then(function(response){
               $scope.ventas = response.data; 
            });
            
    }]);
    
})(angular.view);

