<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/VuongChimto/dangkyservlet">
<div>
<label>	ho ten</label>
<input type="text" name="hoten">
</div>
<br>	
<div>
<label>email</label>
<input type="text" name="email">
</div>
<div>
<label>dia chi</label>
<input type="text" name="diachi">
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
<input type="radio" name="gioitinh" value="1">
<label>nam</label>
<input type="radio" name="gioitinh" value="0">
<label>nữ</label>
</div>
<div>
<label>loại KH</label>
<select name="loaiKH">
	<option value="1"> thường </option>
	<option value="0"> vip</option>
</select>
</div>
<div>
	<button>đăng ký</button>
	<button type="reset">xoá form</button>
</div>
</form>
</body>
</html>