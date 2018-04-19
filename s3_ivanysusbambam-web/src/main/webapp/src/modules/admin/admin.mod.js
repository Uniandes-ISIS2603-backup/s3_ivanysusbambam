(function(ng){
    
    ng.module("adminModule", ["ui.router"]).config(
        ["$stateProvider", "$urlRouterProvider", 
            function($stateProvider, $urlRouterProvider){
                
                var basePath="src/modules/admin";
                
                $urlRouterProvider.otherwise("admin");
                
                $stateProvider.state("admin", {
                    
                    url = "/admin",
                    views: {
                        miainView: {
                            templateUrl : "admin.tools.html",
                            controller: "adminToolsCtrl",
                            controllerAs : "ctrl"
                        }
                    }
                              
                });
                
            }]);
    
})(window.angular);


