/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){
    console.log("FASFHAISHDA");
   var mod = ng.module("quejaReclamoModule");
   
   mod.constant("quejaReclamoContext", "api/quejasReclamos");
   mod.controller("quejaReclamoDetailCtrl", ["$scope", "$http", "quejaReclamoContext", "$state", 
    function($scope, $http, quejaReclamoContext, $state){
               
        if($state.params.quejaReclamoId !== undefined && $state.params.quejaReclamoId !==null){
            var address = quejaReclamoContext + "/"+$state.params.quejaReclamoId;
            
            $http.get(address).then(function(response){
                $scope.quejaReclamo = response.data;
            });
        }
        
    }]);
            

            
    
})(window.angular);
