<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="masterpage.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/clinutr.js"></script>
<link rel="stylesheet" type="text/css" href="./styles/clinutr.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	// wait for the DOM to be loaded 
	$(document).ready(function() {
		//visuzalizarFoto();
	});
</script>
</head>
<body>
	<h3>Bem vindo, Cliente de Nutricionista</h3>
	<form id="myForm" action="CamadaController" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="service" value="armazenarfoto"> <input
			accept="image/*" type="file" id="file" name="file"
			onchange="armazenarEVisuzalizarFoto();"> <img
			id="foto" src="images/fotorefeicaodefault.jpg">
		<!-- input type="submit"> <div id="divfoto" name="divfoto"></div -->
	</form>
</body>
</html>