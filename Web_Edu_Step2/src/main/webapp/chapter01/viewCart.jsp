<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
<link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>

<div align="center">
        <h2>장바구니</h2>
        <%
        //세션영역에서 상품 리스트 가져오기
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
        
        	if(list !=null && !list.isEmpty()){
            %>
            <ul>
            <%
            	for(String product:list){ %>
            	<li><%= product %></li>	
            	<% }%>
            </ul>
                  <p>총 상품 수: <%= list.size() %></p>
             <% } else { %>
                <p>장바구니가 비어 있습니다.</p>
            <% } %>
            <hr />
            <a href="selectProduct.jsp">상품 추가</a>
            
</div>
</body>
</html>