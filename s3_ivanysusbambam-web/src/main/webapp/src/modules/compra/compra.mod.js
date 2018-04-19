(function (ng) {

   var mod =  ng.module("compraModule", ['ui.router']);
 
 

           mod.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {


            var basePath = "src/modules/compra/";



            $stateProvider.state("admin.compraGetAll", {
                views: {

                    url: "/compra/getall",
                    mainView: {
                        templateUrl: basePath + "admin.tools.html",
                        controller: "adminToolsCtrl",
                        controllerAs: "ctrl"
                    },
                    listView: {
                        
                        templateUrl: basePath + "compra.list.html",
                        controller: "compraGetAllCtrl",
                        controllerAs: "ctrl"
                    }
                    
                }
            }

            );

        }]);


})(window.angular);

