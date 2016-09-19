var app = angular.module("supplyChainApp", ["ngRoute"]);

app.config(function($routeProvider, $locationProvider) {
	$routeProvider
	
	.when("/", {
		templateUrl: 'dashboard.html', // Edit this!
		controller: 'mainController'
	})
	
	.when("/dashboard", {
		templateUrl: 'dashboard.html',
		controller: 'dashboardController'
	})
	
	//------- Receiving Routers ---------------------------------
	.when("/item_entry", {
		templateUrl: 'item-entry.html',
		controller: 'itemEntryController'
	})
	
	.when("/delivery", {
		templateUrl: 'delivery.html',
		controller: 'deliveryController'
	})
	
	//------- Master File Routers ---------------------------------
	.when("/items", {
		templateUrl: 'item-list.html',
		controller: 'itemsController'
	})
	
	.when("/suppliers", {
		templateUrl: 'supplier-list.html',
		controller: 'suppliersController'
	})
	
	.when("/customers", {
		templateUrl: 'customer-list.html',
		controller: 'customersController'
	})
	
	.when("/truckers", {
		templateUrl: 'trucker-list.html',
		controller: 'truckersController'
	})
	
	.when("/locations", {
		templateUrl: 'location-list.html',
		controller: 'locationsController'
	})
	
	//------- Misc Routers ---------------------------------
	.when("/about", {
		templateUrl: 'about.html',
		controller: 'aboutController'
	})
	
	.when("/contact", {
		templateUrl: 'contact.html',
		controller: 'contactController'
	})
	
	.when("/help", {
		templateUrl: 'help.html',
		controller: 'helpController'
	})
	
	/*.otherwise({
		redirectTo: '/',
		controller: 'mainController'
	});*/
	
	// use the HTML5 History API to remove the # from URL
    //$locationProvider.html5Mode(true);
});
