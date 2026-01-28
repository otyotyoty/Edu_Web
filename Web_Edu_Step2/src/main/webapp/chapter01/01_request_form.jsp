<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request_Form</title>
<link rel="stylesheet" href="../css/style01.css" />
</head>
<body>
	<div>
		<h2>Request_Form</h2>
		<hr />
		<form action="request_result.jsp" method="get">
			<table width="400" border="1" cellspacing="1" cellpadding="5">
				<tr>
					<td>이름</td>
					<td><input type="text" size="10" name=username /></td>
				</tr>

				<tr>
					<td>직업</td>
					<td>
					<select name="job">
						<option selected>무직</option>
						<option >회사원</option>
						<option >전문직</option>
						<option >학생</option>
					</select>
					</td>
				</tr>
				
				<tr>
					<td>관심분야</td>
					<td>
					 <input type="checkbox" name=favorite  value="스포츠">스포츠
					 <input type="checkbox" name=favorite  value="IT">IT
					 <input type="checkbox" name=favorite  value="과학">과학
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" class="button-cell">
					 <input type="submit"  value="확인">
					 <input type="reset"  value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>