<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="/VuongChimto/helloServerlet">
<label>họ tên</label>
<input type="text" name="ho_ten"/>
<button>OK</button>
</form>	


<h2>hello ${vuong}</h2>
</body>
</html>