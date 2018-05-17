(function(ng){ 
    
var mod = ng.module('modeloModule');
mod.constant("modeloContext", "api/modelos");
mod.controller("modeloListCtrl", ["$scope", "$http", "modeloContext","$state" , function($scope, $http, modeloContext,$state){
        
        $http.get(modeloContext).then(function(Response){
            $scope.darModelos = Response.data;
        });
         $http.delete(modeloContext + '/' + $state.params.idModelo, {}).then(function (response) {
                    $state.go('listModelo', {}, {reload: true});
            });
        
}]);


})(window.angular);