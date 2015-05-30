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
</head>
<body>
	<h3>Bem vindo, Cliente de Nutricionista</h3>
	<input accept="image/*" type="file" id="file" name="file"
		onchange="visuzalizarFoto(this.files[0]);">
	<input type="image" id="foto" src="images/fotorefeicaodefault.jpg">
	
</body>
</html>