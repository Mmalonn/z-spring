$(document).ready(function() {
	$('#selectMateriales').select2({
		width: '200px',
		placeholder: 'Buscar 1',
		minimumInputLength: 1,
		ajax: {
			url: '/api/materiales/buscar',
			data: function(params) {
				var query = {
					nombre: params.term
				};
				return query;
			},
			processResults: function(data) {
				var nuevos = [];
				for (var material of data) {
					nuevos.push({ id: material.id, text: material.nombre + ' ' + material.precio });
				}

				return {
					results: nuevos
				};
			},
			dataType: 'json'
		}
	}).on('select2:select', function(event) {
		window.location = '/materiales/' + event.params.data.id;
	})
});