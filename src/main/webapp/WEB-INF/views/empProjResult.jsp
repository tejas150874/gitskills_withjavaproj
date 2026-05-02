<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page isELIgnored ="false"  %> 
 <%@ page import = "tech.suj.Model.Employee3" %>
  <%@ page import = "tech.suj.Model.Project" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Employee Result Page</h2>
<h3>Emp Id : ${employee3.getEmpId() } </h3>
<h3>Name : ${employee3.getEmpName() } </h3>
<h3>Email Id : ${employee3.getEmpEmailId() } </h3>
<h3>Phone No : ${employee3.getEmpPhoneNo() } </h3>
<h3>Grade : ${employee3.getEmpGrade() } </h3>

<table>

  <tr>
  	<th> Project Id   ! </th>
  	<th> Name         ! </th>
  </tr>
   
  <c:forEach items="${projectList2}" var="item">
       <tr>
          <td>                                           ${item.projId} </td>
          <td>  &nbsp; &nbsp; &nbsp; &nbsp;              ${item.projName} </td>
          
     
       </tr>
  </c:forEach>
        
</table>	
</body>
</html>