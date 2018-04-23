(function(ng){

    var mod = ng.module("clienteModule", ["ui.router"]);
    
    mod.config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
        
        var basePath = "src/modules/cliente/";
        
        //TODO - Tal vez el otherwise debería enviar a index?
        $urlRouterProvider.otherwise("/cliente");
        
        $stateProvider.state("listCliente", {
            
            url: "/cliente/list",
            
            views: {
                mainView:{
                    templateUrl: basePath + "cliente.list.html",
                    controller: "clienteListCtrl",
                    controllerAs:"ctrl"
                }
            }
            
        }).state("clienteDetail",{
           
               url: "/{clienteId: int}/detail",
               parent: "listCliente",
               params: {
                   clienteId: null
               },
               views: {
                   clienteDetailView: {
                       templateUrl: basePath+"cliente.detail.html",
                       controller: "clienteDetailCtrl",
                       controllerAs: "ctrl"
                   }
               }
               
                
        }).state("crearCliente",{
                url: "/cliente/crear",

                views:{
                    mainView:{
                        templateUrl: basePath + "cliente.crear.html",
                        controller: "clienteCrearCtrl",
                        controllerAs: "ctrl"
                    }
                }
        });
    }]);

})(window.angular);


