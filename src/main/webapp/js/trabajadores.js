$(document).ready(function() {
		$('.eliminarTrabajador').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Esta seguro de eliminar el trabajador?", function(result){ 
				if(result) {
					window.location = hrefOriginal;
			}
		});			
	});
});	

$(document).ready(function() {
		$('.eliminarTrabajo').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Esta seguro de eliminar el trabajo?", function(result){ 
				if(result) {
					window.location = hrefOriginal;
			}
		});			
	});
});	
