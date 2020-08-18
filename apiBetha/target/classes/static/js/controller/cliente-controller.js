//Criação do Controller para Cliente.
appCliente.controller("clienteController", function($scope, $http){
	
	$scope.clientes = [];
	$scope.cliente = {};
	
	carregarClientes = function() {
	$http({
	  method: 'GET',
	  url: 'http://localhost:8080/clientes'
	}).then(function successCallback(response) {
		$scope.clientes = response.data;
	  }, function errorCallback(response) {
	    alert("Erro ao carregar clientes!");
	  });
	};
	
	$scope.salvarCliente = function() {
	debugger;
	$http({
	  method: 'POST',
	  url: 'http://localhost:8080/clientes',
	  data: $scope.cliente
	}).then(function successCallback(response) {
		//$scope.clientes.push(response.data);
		carregarClientes();
		$scope.cancelarAlteracao();  
		$scope.frmCliente.$setPristine(true);
	  }, function errorCallback(response) {
	    alert("Erro ao cadastrar cliente!");
	  });
	};
	
	$scope.excluiCliente = function(cliente) {
	$http({
	  method: 'DELETE',
	  url: 'http://localhost:8080/clientes/'+cliente.id
	}).then(function successCallback(response) {
		var indexAremover = $scope.clientes.indexOf(cliente);
		$scope.clientes.splice(indexAremover, 1);
	  }, function errorCallback(response) {
	  	alert("Cliente nao excluido!");
	  });
	};
	
	$scope.alterarCliente = function(cliente) {
		$scope.cliente = angular.copy(cliente);
	};
	
	$scope.cancelarAlteracao = function() {
		$scope.cliente = {};
	};
	
	carregarClientes();
	
});