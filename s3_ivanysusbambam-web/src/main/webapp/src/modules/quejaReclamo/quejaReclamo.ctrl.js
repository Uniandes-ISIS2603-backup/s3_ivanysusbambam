(function(ng){

    var mod = ng.module("quejaReclamoModule");
    
    mod.constant("quejaReclamoContext", "api/quejasReclamo");
    
    mod.controller("quejaReclamoGetAllCtrl",["$scope","$http","quejaReclamoContext", function($scope, $http, quejaReclamoContext){
      
            $http.get("data/quejasReclamos.json").then(function(response){
               $scope.quejasReclamos = response.data; 
            });
            
    }]);
    
})(window.angular);
