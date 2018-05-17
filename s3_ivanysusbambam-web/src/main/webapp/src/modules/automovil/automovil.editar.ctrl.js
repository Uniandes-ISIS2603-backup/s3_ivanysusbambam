
(function(ng){
    
    var mod = ng.module("automovilModule");
    
    mod.constant("automovilContext", "api/automoviles");
    
    mod.controller("automovilEditarCtrl", ["$scope", "$http", "automovilContext","$rootScope","$state","dataTransfer", function($scope, $http, automovilContext, $rootScope, $state,dataTransfer){
            
            //$rootScope.edit = false;
            
           $scope.auto = dataTransfer.get();
           
            $scope.editarAutomovil = function(){  
                 $http.put("api/automoviles/"+$state.params.idAuto, $scope.auto).then(function(response){
                
                 $state.go("adminAutos",{},{reload: true});
                
            });
            };
            
            
    }]);
    
})(window.angular);