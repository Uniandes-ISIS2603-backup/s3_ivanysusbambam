(function(ng){
    
    var mod = ng.module("pcModule");
    
    mod.constant("pcContext", "api/prospectoscompra");
    
    mod.controller("pcListCtrl",["$scope","$http", "pcContext","$state", function($scope, $http, pcContext,$state){
       
       $http.get(pcContext).then(function(response){
          $scope.pcRecords = response.data;
       });
       $http.delete(pcContext + '/' + $state.params.id, {}).then(function (response) {
                    $state.go('listPc', {}, {reload: true});
            });
            
    }]);
    
})(window.angular);


