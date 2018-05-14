(function(ng){
    
    ng.module("vendedorModule",["ui.router"])
            .config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
                    
                    var basePath = "src/modules/vendedor/";
            
                    $urlRouterProvider.otherwise("/vendedor");
                    
                    $stateProvider.state("listVendedor",{
                        
                        params:{
              requireLogin: true  
            },
                        url: "/vendedor/list",
                        views:{
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
                           vendedorId: null,
                           requireLogin:true
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
                       params:{
              requireLogin: true  
            },
                       views: {
                           mainView:{
                               templateUrl: basePath+"vendedor.crear.html",
                               controller: "vendedorCrearCtrl",
                               controllerAs: "ctrl"
                           } 
                                   
                       }
                   }).state("editarVendedor", {
                       
                       url: "/{vendedorId:int}/editar",
                       parent: "listVendedor",
                       params:{
                           vendedorId: null,
                           requireLogin:true
                       },
                       views: {
                           vendedorDetailView:{
                               templateUrl: basePath + "vendedor.editar.html",
                               controller: "vendedorEditarCtrl",
                               controllerAs: "ctrl"
                           }
                       }
                       
                   }).state("perfilVendedor",{
                       url:"/perfilVendedor/{vendedorId:int}",
                       params:{
                           vendedorId: null,
                           requireLogin:true
                       },
                       views:{
                           mainView:{
                               templateUrl: basePath + "vendedor.perfil.html",
                               controller: "vendedorDetailCtrl",
                               controllerAs: "ctrl"
                           }
                       }
                   }).state("editarPerfilVendedor",{
            
                        url: "/{vendedorId: int}/editarperfilvendedor",
                        params: {
                            vendedorId: null,
                            requireLogin:true
                        },
                        views: {
                            mainView: {
                                templateUrl: basePath+"vendedor.perfil.editar.html",
                                controller: "vendedorEditarPerfilCtrl",
                                controllerAs: "ctrl"
                            }
                        }
            
        });;
            
            }]);
    
})(window.angular);

