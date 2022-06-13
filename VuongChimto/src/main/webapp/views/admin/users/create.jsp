	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="store">
<div>
<label>	ho ten</label>
<input type="text" name="hoTen">
</div>
<br>	
<div>
<label>email</label>
<input type="text" name="email">
</div>
<div>
<label>dia chi</label>
<input type="text" name="diaChi">
</div>
<br>	
<div>
<label>Password</label>
<input type="password" name="password">
</div>
<div>
<label>sdt</label> 
<input type="text" name="sdt">
</div>
<br>	
<div>
<label>gioi tinh</label>
<input type="radio" name="gioiTinh" value="1">
<label>nam</label>
<input type="radio" name="gioiTinh" value="0">
<label>nữ</label>
</div>
<div>
	<button>thêm mới</button>
	<button type="reset">xoá form</button>
</div>
</form>
</body>
</html>