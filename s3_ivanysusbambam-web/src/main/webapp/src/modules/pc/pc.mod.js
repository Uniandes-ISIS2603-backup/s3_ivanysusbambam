(function(ng){
    
    ng.module("pcModule",["ui.router"]).configure(["$stateProvider","$urlRouterProvider", 
        function($stateProvider, $urlRouterProvider){
            
            var basePath = "src/modules/pc";
            
            $urlRouterProvider.otherwise("/pc");
            
            $stateProvider.state("administrador.pcGetAll",{
                
                
                url: "/pc/getall",
                views: {
                        mainView: {
                            templateUrl: basePath + "pc.list.html",
                            controller = "pcGetAllCtrl",
                            controllerAs ="ctrl"
                        }
                    }
                
            }).state("vendedor.pcGetAll",{
               
               url: "/pc/:vendedor/getall",
                views: {
                    mainView:{
                        templateUrl: basePath + "pc.list.html",
                        controller = "pcGetAllOfClienteCtrl",
                        controllerAs = "ctrl"
                    }
                }
                
            });
    }]);
    
    
})(angular.view);
