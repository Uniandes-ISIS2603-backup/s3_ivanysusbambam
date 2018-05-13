(function(ng){

    var mod = ng.module("clienteModule", ["ui.router"]);
    
    mod.config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
        
        var basePath = "src/modules/cliente/";
        
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
        }).state("editarCliente",{
            
            url: "/{clienteId: int}/editar",
               parent: "listCliente",
               params: {
                   clienteId: null
               },
               views: {
                   clienteDetailView: {
                       templateUrl: basePath+"editarPerfil.html",
                       controller: "clienteEditarCtrl",
                       controllerAs: "ctrl"
                   }
               }
            
        }).state("perfilCliente",{
            url: "/perfil/{clienteId: int}",
            
            params:{
                clienteId: null
            },
            views: {
                mainView: {
                        templateUrl: basePath+"/Perfil/cliente.perfil.html",
                        controller: "clienteDetailCtrl",
                        controllerAs: "ctrl"
                    }
                 
            }
        }).state("ComprasCliente",{
            url: "/perfil/{clienteId: int}/Compras",
            parent:"perfilCliente",
            params:{
                clienteId: null
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/compras.html",
                        controller: "clienteDetailCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("VentasCliente",{
            url: "/perfil/{clienteId: int}/Ventas",
            parent:"perfilCliente",
            params:{
                clienteId: null
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/ventas.html",
                        controller: "clienteDetailCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("ComentariosCliente",{
            url: "/perfil/{clienteId: int}/Comentarios",
            parent:"perfilCliente",
            params:{
                clienteId: null
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/CalificacionesTienda/comentarios.html",
                        controller: "clienteDetailCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("elimanarComentariosCliente",{
            url: "/perfil/Comentarios/eliminar",
            parent:"perfilCliente",
            params:{
                idComentario: null
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/CalificacionesTienda/CalificacionTiendaDelete.html",
                        controller: "calificacionDeleteCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("editarComentariosCliente",{
            url: "/perfil/Comentarios/editar",
            parent:"perfilCliente",
            params:{
                idComentario: null
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/CalificacionesTienda/comentariosEditar.html",
                        controller: "editarComentarioCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("QyRCliente",{
            url: "/perfil/{clienteId: int}/Quejas",
            parent:"perfilCliente",
            params:{
                clienteId: null
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/quejas.html",
                        controller: "clienteDetailCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("editarPerfilCliente",{
            
            url: "/{clienteId: int}/editarperfil",
            parent:"perfilCliente",
               params: {
                   clienteId: null
               },
               views: {
                   perfil: {
                       templateUrl: basePath+"cliente.perfil.editar.html",
                       controller: "clienteEditarPerfilCtrl",
                       controllerAs: "ctrl"
                   }
               }
            
        }).state("mediosDePagoCliente",{
            url: "/perfil/{clienteId: int}/mediosDePago",
            parent:"perfilCliente",
            params:{
                clienteId: null
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/MediosDePago/mediosDePago.html",
                        controller: "clienteDetailCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("eliminarMediosDePagoCliente",{
            url: "/perfil/{clienteId: int}/mediosDePago/delete/{numero:int}",
            parent:"perfilCliente",
            params:{
                numero: null,
                clienteId:null
                
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/MediosDePago/medioDePago.detele.html",
                        controller: "medioDePagoClienteDeleteCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("AgregarMediosDePagoCliente",{
            url: "/perfil/{clienteId: int}/mediosDePago/create",
            parent:"perfilCliente",
            params:{
                
                clienteId:null
                
            },
            views: {
               
                    perfil:{
                       templateUrl: basePath+"Perfil/MediosDePago/medioDePago.crear.html",
                        controller: "medioDePagoCreateClienteCtrl",
                        controllerAs: "ctrl"  
                    }
            }
        }).state("registrar",{
                url: "/cliente/crear",

                views:{
                    mainView:{
                        templateUrl: basePath + "cliente.registrar.html",
                        controller: "clienteRegistrarCtrl",
                        controllerAs: "ctrl"
                    }
                }
        });
    }]);

})(window.angular);


