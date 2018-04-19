/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



(function(ng){
    
   var mod = ng.module("quejaReclamoModule");
    
   mod.constant("quejaReclamoContext","api/quejasReclamos");
    
   mod.controller("quejaReclamoGetAllCtrl",["$scope", "$http", "quejaReclamoContext", function($scope, $http, quejaReclamoContext){
      
           $http.get(quejaReclamoContext).then(function(response){
               $scope.quejasReclamos = response.data;
           });
           
   }]);
    
})(angular.view);



