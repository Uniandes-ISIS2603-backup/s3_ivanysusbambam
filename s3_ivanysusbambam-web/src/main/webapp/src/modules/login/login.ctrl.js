(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('loginCtrl', ['$scope', '$http', '$state', '$rootScope',
        /**
         * @ngdoc controller
         * @name login.controller:loginCtrl
         * @description
         * Definición del controlador de Angular del módulo Login. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definido
         * para toda la aplicación.
         */
        function ($scope, $http, $state, $rootScope) {

            $scope.user = {};
            $scope.data = {};

            $http.get('data/usuarios.json').then(function (response) {
                $scope.users = response.data;
            });
            $rootScope.rolClienteB = false;
            $rootScope.rolVendedorB = false;
            $rootScope.rolAdminB = false;

            $rootScope.esCliente = function () {
                $rootScope.rolClienteB = true;
                $rootScope.rolAdminB = false;
                $rootScope.rolVendedorB = false;
            };
            $rootScope.esAdmin = function () {
                $rootScope.rolAdminB = true;
                $rootScope.rolVendedorB = false;
                $rootScope.rolClienteB = false;

            };
            $rootScope.esVendedor = function () {
                $rootScope.rolVendedorB = true;
                $rootScope.rolClienteB = false;
                $rootScope.rolAdminB = false;
            };

            /**
             * @ngdoc function
             * @name autenticar
             * @methodOf login.controller:loginCtrl
             * @description
             * Esta función procesa el inicio de sesión usando los datos del
             * $scope.
             */
            $scope.autenticar = function () {
                var flag = false;

                for (var item in $scope.users) {


                    if ($scope.users[item].user === $scope.data.username && $scope.users[item].password === $scope.data.password && $scope.users[item].rol === $scope.data.rol) {

                        flag = true;
                        $scope.user = $scope.users[item];
                        $state.go('buscarAuto', {}, {
                            reload: true
                        });
                        $rootScope.currentUser = $scope.user.user;
                        if($scope.data.rol==='cliente'){
                            $rootScope.rolClienteB=true;
                        }
                        if($scope.data.rol==='vendedor'){
                            $rootScope.rolVendedorB=true;
                        }
                        if($scope.data.rol==='administrador'){
                            $rootScope.rolAdminB=true;
                        }
                        break;
                    }
                }
                if (!flag) {
                    $rootScope.tieneError = true;
                } else {
                    sessionStorage.token = $scope.user.token;
                    sessionStorage.setItem("username", $scope.user.user);
                    sessionStorage.setItem("name", $scope.user.name);
                    sessionStorage.setItem("rol", $scope.user.rol);
                    $rootScope.tieneError=false;
                    /*Acá está el usuario guardado*/
                    $rootScope.currentUserId = $scope.user.user;

                };
            };
        }
    ]);
})(window.angular);
