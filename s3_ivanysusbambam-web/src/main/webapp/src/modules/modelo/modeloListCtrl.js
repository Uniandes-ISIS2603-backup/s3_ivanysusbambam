(function(ng){ 
    
var mod = ng.module('modeloModule');
mod.constant("modeloContext", "api/modelos");
mod.controller("modeloListCtrl", ["$scope", "$http", "modeloContext",  function($scope, $http, modeloContext){
        
        //$state.reload();
        $http.get(modeloContext).then(function(Response){
            $scope.darModelos = Response.data;
        });
}]);


})(window.angular);