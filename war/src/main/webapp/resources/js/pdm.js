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
        family: "Тестов",
        given: "Тест",
        middleName: "Тестович",
        gender: {
            value: "M", description: "2.16.840.1.113883.5.1"
        },
        birthInfo: {
            birthDate: "1970-01-30",
            birthPlace: {
                streetAddressLine: "Марс"
            }
        },
        telecoms: [
            { description: "WP", value: "tel:+7 (495) 229-53-70" },
            { value: "mailto:test@hitsl.ru" }
        ],
        addressList: [
            {
                description: "H",
                country: "2",
                state: "3",
                county: "4",
                precinct: "5",
                city: "6",
                streetName: "7",
                postalCode: "8",
                houseNumber: "9",
                buildingNumberSuffix: "10",
                additionalLocator: "11",
                streetAddressLine: "12"
            }
        ],
        documents: [
            {   description: "ПАСПОРТ РФ",
                name: "passport",
                attrs: [
                    {description: "Номер паспорта", value: "1234 567890", oid: "3.0.0.1"},
                    {description: "Дата выдачи", value: "1977-01-15", oid: "3.0.0.2"}
                ]
            }
        ]
    }

    $scope.updateTypes = [
        {name: "ошибка ввода", code: "MISPRINT" },
        {name: "изменение", code: "EXPIRED" },
        {name: "удалние", code: "DELETED" }
    ]

    $scope.updateTypeName = $scope.updateTypes[0];

    $scope.updateTypeGender = $scope.updateTypes[0];

    $scope.updateTypeBirthInfo = $scope.updateTypes[0];

    //  $scope.updateTypeTelecom;

    $scope.attrs = {}

    $scope.systemLogin = {
        oid: "4.0.0.1",
        password: "a"
    }

    $scope.createRes = {
    }

    $scope.clearAttrOption = function () {
        $scope.attrs = [];
    }

    $scope.updateNames = function () {
        var prm = {
            family: $scope.newPerson.family,
            given: $scope.newPerson.given,
            middleName: $scope.newPerson.middleName,
            token: $scope.newPerson.token,
            publicKey: $scope.personInfo.publicKey,
            updateInfo: {
                type: $scope.updateTypeName.code
            }
        }
        $http.put("../api/update", prm)
    }

    $scope.updateGender = function () {
        var prm = {
            token: $scope.newPerson.token,
            publicKey: $scope.personInfo.publicKey,
            gender: {
                value: $scope.newPerson.gender.value, description: "2.16.840.1.113883.5.1",
                updateInfo: {
                    type: $scope.updateTypeGender.code
                }
            }
        }
        $http.put("../api/update", prm)
    }

    $scope.updateBirth = function () {
        var prm = {
            token: $scope.newPerson.token,
            publicKey: $scope.personInfo.publicKey,
            birthInfo: {
                birthDate: $scope.newPerson.birthInfo.birthDate,
                birthPlace: $scope.newPerson.birthInfo.birthPlace,
                updateInfo: {
                    type: $scope.updateTypeBirthInfo.code
                }
            }
        }
        $http.put("../api/update", prm)
    }

    $scope.updateTelecom = function (telecom) {
        var prm = {
            token: $scope.newPerson.token,
            publicKey: $scope.personInfo.publicKey,
            telecoms: [
                {   description: telecom.description,
                    value: telecom.value,
                    publicKey: telecom.publicKey,
                    updateInfo: {
                        type: telecom.updateTypeTelecom.code
                    }
                }
            ]
        }
        $http.put("../api/update", prm)
    }

    $scope.updateTelecomAdd = function (telecom) {
        var prm = {
            token: $scope.newPerson.token,
            publicKey: $scope.personInfo.publicKey,
            telecoms: [
                {   description: telecom.description,
                    value: telecom.value
                }
            ]
        }
        $http.put("../api/update", prm)

    }

    $scope.updateAddr = function (addr) {
        var prm = {
            token: $scope.newPerson.token,
            publicKey: $scope.personInfo.publicKey,
            addressList: [
                {   description: addr.description,
                    country: addr.country,
                    state: addr.state,
                    county: addr.county,
                    precinct: addr.precinct,
                    city: addr.city,
                    streetName: addr.streetName,
                    postalCode: addr.postalCode,
                    houseNumber: addr.houseNumber,
                    buildingNumberSuffix: addr.buildingNumberSuffix,
                    additionalLocator: addr.additionalLocator,
                    streetAddressLine: addr.streetAddressLine,
                    publicKey: addr.publicKey,
                    updateInfo: {
                        type: addr.updateTypeAddr.code
                    }
                }
            ]
        }
        $http.put("../api/update", prm)
    }

    $scope.updateAddrAdd = function (addr) {
        var prm = {
            token: $scope.newPerson.token,
            publicKey: $scope.personInfo.publicKey,
            addressList: [
                {   description: addr.description,
                    country: addr.country,
                    state: addr.state,
                    county: addr.county,
                    precinct: addr.precinct,
                    city: addr.city,
                    streetName: addr.streetName,
                    postalCode: addr.postalCode,
                    houseNumber: addr.houseNumber,
                    buildingNumberSuffix: addr.buildingNumberSuffix,
                    additionalLocator: addr.additionalLocator,
                    streetAddressLine: addr.streetAddressLine
                }
            ]
        }
        $http.put("../api/update", prm)
    }


    $scope.addAttrOption = function (oid, description) {
        var a = {description: description, oid: oid};
        $scope.attrs.push(a);
    }

    $scope.loadPersonInfo = function (token, publicKey) {
        var prm = {token: token, publicKey: publicKey};
        $http.post("../api/get", prm).
            success(function (data) {
                $scope.newPerson = data;
            }
        );
    }

    $scope.loginAndLoad = function () {
        $http.post("api/login", $scope.systemLogin).
            success(function (data) {
                $scope.newPerson.token = data.id;
                $http.get("api/persons/?token=" + data.id).
                    success(function (data) {
                        $scope.persons = data.personList;
                        for (var i = 0; i < $scope.persons.length; i++) {
                            $scope.persons[i].publicKey = encodeURIComponent($scope.persons[i].publicKey);
                        }
                    }
                )
            }
        );
    }

    $scope.login = function () {
        $http.post(window.location.origin + "/api/login", $scope.systemLogin).
            success(function (data) {
                $scope.newPerson.token = data.id;
            }
        );
    }

    $scope.create = function () {
        $http.post("api/create", $scope.newPerson).
            success(function (data) {
                $scope.createRes.id = data.id;
            });
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

    $scope.addAttr = function (doc, newAttr) {
        doc.attrs.push(angular.copy(newAttr));
        $scope.newAttr = null;
    }

    $scope.removeAttr = function (doc, index) {
        doc.attrs.splice(index, 1);
    }


    $scope.removeTelecom = function (index) {
        $scope.newPerson.telecoms.splice(index, 1);
    }

    $scope.removeAddress = function (index) {
        $scope.newPerson.address.splice(index, 1);
    }

    $scope.removeDoc = function (index) {
        $scope.newPerson.documents.splice(index, 1);
    }

    $scope.sizeAttrs = function (index) {
        return $scope.newPerson.documents[index].attrs.length;
    }

}