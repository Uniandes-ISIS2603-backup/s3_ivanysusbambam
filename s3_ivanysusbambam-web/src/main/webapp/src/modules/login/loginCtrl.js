(function(ng){

    var mod = ng.module("loginModule");
    
    
    mod.controller("loginCtrl",["$scope","$http","$state", "$rootScope", 
    
                                
    function($scope, $http, $state,$rootScope){
      
    $scope.user = {};
    $scope.data = {};
        $http.get('data/usuarios.json').then(function (response)     {
                $scope.users = response.data;
            });
        
        $rootScope.usuario = false;
        $rootScope.vendedor = false; 
        $rootScope.administrador = false;
        
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
             $http.post('api/login',$scope.data).then(function(response){
                for (var item in $scope.users) {
                    if ($scope.users[item].user == $scope.data.username && $scope.users[item].password == $scope.data.password && $scope.users[item].rol == $scope.data.rol) {
                        flag = true;
                        $scope.user = $scope.users[item];
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
                    sessionStorage.setItem("username", $scope.user.user);
                    sessionStorage.setItem("name", $scope.user.name);
                    sessionStorage.setItem("rol", $scope.user.rol);
                    $rootScope.currentUser = $scope.user.name;
                    /* Acá te estoy guardando la referencia al id */
                    $rootScope.currentId = $scope.user.id;
                }
                });
            
            };
        }
    ]);
}   
)(window.angular);