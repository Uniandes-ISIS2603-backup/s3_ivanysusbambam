(function(ng){
    
    ng.module("pcModule",["ui.router"]).config(["$stateProvider","$urlRouterProvider", 
        function($stateProvider, $urlRouterProvider){
            
            var basePath = "src/modules/pc/";
            
            $urlRouterProvider.otherwise("/pc");
            
            $stateProvider.state("listPc",{
                
                
                url: "/pc/list",
                views: {
                        mainView: {
                            templateUrl: basePath + "pc.list.html",
                            controller : "pcListCtrl",
                            controllerAs :"ctrl"
                        }
                    }
                
            }).state("pcDetail",{
                
                url: "/{pcId:int}/detail",
                parent: "listPc",
                params: {
                    pcId: null
                },
                views:{
                    pcDetailView: {
                        templateUrl: basePath + "pc.detail.html",
                        controller: "pcDetailCtrl",
                        controllerAs: "ctrl"
                    }
                }
                
            }).state("crearPc",{
                url: "/pc/crear",
                
                views:{
                    mainView:{
                        templateUrl: basePath+"pc.crear.html",
                        controller: "pcCrearCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
    }]);
    
    
})(window.angular);
