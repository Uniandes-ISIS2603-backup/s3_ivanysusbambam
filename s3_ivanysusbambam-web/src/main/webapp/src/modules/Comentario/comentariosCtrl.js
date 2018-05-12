(function(ng){
    
    var mod = ng.module("comentarioModule");
    
    mod.constant("comentarioContext", "api/comentarios");
    
    mod.controller("comentariosCtrl", ["$scope", "$http", "comentarioContext","$rootScope","$state", function($scope, $http, clienteContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            
            
            $scope.darComentarios = function(){ 
            };
            
            
    }]);
    
})(window.angular);