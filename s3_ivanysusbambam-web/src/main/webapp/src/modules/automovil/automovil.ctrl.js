/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){

    var mod = ng.module("automovilModule");
    
    mod.constant("automovilContext", "api/automoviles");
    
    mod.controller("automovilGetAll",["$scope","$http","ventaContext", function($scope, $http, automovilContext){
      
            $http.get(automovilContext).then(function(response){
               $scope.automoviles = response.data; 
            });
            
    }]);
    
})(angular.view);