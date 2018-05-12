(function(ng){
    
    var mod = ng.module("comentarioModule");
    
    mod.constant("comentarioContext", "api/comentarios");
    
    mod.controller("aniadirComentCtrl", ["$scope", "$http", "comentarioContext","$rootScope","$state", function($scope, $http, comentarioContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            
            
            $scope.crearComentario = function(){
                
            };
            
            
    }]);
    
})(window.angular);