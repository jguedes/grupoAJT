/**
 * 
 */
function visuzalizarFoto(foto) {

//	var reader = new FileReader();
//
//	reader.onload = function(e) {
//		$('#foto').attr('src', e.target.result);
//	}
//
//	reader.readAsDataURL(foto);
	
	$.ajax({
		url : "CamadaController",
		async : false,
		type : "POST",
		data : {
			service : "armazenarfoto",
			foto : "foto"
		},
		success : function(teste) {
			alert(teste);
		}
	});

}