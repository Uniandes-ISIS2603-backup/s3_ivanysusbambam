/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng){

    var mod = ng.module("quejaReclamoModule",["ui.router"]);
    
    mod.config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
        
        var basePath = "src/modules/QuejaReclamo/";
        
        //TODO - Tal vez el otherwise debería enviar a index?
        $urlRouterProvider.otherwise("/QuejaReclamo");
        
        $stateProvider.state("admin.quejaReclamoGetAll", {
            
            views: {
                mainView:{
                    templateUrl: basePath + "quejaReclamo.list.html",
                    controller: "quejaReclamoGetAllCtrl",
                    controllerAs:"ctrl"
                }
            }
            
        });
        
    }]);

})(angular.view);



