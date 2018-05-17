(function (ng) {

    var mod = ng.module('modeloModule');
    mod.constant("modeloContext", "api/modelos");
    mod.controller("modeloListCtrl", ["$scope","$rootScope", "$http", "modeloContext", "$state", function ($scope,$rootScope, $http, modeloContext, $state) {

        
        $http.get(modeloContext).then(function (Response) {
            $scope.darModelos = Response.data;
            if(Response.status==500){
                $rootScope.errorDelMd=true;
            }
            else{
                $rootScope.errorDelMd=false;
            }
        });
        $http.delete(modeloContext + '/' + $state.params.idModelo, {}).then(function (response) {
            if(response.status==500){
                $rootScope.errorDelMd=true;
            }
            else{
                $rootScope.errorDelMd=false;
            }
            $state.go('listModelo', {}, {
                reload: true
            });
            
            
        });

}]);
})(window.angular);
