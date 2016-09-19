function CustomerEdit () {
	$http.get('customers/id', {params: {id: $scope.customerId}}).success(function(data) {
		$scope.customer = data;
	});
	
	$scope.save = function() {
		$http.get('');
	};
}