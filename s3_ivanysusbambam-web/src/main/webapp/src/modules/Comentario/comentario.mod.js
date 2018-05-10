(function(ng){

    var mod = ng.module("comentarioModule", ["ui.router"]);
    
    mod.config(["$stateProvider","$urlRouterProvider", function($stateProvider, $urlRouterProvider){
        
        var basePath = "src/modules/Comentario/";
        
        /* Revisar a donde envía */
        $urlRouterProvider.otherwise("/index.html");
        
        $stateProvider.state("comentarios", {
            
            url: "/comentarios",
            
            views: {
                mainView:{
                    templateUrl: basePath + "comentarios.html",
                    controller: "comentariosCtrl",
                    controllerAs:"ctrl"
                }
            }
            
        }).state("aniadirComentario",{
             url: "/comentarios/add",
            
            views: {
                mainView:{
                    templateUrl: basePath + "aniadirComentarios.html",
                    controller: "aniadirComentCtrl",
                    controllerAs:"ctrl"
                }
            }
            
        }).state("comentariosPerfil",{
            
            /* Revisar el url */
            url: "/comentarios/perfildelcliente",
            
            views: {
                mainView:{
                    templateUrl: basePath + "comentarioPerf.html",
                    controller: "comentarioPerfCtrl",
                    controllerAs:"ctrl"
                }
            }
        })
    }]);

})(window.angular);