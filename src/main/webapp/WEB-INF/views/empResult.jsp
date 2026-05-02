<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page isELIgnored ="false"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Employee Result Page</h2>

<h3>Name : ${employee3.getEmpName() } </h3>
<h3>Email Id : ${employee3.getEmpEmailId() } </h3>
<h3>Phone No : ${employee3.getEmpPhoneNo() } </h3>
<h3>Grade : ${employee3.getEmpGrade() } </h3>
</body>
</html>