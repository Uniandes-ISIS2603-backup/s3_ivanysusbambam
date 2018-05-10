(function(ng){
    
    var mod = ng.module("comentarioModule");
    
    mod.constant("comentarioContext", "api/comentarios");
    
    mod.controller("comentarioPerfCtrl", ["$scope", "$http", "comentarioContext","$rootScope","$state", function($scope, $http, comentarioContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            
            
            $scope.darComentarioPerf = function(){
            };
            
            
    }]);
    
})(window.angular);