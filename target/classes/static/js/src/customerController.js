app.controller("CustomerControllerTes", function($scope, $http) {
	$http.get('/rest/customers').success(function(data) {
		$scope.customers = data;
	});
	
	$scope.filter = function() {
		
	};
	
	$scope.update = function() {
		$http.get('/customers', {params: {customers: $scope.customers}}
		).success(function(data) {
			$scope.customers = data;
		})
	};
});