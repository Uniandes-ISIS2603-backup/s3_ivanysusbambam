(function (ng) {

    console.log("LLEGO A MODULE x1 ");
    var mod = ng.module("adminModule", ["ui.router"]);

    console.log("ANTES DE CONFIG");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = "src/modules/admin/";

            /*$urlRouterProvider.otherwise("/admin");*/

            console.log("LLEGO A MODULE");

            $stateProvider.state("admin", {

                url: "/admin",
                views: {
                    mainView: {
                        templateUrl: basePath + "admin.tools.html",
                        
                    }
                }

            });

            console.log("ALGUIEN AYUDA");

        }]);

    console.log("LLEGO A MODULE x2 ");

})(window.angular);


