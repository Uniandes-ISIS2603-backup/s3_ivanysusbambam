(function(ng){

    var mod = ng.module("loginModule");
    
    
    mod.controller("loginCtrl",["$scope","$http","$state", "$rootScope", 
    
                                
    function($scope, $http, $state,$rootScope){
      
    $scope.users = {};
    $scope.data = {};
        $http.get('data/usuarios.json').then(function (response)     {
                $scope.users = response.data;
            });
        
        /* Boolean que me ayudan con los permisos de cada usuario */
        $rootScope.usuario = false;
        $rootScope.vendedor = false; 
        $rootScope.administrador = false;
        
        /*Acá estoy guardando al objeto cliente y vendedor, para que sean asociados con los perfiles respectivos*/
        $rootScope.pCliente = null;
        $rootScope.pVendedor = null;
        
        $rootScope.esUsuario = function()
        {
            $rootScope.usuario=true;
            $rootScope.vendedor=false;
            $rootScope.administrador=false;
        }
        $rootScope.esAdmin= function()
        {
            $rootScope.usuario=false;
            $rootScope.vendedor=false;
            $rootScope.administrador=true;
        }
        $rootScope.esVendedor = function()
        {
            $rootScope.usuario=false;
            $rootScope.vendedor=true;
            $rootScope.administrador=false;
        }
        $scope.autenticar = function () {
                var flag = false;
            /* Mirar si no me sirve y borrar esto */
                for (var item in $scope.users) {
                    if ($scope.users[item].username == $scope.data.username && $scope.users[item].password == $scope.data.password && $scope.users[item].rol == $scope.data.rol) {
                        flag = true;
                        $scope.user = $scope.users[item];
                        
                         $http.get('http://localhost:8080/s3_ivanysusbambam-web/api/clientes/'+$scope.data.username).then(function (response){
                        $rootScope.pCliente = response.data;
                         });
                        
                        $http.get('http://localhost:8080/s3_ivanysusbambam-web/api/vendedores/'+$scope.data.username).then(function (response){
                        $rootScope.pVendedor = response.data;
                         });
                        /*
                        Aca mirar a cual estado se envía
                        */
                        $state.go('mainView', {}, {reload: true});
                        break;
                    }
                }
                if (!flag) {
                    $rootScope.alerts.push({type: "danger", msg: "Incorrect username or password."});
                } else {
                    sessionStorage.token = $scope.user.token;
                    sessionStorage.setItem("username", $scope.user.username);
                    sessionStorage.setItem("name", $scope.user.name);
                    sessionStorage.setItem("rol", $scope.user.rol);
                    $rootScope.currentUser = $scope.user.name;
                }
        );
            
            };
        }
    ]);
}   
)(window.angular);