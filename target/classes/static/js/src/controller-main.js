app.controller('mainController', function($scope, $location) {
	$scope.message = 'Everyone come and see how good I look!';
});

app.controller('dashboardController', function($scope, $location) {
	$scope.message = 'You are in the dashboard!';
	$scope.isActive = function(path) {
		return path === $location.path();
	}
});

app.controller('sideBarController', function($scope, $location) { // for highlighting active menu item
	$scope.isActive = function(path) {
		return path === $location.path();
	}
});
