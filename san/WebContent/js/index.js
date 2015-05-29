/**
 * João Guedes, 28 de maio de 2015
 */
function iniciar() {
	
	$.ajax({
		url : "CamadaController",
		async : false,
		type : "POST",
		data : {
			service : "iniciar"
		},
		success : function(login_jsp){
			open(login_jsp,'_self');
		}
	});

}