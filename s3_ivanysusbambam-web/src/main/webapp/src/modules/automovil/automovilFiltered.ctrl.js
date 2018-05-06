/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {

    var mod = ng.module("automovilModule");

    mod.constant("newAutomovilContext", "api/automoviles/search?");

    mod.controller("automovilFilteredCtrl", ["$scope", "$http", "newAutomovilContext","$state", function ($scope, $http, newAutomovilContext,$state) {




            
            var paramsBusq = "";
            
            if($state.params.precioMin !== null && $state.params.precioMax !== null){
                paramsBusq +=  "precioMin="+$state.params.precioMin+"&precioMax="+$state.params.precioMax+"&";
            }
            if($state.params.anioMin!==undefined && $state.params.anioMax!==undefined){
                paramsBusq+="anioMin="+$state.params.anioMin+"&anioMax"+$state.params.anioMax+"&";
            }
             if($state.params.color!==null){
                paramsBusq+="color="+$state.params.color.name+"&";
            }
             if($state.params.modelo!==null){
                paramsBusq+="modelo="+$state.params.modelo.name+"&";
            }
             if($state.params.marca!==null){
                paramsBusq+="marca="+$state.params.marca.name+"&";
            }
            
            if(paramsBusq.endsWith('&'))
            {
                paramsBusq=paramsBusq.substring(0,paramsBusq.length-1);
            }
           
            $http.get(newAutomovilContext + paramsBusq).then(function (response) {
                $scope.automoviles = response.data;
            },function errorCallback(response){
             $scope.error=true;
             $scope.mensaje=response;
            }) 
;

        }]);

})(window.angular);