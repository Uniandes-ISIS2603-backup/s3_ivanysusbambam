/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng){
    
    var mod = ng.module("quejaReclamoModule");
    
    mod.constant("quejaReclamoContext", "api/quejasReclamos");
    
    mod.controller("quejaReclamoCrearCtrl", ["$scope", "$http", "quejaReclamoContext","$rootScope","$state", function($scope, $http, quejaReclamoContext, $rootScope, $state){
            
            $scope.data = {};
            
            
            $scope.crearQuejaReclamo = function(){
               $http.post(quejaReclamoContext, $scope.data).then(function(response){
                  $state.go("adminQuejaReclamoGetAll", {reload: true}); 
               });  
            };
            
            
    }]);
    
})(window.angular);
