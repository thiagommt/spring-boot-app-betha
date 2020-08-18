appCliente.controller("loginController", function($scope, $http) {

	$scope.usuario = {};
	
	$scope.autenticar = function() {
			
		autenticaCliente = function() {
		$http({
		  method: 'GET',
		  url: 'http://localhost:8080/autenticar'		  
		}).then(function successCallback(response) {
			alert("Sucesso ao auntenticar cliente!" + response);
		  }, function errorCallback(response) {
		    alert("Erro ao auntenticar cliente!" + response);
		  });
		};
		
		autenticaCliente();
	}; 
	
});