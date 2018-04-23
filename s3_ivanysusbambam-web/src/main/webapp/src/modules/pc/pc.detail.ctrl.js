(function(ng){
    
    var mod = ng.module("pcModule");
    
    mod.constant("pcContext", "api/prospectoscompra");
    
    mod.controller("pcDetailCtrl", ["$scope", "$http", "pcContext", "$state", "dataTransfer", 
    function($scope, $http, pcContext, $state, dataTransfer){
        
        if($state.params.pcId !== undefined && $state.params.pcId !==null){
            var address = pcContext + "/"+$state.params.pcId;
            
            $http.get(address).then(function(response){
                $scope.pc = response.data;
            });
        }
        
        $scope.subirInfoPc = function(){
            console.log("subiendo info");
            dataTransfer.set($scope.pc);
        };
      
        
    }]);
    
})(window.angular);


