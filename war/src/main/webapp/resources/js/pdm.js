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
        list.push(angular.copy(newValue));
        $scope.newValue = null;
    }

    $scope.addAddress = function (list, newValue) {
        list.push(angular.copy(newValue));
        $scope.newAddress = null;
    }

    $scope.addDoc = function (list, newValue) {
        $scope.newPerson.documents.push(angular.copy(newValue));
        $scope.newDoc = null;
    }

    $scope.removeTelecom = function(index) {
        $scope.newPerson.telecoms.splice(index, 1);
    }

    $scope.removeAddress = function(index) {
        $scope.newPerson.address.splice(index, 1);
    }

    $scope.removeDoc = function(index) {
        $scope.newPerson.documents.splice(index, 1);
    }

    $scope.sizeAttrs = function(index) {
        return $scope.newPerson.documents[index].attrs.length;
    }

    /* $scope.reset = function() {
     $scope.newPerson =  $scope.personInfo;
     }
     */
}