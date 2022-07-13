let pedirSueldoTrabajador = () => {
	let idTrabajador = document.getElementById("t").value;
	let m1 = document.getElementById("m1").value;
	let m2 = document.getElementById("m2").value;
	let m3 = document.getElementById("m3").value;
	axios.get(`http://localhost:8080/api/trabajadores/${idTrabajador}`)
		.then(response => {
			numero = response.data.sueldoPorHora;
			document.getElementById("sueldoTrabajador").value = numero;
		})
		.catch(e => {
			e.messagge
		})
	axios.get(`http://localhost:8080/api/materiales/${m1}`)
		.then(response => {
			numero = response.data.precio;
			document.getElementById("precioM1").value = numero;
		})
		.catch(e => {
			e.messagge
		})
	axios.get(`http://localhost:8080/api/materiales/${m2}`)
		.then(response => {
			numero = response.data.precio;
			document.getElementById("precioM2").value = numero;
		})
		.catch(e => {
			e.messagge
		})
	axios.get(`http://localhost:8080/api/materiales/${m3}`)
		.then(response => {
			numero = response.data.precio;
			document.getElementById("precioM3").value = numero;
		})
		.catch(e => {
			e.messagge
		})
}





let cargarMateriales = () => {
	let m1 = document.getElementById("m1").value;
	let m2 = document.getElementById("m2").value;
	let m3 = document.getElementById("m3").value;
	let mids = [m1, m2, m3];
	document.getElementById("materialesEnviar").value = mids;
};

let asignarCantidades = () => {
	let hhoras = document.getElementById("hhoras").value;
	let cc1 = document.getElementById("cc1").value;
	let cc2 = document.getElementById("cc2").value;
	let cc3 = document.getElementById("cc3").value;
	document.getElementById("horas").value = hhoras;
	document.getElementById("c1").value = cc1;
	document.getElementById("c2").value = cc2;
	document.getElementById("c3").value = cc3;
	let cantidades = [cc1, cc2, cc3];

	let m1 = document.getElementById("m1").value;
	let m2 = document.getElementById("m2").value;
	let m3 = document.getElementById("m3").value;

	document.getElementById("idMaterial1").value = m1;
	document.getElementById("idMaterial2").value = m2;
	document.getElementById("idMaterial3").value = m3;

	document.getElementById("cantidad1").value = cc1;
	document.getElementById("cantidad2").value = cc2;
	document.getElementById("cantidad3").value = cc3;

	document.getElementById("cantidadesEnviar").value = cantidades;
}

document.getElementById("boton2").addEventListener("click", function(e) {
	e.preventDefault();

	let m1 = document.getElementById("idMaterial1").value;
	let m2 = document.getElementById("idMaterial2").value;
	let m3 = document.getElementById("idMaterial3").value;
	if (m1 == m2 || m1 == m3 || m2 == m3) {
		e.preventDefault();
		document.getElementById("noIguales").hidden = false;
		setTimeout(function() {
			document.getElementById("noIguales").hidden = true;
		}, 2000);
	}

	let precioTrabajador = document.getElementById("horas").value * document.getElementById("sueldoTrabajador").value;
	let totalMaterial1 = document.getElementById("c1").value * document.getElementById("precioM1").value;
	let totalMaterial2 = document.getElementById("c2").value * document.getElementById("precioM2").value;
	let totalMaterial3 = document.getElementById("c3").value * document.getElementById("precioM3").value;
	let total = precioTrabajador + totalMaterial1 + totalMaterial2 + totalMaterial3;
	document.getElementById("final").value = total;



});


document.getElementById("guardarTrabajoNuevo").addEventListener("click", function(e) {

	if (document.getElementById("final").value == 0) {
		e.preventDefault();
		document.getElementById("noCero").hidden = false;
		setTimeout(function() {
			document.getElementById("noCero").hidden = true;
		}, 2000);
	}


})


document.getElementById("boton").addEventListener("click", function(e) {
	e.preventDefault();
	cargarMateriales();
	pedirSueldoTrabajador();
	asignarCantidades();
	document.getElementById("cont").hidden = false;
});