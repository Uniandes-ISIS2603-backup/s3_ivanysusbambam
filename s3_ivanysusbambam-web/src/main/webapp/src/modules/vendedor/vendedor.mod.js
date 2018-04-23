(function(ng){
    
    ng.module("vendedorModule",["ui.router"])
            .config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
                    
                    var basePath = "src/modules/vendedor/";
            
                    $urlRouterProvider.otherwise("/vendedor");
                    
                    $stateProvider.state("listVendedor",{
                        views:{
                            
                            url: "/vendedor/list",
                            mainView:{
                                templateUrl: basePath + "vendedor.list.html",
                                controller: "vendedorListCtrl",
                                controllerAs: "ctrl"
                            }
                           }
                    }
                            
                   ).state("vendedorDetail",{
                       
                       url:"/{vendedorId:int}/detail",
                       parent: "listVendedor",
                       params:{
                           vendedorId: null
                       },
                       views: {
                           vendedorDetailView:{
                               templateUrl: basePath+"vendedor.detail.html",
                               controller: "vendedorDetailCtrl",
                               controllerAs: "ctrl"
                           }
                       }
                       
                   }).state("crearVendedor",{
                       url: "/vendedor/crear",
                       
                       views: {
                           mainView:{
                               templateUrl: basePath+"vendedor.crear.html",
                               controller: "vendedorCrearCtrl",
                               controllerAs: "ctrl"
                           } 
                                   
                       }
                   });
            
            }]);
    
})(window.angular);

