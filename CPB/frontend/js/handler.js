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
	// $.ajax({
	// 	url: "http://localhost:8080/showAll"
	// }).then(function(data) {
	// 	$('#list-of-individuals').append(data.name);
	// 	$('#list-of-individuals').append(data.phone);
	// 	$('#list-of-individuals').append(data.INIPA);
	// 	// console.log(data);
	// });

	// $.getJSON("http://localhost:8080/showAll").done(function(data) {
	// 	var msg;
	// 	$.each(data, function(key, val) {
	// 		msg += '<div>' + key + ' ' + val + '</div>';
	// 	});
	// 	msg += '<br>';
	// 	$('#list-of-individuals').html(msg);
	// });

	// $.getJSON("http://localhost:8080/showAll").done(function(data) {
	// 	console.log(data);
	// });

	$.ajax({
		type: "POST",
		dataType: "text",
		url: "http://localhost:8080/showAll"
	}).then(function(data) {
		// console.log(data);
		$('#list-of-individuals').html(data);
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