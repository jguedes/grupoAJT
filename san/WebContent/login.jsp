<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="masterpage.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/login.js"></script>
<link rel="stylesheet" type="text/css" href="./styles/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Bem vindo</h3>
	<form action="">
		<div>
			<div>
				<!-- label for="email">E-mail</label><br --> <input id="email"
					type="email" name="email"
					placeholder="E-mail">
			</div>
			<br> <br>
			<div>
				<!-- label for="senha">Senha</label><br --> <input id="senha"
					type="password" name="senha" placeholder="Senha">
			</div>
			<br>
			<div>
				<input id="btnLogar" type="button" value="Entrar">
			</div>
		</div>
	</form>
	<script type="text/javascript">
		configurarLoginPage();
	</script>
</body>
</html>