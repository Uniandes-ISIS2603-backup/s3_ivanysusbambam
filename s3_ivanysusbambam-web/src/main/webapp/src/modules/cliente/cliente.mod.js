(function (ng){

    var mod = ng.module("clienteModule",["ui.router"]);
    
    mod.config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
        
        var basePath = "src/modules/cliente/";
        
        //TODO - Tal vez el otherwise debería enviar a index?
        $urlRouterProvider.otherwise("/cliente");
        
        $stateProvider.state("admin.clienteGetAll", {
            
            url: "/cliente/getall",
            
            views: {
                mainView:{
                    templateUrl: basePath + "cliente.list.html",
                    controller: "clienteGetAllCtrl",
                    controllerAs:"ctrl"
                }
            }
            
        }).state("vendedor.clienteGetAll",{
            
            url: "/cliente/getall",
            
            views:{
                mainView:{
                    templateUrl: basePath + "cliente.list.html",
                    controller:"clienteGetAllCtrl",
                    controllerAs:"ctrl"
                }
            }
        });
    }]);

})(angular.view);


