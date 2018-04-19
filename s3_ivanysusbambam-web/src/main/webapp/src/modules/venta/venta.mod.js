/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng){
    
    ng.module("ventaModule",["ui.router"])
            .configure(["stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
                    
                    var basePath = "src/modules/Venta/";
            
                    $urlRouterProvider.otherwise("/Venta");
                    
                    $stateProvider.state("admin.ventaGetAll",{
                        views:{
                            mainView:{
                                templateUrl: basePath + "venta.list.html",
                                controller: "ventaGetAllCtrl",
                                controllerAs: "ctrl"
                            }
                           }
                    }
                            
                   );
            
            }]);
    
    
})(angular.window);

