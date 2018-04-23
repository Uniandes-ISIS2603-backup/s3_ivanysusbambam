/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){
    
   var mod = ng.module("automovilModule");
   
   mod.constant("automovilContext", "api/automoviles");
   mod.controller("automovilDetailCtrl", ["$scope", "$http", "automovilContext", "$state", 
    function($scope, $http, automovilContext, $state){
               
        if($state.params.automovilId !== undefined && $state.params.automovilId !==null){
            var address = automovilContext + "/"+$state.params.automovilId;
            
            $http.get(address).then(function(response){
                $scope.automovil = response.data;
            });
        }
        
    }]);
            

            
    
})(window.angular);