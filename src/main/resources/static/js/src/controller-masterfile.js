app.controller('itemsController', function($scope) {
	$scope.message = 'You are in the items page!';
});

app.controller('suppliersController', function($scope) {
	$scope.message = 'You are in the suppliers page!';
});

app.controller('customersController', function($scope) {
	$scope.message = 'You are in the customers page!';
});

app.controller('truckersController', function($scope) {
	$scope.message = 'You are in the truckers page!';
});

app.controller('locationsController', function($scope) {
	$scope.message = 'You are in the locations page!';
});

function showModal() {
	$('#editCustomerPopup').modal();
}