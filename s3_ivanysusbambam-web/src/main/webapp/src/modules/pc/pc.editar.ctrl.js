(function(ng){
    
    var mod = ng.module("pcModule");
    mod.constant("pcContext", "api/prospectoscompra");
    
    mod.controller("pcEditarCtrl", ["$scope", "$http", "pcContext", "$state", "dataTransfer", 
    function ($scope, $http, pcContext, $state, dataTransfer){
     
        $scope.pc = dataTransfer.get();
                
        var address = pcContext + "/" + $state.params.pcId;
        
        
        
        $scope.nuevoTexto = $scope.pc.texto;
        
        $scope.editarProspecto = function(){
            $http.put(address, $scope.pc).then(function(response){
                
                $state.go("listPc",{},{reload: true});
                
            });
        };
        
        $scope.cambioInfo = function(){
            
          $scope.pc.texto = $scope.nuevoTexto;
          
          
        };
        
    }]);
})(window.angular);

