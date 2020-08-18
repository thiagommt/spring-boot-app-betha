//Criação do módulo principal da aplicação.
var appCliente = angular.module("appCliente",['ngRoute', 'ngMask']);

appCliente.config(function ($routeProvider, $locationProvider) {
	
	$routeProvider
		.when("/clientes", {
			templateUrl: 'view/cliente.html', 
			controller : 'clienteController'
		})
		.when("/clientes/:clienteId", {
			templateUrl: 'view/cliente-detalhe.html', 
			controller : 'clienteDetalheController'
		})
		.when("/login", {
			templateUrl: 'view/login.html', 
			controller : 'loginController'
		})
		.otherwise({
		redirectTo: "/"
	});

	$locationProvider.html5Mode(true);
});	
