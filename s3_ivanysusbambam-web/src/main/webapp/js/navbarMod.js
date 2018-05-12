(function(ng){

    var mod = ng.module("principalModule", ["ui.router"]);
    
    mod.config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
        
        var basePath = "src/modules/cliente/";
        
        $urlRouterProvider.otherwise("/cliente");
        
        $stateProvider.state("listCliente", {
            
            url: "/cliente/list",
            
            views: {
                navView:{
                    templateUrl: basePath + "cliente.list.html",
                    controller: "navCtrl",
                    controllerAs:"ctrl"
                },
                filtrosView:{
                    
                }
            }
            
        });
    }]);

})(window.angular);

(function(ng){ 
    
var mod = ng.module('principalModule');
mod.constant("navContext", "api/nav");
mod.controller("navCtrl", ["$scope", "$http", "navContext",  function($scope, $http, navContext){
        
        $scope.mostrarCliente = function () {
            
        };

        $scope.mostrarVendedor = function () {
            
        };

        $scope.mostrarAdmin = function () {
            
        };
}]);


})(window.angular);