/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {

    var mod = ng.module("automovilModule");

    mod.constant("automovilContext", "api/automoviles/search?");

    mod.controller("automovilGetAllCtrl", ["$scope", "$http", "automovilContext", function ($scope, $http, automovilContext) {


            $scope.data = {};


            $http.get("api/marcas").then(function (response) {
                $scope.listaMarcas = response.data;
            });




            $http.get(automovilContext + "precioMin="+$scope.modelo+"&precioMax="+$scope.precioMax+"&color="+$scope.color+"&modelo="+$scope.modelo+"&marca="+$scope.marca+"&anioMin="+$scope.fechaMin+"&anioMax="+$scope.fechaMax).then(function (response) {
                $scope.automoviles = response.data;
            });

        }]);

})(window.angular);