(function (ng) {

    var mod = ng.module("clienteModule", ["ui.router"]);

    mod.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {

        var basePath = "src/modules/cliente/";

        $urlRouterProvider.otherwise("/cliente");

        $stateProvider.state("adminClientes", {

            url: "/clientes",
            params: {
                requireLogin: true
            },
            views: {
                mainView: {
                    templateUrl: basePath + "cliente.list.html",
                    controller: "clienteListCtrl",
                    controllerAs: "ctrl"
                }
            }

        }).state("adminDeleteClientes", {

            url: "/clientes",
            params: {
                requireLogin: true,
                id:null
            },
            views: {
                mainView: {
                    templateUrl: basePath + "cliente.list.html",
                    controller: "clienteDeleteCtrl",
                    controllerAs: "ctrl"
                }
            }

        }).state("clienteDetail", {

            url: "/{clienteId: int}/detail",
            parent: "listCliente",
            params: {
                clienteId: null,
                requireLogin:true
            },
            views: {
                clienteDetailView: {
                    templateUrl: basePath + "cliente.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }


        }).state("crearCliente", {
            url: "/cliente/crear",
            params: {
                requireLogin: true
            },
            views: {
                mainView: {
                    templateUrl: basePath + "cliente.crear.html",
                    controller: "clienteCrearCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("editarCliente", {

            url: "/{clienteId: int}/editar",
            parent: "adminClientes",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {
                clienteDetailView: {
                    templateUrl: basePath + "editarPerfil.html",
                    controller: "clienteEditarCtrl",
                    controllerAs: "ctrl"
                }
            }

        }).state("perfilCliente", {
            url: "/perfil/{clienteId: int}",

            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {
                mainView: {
                    templateUrl: basePath + "/Perfil/cliente.perfil.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }

            }
        }).state("ComprasCliente", {
            url: "/perfil/{clienteId: int}/Compras",
            parent: "perfilCliente",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/compras.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("ComprasClienteAdmin", {
            url: "/perfil/{clienteId: int}/ComprasAdmin",
            
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                mainView: {
                    templateUrl: "src/modules/compra/compra.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("VentasCliente", {
            url: "/perfil/{clienteId: int}/Ventas",
            parent: "perfilCliente",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/ventas.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("VentasClienteAdmin", {
            url: "/perfil/{clienteId: int}/VentasAdmin",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                mainView: {
                    templateUrl:  "src/modules/venta/venta.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("ComentariosCliente", {
            url: "/Comentarios",
            parent: "perfilCliente",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/CalificacionesTienda/comentarios.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("ComentariosClienteAdmin", {
            url: "/ComentariosAdmin",
         
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

               mainView: {
                    templateUrl: basePath + "src/modules/CalificacionTienda/calificacionesTienda.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("elimanarComentariosCliente", {
            url: "/perfil/Comentarios/eliminar",
            parent: "perfilCliente",
            params: {
                idComentario: null,
                requireLogin: true
            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/CalificacionesTienda/CalificacionTiendaDelete.html",
                    controller: "calificacionDeleteCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("editarComentariosCliente", {
            url: "/perfil/Comentarios/editar",
            parent: "perfilCliente",
            params: {
                idComentario: null,
                idCliente: null,
                requireLogin: true
            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/CalificacionesTienda/comentariosEditar.html",
                    controller: "editarComentarioCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("QyRCliente", {
            url: "/perfil/{clienteId: int}/Quejas",
            parent: "perfilCliente",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/quejas.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("QyRClienteAdmin", {
            url: "/perfil/{clienteId: int}/QuejasAmin",
            
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                mainView: {
                    templateUrl: "src/modules/quejaReclamo/quejaReclamo.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("calificacionesCarroAdmin", {
            url: "/perfil/{clienteId: int}/CalificacionesAdmin",
            
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                mainView: {
                    templateUrl: "src/modules/CalificacionCarro/calificacionesCarro.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("editarPerfilCliente", {

            url: "/{clienteId: int}/editarperfil",
            parent: "perfilCliente",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {
                perfil: {
                    templateUrl: basePath + "cliente.perfil.editar.html",
                    controller: "clienteEditarPerfilCtrl",
                    controllerAs: "ctrl"
                }
            }

        }).state("mediosDePagoCliente", {
            url: "/perfil/{clienteId: int}/mediosDePago",
            parent: "perfilCliente",
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/MediosDePago/mediosDePago.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("mediosDePagoClienteAdmin", {
            url: "/perfil/{clienteId: int}/mediosDePagoAmin",
            
            params: {
                clienteId: null,
                requireLogin: true
            },
            views: {

                mainView: {
                    templateUrl:  "src/modules/medioDePago/medioDePago.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("prospectoDeCompraAdmin", {
            url: "/perfil/{clienteId: int}/prospectosDeCompraAdmin",
            
            params: {
                clienteId: null,
                requireLogin: true

            },
            views: {

               mainView: {
                    templateUrl: basePath + "src/modules/medioDePago/pc.list.html",
                    controller: "clienteDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("AgregarMediosDePagoCliente", {
            url: "/perfil/{clienteId: int}/mediosDePago/create",
            parent: "perfilCliente",
            params: {

                clienteId: null,
                requireLogin: true

            },
            views: {

                perfil: {
                    templateUrl: basePath + "Perfil/MediosDePago/medioDePago.crear.html",
                    controller: "medioDePagoCreateClienteCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("registrar", {
            url: "/cliente/crear",
            params: {
                requireLogin: true
            },
            views: {
                mainView: {
                    templateUrl: basePath + "cliente.registrar.html",
                    controller: "clienteRegistrarCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    }]);

})(window.angular);
