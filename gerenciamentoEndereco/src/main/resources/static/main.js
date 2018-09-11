var app = angular.module("UserAddressManagement", []);
 
// Controller Part
app.controller("UserAddressController", function($scope, $http) {
 
 
    $scope.userAddress = [];
     $scope.stades = ["AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"];   

    $scope.userAddressForm = {
        stade: "default",
        city: "default",
        neighborhood: "default",
        street: "default",
        homeNumber: "default",
        complement: "default",
        cep: "default"
    };
    
     $(document).ready(function(){
    $('#MyButton').click(function(){
              if($scope.findId == null || $scope.findId == ""){
		alert("É necessário preencher o campo ID");
		return false;    
	}
    refreshUserAddressData(true);
    });
  });
  
$(document).ready(function(){
    $('#MyButtonAll').click(function(){

    refreshUserAddressData(false);
    });
  });
       
 
function findUserAddress() {
	if($scope.findId == null || $scope.findId == ""){
		alert("É necessário preencher o campo ID");    
	}
        $http({
            method: 'GET',
            async: false,
            url: '/usersAddress/' + $scope.findId
        }).then(function onSuccess(response) {	
			$scope.userAddresss = response.data;    		
  		}).catch(function onError(response) {
	if(response.data.errors[0].defaultMessage != null && response.data.errors[0].defaultMessage != ""){
    	alert(response.data.errors[0].defaultMessage);
    }
  });
 }   
    
    function loadForm(){
    
    	$scope.userAddressForm.stade = $scope.stade;
    	$scope.userAddressForm.city = $scope.city;
    	$scope.userAddressForm.neighborhood = $scope.neighborhood;
    	$scope.userAddressForm.street = $scope.street;
    	$scope.userAddressForm.homeNumber = $scope.homeNumber;
    	$scope.userAddressForm.complement = $scope.complement;
    	$scope.userAddressForm.cep = $scope.cep;
    	$scope.userAddressForm.id = $scope.id;
    }
 

    $scope.submitUserAddress = function() {
 		loadForm();
 		var message = "";
 		if($scope.userAddressForm.id != null){
 			method = "PUT";
 			var url = "/usersAddress/update";
 			message = "Endereco Alterado com sucesso!"
 		}
 		else{
        	method = "POST";
        	var url = "/usersAddress/save";
        	message = "Endereco Cadastrado com sucesso!"
		}
                
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.userAddressForm),
            async: false,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function onSuccess(response) {
       if(confirm(message) == true){
    	window.location.reload(true); 
    }
    else{
    	window.location.reload(true);
    }
  }).catch(function onError(response) {
  
	if(response.data.errors[0].defaultMessage != null && response.data.errors[0].defaultMessage != ""){
    	alert(response.data.errors[0].defaultMessage);
    }
  });
  
 }


            

 
    $scope.createUserAddress = function() {
        clearFormData();
    }
 
    $scope.deleteUserAddress = function(id) {
    if(confirm("Tem certeza que deseja excluir este usuário?") == false){
    	return false;
    }
        $http({
            method: 'DELETE',
            async: false,
            url: '/usersAddress/delete/' + id
        }).then(function onSuccess(response) {	
        	refreshUserAddressData(false);
  			 alert("Endereco excluido com sucesso!!");
    		
  		}).catch(function onError(response) {
	if(response.data.errors[0].defaultMessage != null && response.data.errors[0].defaultMessage != ""){
    	alert(response.data.errors[0].defaultMessage);
    }
  });
 }
 
 
    // In case of edit
    $scope.editUserAddress = function(userAddress) {
    
 		$scope.stade = userAddress.stade;
 		$scope.city = userAddress.city;
 		$scope.neighborhood = userAddress.neighborhood;
 		$scope.street = userAddress.street;
 		$scope.homeNumber = userAddress.homeNumber;
 		$scope.complement = userAddress.complement;
 		$scope.cep = userAddress.cep;
 		$scope.id = userAddress.id;
 			   	   
    	
    	  
    };
 
    // Private Method  
    // HTTP GET- get all userAddress collection
    // Call: http://localhost:8080/userAddress
    function refreshUserAddressData(find) {
    var url = "";
    	if(find){
    		url = '/usersAddress/' + $scope.findId;
    	}
    	else{
    		url = '/usersAddress/listAll/';
    	}
        $http({
            method: 'GET',
            async:false,
            url: url
            
        }).then(function onSuccess(response) {
        	if(find){
    			$scope.userAddresss = [response.data];
    		}
    		else{
    			$scope.userAddresss = response.data;
    		}
  }).catch(function onError(response) {
	if(response.data.errors[0].defaultMessage != null && response.data.errors[0].defaultMessage != ""){
    	alert(response.data.errors[0].defaultMessage);
    }
  });
 }
       
function createCustomAlert(txt) {


    d = document;

    if(d.getElementById("modalContainer")) return;

    mObj = d.getElementsByTagName("body")[0].appendChild(d.createElement("div"));
    mObj.id = "modalContainer";
    mObj.style.height = d.documentElement.scrollHeight + "px";

    alertObj = mObj.appendChild(d.createElement("div"));
    alertObj.id = "alertBox";
    if(d.all && !window.opera) alertObj.style.top = document.documentElement.scrollTop + "px";
    alertObj.style.left = (d.documentElement.scrollWidth - alertObj.offsetWidth)/2 + "px";
    alertObj.style.visiblity="visible";

    h1 = alertObj.appendChild(d.createElement("h1"));
    h1.appendChild(d.createTextNode("TESTE"));

    msg = alertObj.appendChild(d.createElement("p"));
    //msg.appendChild(d.createTextNode(txt));
    msg.innerHTML = txt;

    btn = alertObj.appendChild(d.createElement("a"));
    btn.id = "closeBtn";
    btn.appendChild(d.createTextNode(ALERT_BUTTON_TEXT));
    btn.href = "#";
    btn.focus();
    btn.onclick = function() { removeCustomAlert();return false; }

    alertObj.style.display = "block";

}

function removeCustomAlert() {
    document.getElementsByTagName("body")[0].removeChild(document.getElementById("modalContainer"));
}
 
    // Clear the form
    function clearFormData() {
    refreshUserAddressData(false);
       $scope.stade = undefined;
    	$scope.city = undefined;
    	$scope.neighborhood = undefined;
    	$scope.street = undefined;
    	$scope.homeNumber = undefined;
    	$scope.complement = undefined;
    	$scope.cep = undefined;
    	$scope.id = undefined;
    };
});
