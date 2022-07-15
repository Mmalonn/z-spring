$(document).ready(function() {
	$('#selectMateriales').select2({
		width: '200px',
		placeholder: 'Buscar material',
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
				var nuevosDatos = [];

				for (var material of data) {
					nuevosDatos.push({ id: material.id, text: material.nombre + '  $' + material.precio + ' c/u' });
				}

				return {
					results: nuevosDatos
				};
			},
			dataType: 'json'
		}
	}).on('select2:select', function(event) {
		window.location = '/materiales/' + event.params.data.id;
	});
});