
(function(ng){
    
    var mod = ng.module("automovilModule");
    
    mod.constant("automovilContext", "api/automoviles");
    
    mod.controller("automovilEditarCtrl", ["$scope", "$http", "automovilContext","$rootScope","$state", function($scope, $http, automovilContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            
            $scope.editarAutomovil = function(){  
            };
            
            
    }]);
    
})(window.angular);