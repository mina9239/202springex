<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addMember</title>
</head>
<body>
	<h1>addMember</h1>
	<form action="./addMember" method="post">
		<table border="1">
			<tr>
				<td>MemberId</td>
				<td><input type="text" name="MemberId"></td>
			</tr>
			<tr>
				<td>MemberPw</td>
				<td><input type="text" name="MemberPw"></td>
			</tr>
			<tr>
				<td>MemberName</td>
				<td><input type="text" name="MemberName"></td>
			</tr>
		</table>
		<input type="submit" value="addMember">
	</form>

</body>
</html>