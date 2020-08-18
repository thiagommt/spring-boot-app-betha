//Criação do Controller para Cliente Detalhe.
appCliente.controller("clienteDetalheController", function($scope, $http, $routeParams){
	
	carregarClienteDetalhe = function() {
	$http({
	  method: 'GET',
	  url: 'http://localhost:8080/clientes/'+$routeParams.clienteId
	}).then(function successCallback(response) {
		$scope.cliente = response.data;
	  }, function errorCallback(response) {
	    alert("Erro ao carregar cliente!");
	  });
	};
	
	carregarClienteDetalhe();
	
});