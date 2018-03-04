<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Hello ~~~!</h1>
<div class='menuOuter'>
            <div class='menu'>
				<a href="<c:url value='/_01_register/register.jsp' />">
					 註冊 
				</a>
			</div>


            <div class='menu'>
				<a href="<c:url value='/Insert.jsp' />">
				     掛號 
				</a>
			</div>
			
			<div class='menu'>
                  <a href="<c:url value='/delete.jsp' />" >
				     取消掛號
				  </a>
			</div>
			
			<div class='menu'>
			     <a href="<c:url value='/select.jsp' />">
				     查詢掛號（個人） 
				 </a>
			</div>
			
			<div class='menu'>
				 <a href="<c:url value='/selectall.jsp' />">
				     查詢掛號(全部)
			     </a>
			</div>
</div>		     
          
		  
</body>
</html>
