(function (ng) {

    var mod = ng.module("modeloModule");

    mod.constant("modeloContext", "api/modelos");

    mod.controller("modeloCrearCtrl", ["$scope", "$http", "modeloContext", "$state",

                                      function ($scope, $http, modeloContext, $state) {
$scope.data = {};
            $scope.crearModelo = function () {

               

                $http.post(modeloContext, $scope.data).then(function (response) {
                    $state.go("listModelo", {
                        reload: true
                    });
                });
            };

    }]);

})(window.angular);