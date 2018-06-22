app.controller('myController',function($scope,bookingService){
	$scope.title="Online Booking Registration Page";
	
	 $scope.saveContact=function(){
		 if($scope.newcontact==null || $scope.newcontact==angular.undefined)
			 console.log('inside if condition');
		 bookingService.save($scope.newcontact);
		 $scope.contacts=bookingService.list();
		 console.log($scope.contacts);
		 $scope.newcontact={};
	 };
	
})