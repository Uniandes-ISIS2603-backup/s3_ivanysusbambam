/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){

    var mod = ng.module("automovilModule");
    
    mod.constant("automovilContext", "api/automoviles");
    
    mod.controller("automovilGetAllCtrl",["$scope","$http","$rootScope","automovilContext", function($scope, $rootScope, $http, automovilContext){
      
            console.log($rootScope.cliente);
            
            
            $http.get(automovilContext).then(function(response){
               $scope.automoviles = response.data; 
            });
            
            $http.get("api/modelos").then(function(response){
               $scope.modelos = response.data; 
            });
            $http.get("api/automoviles/colores").then(function(response){
               $scope.colores = response.data; 
            });
            $http.get("api/marcas").then(function(response){
               $scope.marcas = response.data; 
            });
            var anos=[];
            for(var i=1990;i<2019;i++)
            {
                anos.push(i);
            }
            $scope.anos=anos;
            
           
            
            
    }]);
    
})(window.angular);