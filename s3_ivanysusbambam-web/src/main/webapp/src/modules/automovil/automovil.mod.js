/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){
    
    ng.module("automovilModule",["ui.router"])
            .configure(["stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
                    
                    var basePath = "src/modules/automovil/";
            
                    $urlRouterProvider.otherwise("/automovil");
                    
                    $stateProvider.state("admin.automovilGetAll",{
                        views:{
                            mainView:{
                                templateUrl: basePath + "automovil.list.html",
                                controller: "automovilGetAllCtrl",
                                controllerAs: "ctrl"
                            }
                           }
                    }
                            
                   );
            
            }]);
    
    
})(angular.window);

