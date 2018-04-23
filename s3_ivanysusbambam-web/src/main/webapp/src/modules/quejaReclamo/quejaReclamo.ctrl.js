(function(ng){

    var mod = ng.module("quejaReclamoModule");
    
    mod.constant("quejaReclamoContext", "api/quejasReclamos");
    
    mod.controller("quejaReclamoGetAllCtrl",["$scope","$http","quejaReclamoContext", function($scope, $http, quejaReclamoContext){
      
            $http.get(quejaReclamoContext).then(function(response){
               $scope.quejasReclamos = response.data; 
            });
            
    }]);
    
})(window.angular);
