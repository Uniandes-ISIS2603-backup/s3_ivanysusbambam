(function(ng){
    
    ng.module("vendedorModule",["ui.router"])
            .configure(["stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
                    
                    var basePath = "src/modules/vendedor/";
            
                    $urlRouterProvider.otherwise("/vendedor");
                    
                    $stateProvider.state("admin.clienteGetAll",{
                        views:{
                            mainView:{
                                templateUrl: basePath + "cliente.list.html",
                                controller: "clienteGetAllCtrl",
                                controllerAs: "ctrl"
                            }
                           }
                    }
                            
                   );
            
            }]);
    
    
})(angular.window);

