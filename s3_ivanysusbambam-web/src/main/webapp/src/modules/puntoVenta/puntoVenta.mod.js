(function (ng){ 
    
    var mod = ng.module("puntoVentaModule", ["ui.router"]);
    
    mod.config([ '$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
        var basePath = 'src/modules/puntoVenta/';
        
        //TODO como hacer para poner la página principal de default
        $urlRouterProvider.otherwise("/puntoVenta");
        $stateProvider.state('adminPuntosVentaGetAll', {
              url: '/puntosVenta/principal',
              abstract: false,
              views: {
                 'mainView': {
                     templateUrl: basePath + 'puntoVenta.list.html',
                     controller: 'puntosVentaMasterCtrl',
                     controllerAs: 'ctrl'
                   }
                }
            }).state('puntoDeVentaDetailAutos',{
                url: '/{puntoVentaId:int}/detail',
                parent: 'adminPuntosVentaGetAll',
                param: {puntoVentaId: null},
                views: {
                    'listAutosView' : {
                        templateUrl: basePath + 'puntoVentaDetail.autos.list.html',
                        controller: 'puntoVentaDetailCtrl',
                        controllerAs: 'ctrl'
                    }   
                }
            }).state('puntoVentaDetailCompras', {
                url: '/{puntoVentaId:int}/detail',
                parent: 'adminPuntosVentaGetAll',
                param: {puntoVentaId: null},
                views: {
                    'listComprasView': {
                        templateUrl: basePath + 'puntoVentaDetail.compras.list.html',
                        controller: 'puntoVentaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('puntoVentaDetailVentas',{
                url: '/{puntoVentaId:int}/detail',
                parent: 'adminPuntosVentaGetAll',
                param: {puntoVentaId: null},
                views: {  
                    'listVentasView': {
                        templateUrl: basePath + 'puntoVentaDetail.ventas.list.html',
                        controller: 'puntoVentaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('puntoVentaDetailVendedores',{
                url: '/{puntoVentaId:int}/detail',
                parent: 'adminPuntosVentaGetAll',
                param: {puntoVentaId: null},
                views: {
                    'listVendedoresView': {
                        templateUrl: basePath + 'puntoVentaDetail.vendedores.list.html',
                        controller: 'puntoVentaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);
