<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  page isELIgnored ="false"  %> 
 <%@ page import = "tech.suj.Model.Employee3" %>
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

<table>

  <tr>
  	<th> Employee Id  ! </th>
  	<th> Name         ! </th>
  	<th> EmailId      ! </th>
  	<th> Phone No     ! </th>
  	<th> Grade        ! </th>
  </tr>
  
  <c:forEach items="${employeeList}" var="item">
       <tr>
          <td>                                           ${item.empId} </td>
          <td>  &nbsp; &nbsp; &nbsp; &nbsp;              ${item.empName} </td>
          <td>  &nbsp; &nbsp;                            ${item.empEmailId} </td>
          <td>  &nbsp; &nbsp;                            ${item.empPhoneNo} </td>
          <td>  &nbsp;                                   ${item.empGrade} </td>
       </tr>
  </c:forEach>
        
</table>

</body>
</html>