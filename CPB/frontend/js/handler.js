function add(form) {
	var elems = form.elements;
	var name = elems.Name.value;
	var phone = elems.Phone.value;
	var inipa = elems.INIPA.value;

	$.ajax({
		url: "http://localhost:8080/addIndividual?Name=" + name + "&Phone=" + phone + "&INIPA=" + inipa
	});
}

function reloadList() {
	$.ajax({
		type: "POST",
		dataType: "text",
		url: "http://localhost:8080/showAll"
	}).then(function (data) {
		var content = '<table>';
		content += '<tr>';
		content += '<td>' + 'Name' + '</td>';
		content += '<td>' + 'Phone' + '</td>';
		content += '<td>' + 'INIPA' + '</td>';
		content += '</tr>';

		var json = JSON.parse(data);

		for (var i = 0; i < json.length; i++) {
			content += '<tr>';

			content += '<td>' + json[i]['name'] + '</td>';
			content += '<td>' + json[i].phone + '</td>';
			content += '<td>' + json[i].inipa + '</td>';

			content += '</tr>';
		}

		content += '</table>';

		$('#list-of-individuals').html(content);
	}) 
}

function removeUser(name) {
	$.ajax({
		type: "DELETE",
		dataType: "text",
		url: "http://localhost:8080/removeUser?Name=" + name
	})
}

function search(form) {
	var name = form.elements.name_for_search.value;

	$.ajax({
		type: "POST",
		dataType: "text",
		url: "http://localhost:8080/search?Name=" + name
	}).then(function (data) {
		alert(data);
	})
}


$(document).ready(function() {
	reloadList();
});
