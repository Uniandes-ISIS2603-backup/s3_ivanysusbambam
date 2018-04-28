/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng){
    
    var mod = ng.module("automovilModule");
    
    mod.constant("automovilContext", "api/automoviles");
    
    mod.controller("automovilCrearCtrl", ["$scope", "$http", "automovilContext","$rootScope","$state", function($scope, $http, automovilContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            
            
            $scope.crearAutomovil = function(){
               $http.post(automovilContext, $scope.data).then(function(response){
                  $state.go("listAutomoviles", {reload: true}); 
               });  
            };
            
            
    }]);
    
})(window.angular);
