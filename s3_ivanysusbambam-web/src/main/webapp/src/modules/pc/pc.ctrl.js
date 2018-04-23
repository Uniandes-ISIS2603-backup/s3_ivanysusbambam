(function(ng){
    
    var mod = ng.module("pcModule");
    
    mod.constant("pcContext", "api/prospectoscompra");
    
    mod.controller("pcListCtrl",["$scope","$http", "pcContext", function($scope, $http, pcContext){
       
       $http.get(pcContext).then(function(response){
          $scope.pcRecords = response.data;
       });
            
    }]);
    
})(window.angular);


