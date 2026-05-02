<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isELIgnored ="false"  %> 
<%@ page import = "tech.suj.Model.Employee3" %>
<%@ page import = "tech.suj.Model.Employee4" %>
<%@ page import = "tech.suj.Model.Project" %>
<%@ page import = "tech.suj.Model.Employees_Project" %>
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
 <h4> List of Employees with Projects </h4>
 
 <table>

  <c:forEach items="${mEmployee4List}" var="item">
       <tr>
          <td>  ${item.empId2} </td>
          <td>  ${item.empName2} </td>
          <td>  ${item.empEmailId2} </td>
          <td>  ${item.empPhoneNo2} </td>
          <td>  ${item.empGrade2} </td>
       </tr>
   </c:forEach>
        
</table>
<br>
<h6> ----------------------------------------------------------------------------------------------------------------------------------</h6>
		<table>
			<c:forEach var="entry" items="${aEmpProjMap}">
       
       	   		<c:out value="${entry.value}"/><br/><br/>
    		</c:forEach>
 
		</table>  
</body>
</html>