/*
 function addPerson() {
 $.post("create", function (data, status) {
 alert("status: " + status);
 window.location.replace("create");
 })
 }

 function cancelPerson() {
 window.location.replace("create");
 }*/
function createController($scope, $http) {
    $scope.newPerson = {
        family: null,
        given: null,
        middleName: null,
        sex: null,
        birthDate: null,
        birthPlace: null,
        telecoms: [
        ],
        address: [
        ],
        documents: [
        ]
    }
    $scope.create = function () {
        $http.post("create", $scope.newPerson);
    }

    $scope.addValue = function (list, newValue) {
        list.push({description: newValue.description, value: newValue.value});
        $scope.newValue = null;
    }

    /* $scope.reset = function() {
     $scope.newPerson =  $scope.personInfo;
     }
     */
}