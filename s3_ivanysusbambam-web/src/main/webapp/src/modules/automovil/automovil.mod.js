/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("automovilModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/automovil/';
            $urlRouterProvider.otherwise("/listAutomoviles");

            $stateProvider.state('listAutomoviles', {
                url: '/automoviles/list',
                
                views: {
                    'mainView': {
                        templateUrl: basePath + 'automovil.list.html',
                        controller: 'automovilGetAllCtrl',
                        controllerAs: 'ctrl'
                    },
                    automovilList: {
                        templateUrl: basePath + 'automovilGetAll.html',
                        controller: 'automovilGetAllCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            }).state("automovilDetail", {
                url: "/{automovilId: int}/detail ",
               
                params: {
                    automovilId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + "automovil.detail.html",
                        controller: "automovilDetailCtrl",
                        controllerAs: "ctrl"
                    }
                }
            }).state("automovilDetailInfo", {
                url: "/info ",
              
                parent: "automovilDetail",
                views: {
                    'info': {
                        templateUrl: basePath + "automovil.detail.info.html",
                        controller: "automovilDetailCtrl",
                        controllerAs: "ctrl"
                    }
                }
            }).state("automovilDetailPV", {
                url: "/info ",
              
                parent: "automovilDetail",
                views: {
                    'info': {
                        templateUrl: basePath + "automovil.detail.Pv.html",
                        controller: "automovilDetailCtrl",
                        controllerAs: "ctrl"
                    }
                }
            }).state("automovilListFiltros", {
                url: "/automovilListFiltered",
                 parent: "listAutomoviles",
                 params:{
                  fechaMin:null,
                  fechaMax:null,
                  marca:null,
                  modelo:null,
                  color:null,
                  precioMin:null,
                  precioMax:null
                 },
               views: {
                  
                    'mainView': {
                        templateUrl: basePath + 'automovil.list.html',
                        controller: 'automovilGetAllCtrl',
                        controllerAs: 'ctrl'
                    },
                    automovilList: {
                        templateUrl: basePath + 'automovilGetAll.html',
                        controller: 'automovilFilteredCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state("automovilGetAll", {
                url: "/getAll ",
                parent: "listAutomoviles",
                
                views: {
                    'automovilList': {
                        templateUrl: basePath + "automovilGetAll.html",
                        controller: "automovilGetAllCtrl",
                        controllerAs: "ctrl"
                    }
                }
            }).state("crearAutomovil", {
                url: "/automovil/crear",

                views: {
                    mainView: {
                        templateUrl: basePath + "automovil.crear.html",
                        controller: "automovilCrearCtrl",
                        controllerAs: "ctrl"
                    }
                }}).state("buscarAuto", {
                url: "/automovil/buscar",

                views: {
                    mainView: {
                        templateUrl: basePath + "buscarAuto.html",
                        controller: "automovilGetAllCtrl",
                        controllerAs: "ctrl"
                    }
                }});
        }
    ]);

})(window.angular);
           