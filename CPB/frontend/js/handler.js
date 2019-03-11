function add(form) {
	var elems = form.elements;
	var name = elems.Name.value;
	var phone = elems.Phone.value;
	var inipa = elems.INIPA.value;

	$.ajax({
		url: "http://localhost:8080/addIndividual?name=" + name + "&phone=" + phone + "&INIPA=" + inipa
	});
}

function reloadList() {
	$.ajax({
		type: "POST",
		dataType: "text",
		url: "http://localhost:8080/showAll"
	}).then(function(data) {
		// console.log(data);
		$('#list-of-individuals').html(data);
	}) 
}

function removeUser(name) {
	$.ajax({
		type: "DELETE",
		dataType: "text",
		url: "http://localhost:8080/removeUser?Name=" + name
	})
}

/*
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/showAll"
    }).then(function(data) {
       $('#list-of-individuals').append(data);
    });
});
*/