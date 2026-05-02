<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page isELIgnored ="false"  %>  
 
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
<h2> Project Result Page</h2>

<h3> Latest Project Added</h3>

<h3>Project Id : ${project.getProjId() } </h3>

<h3>Project Name : ${project.getProjName() } </h3>

<table>

  <tr>
  	 <th> Project Id </th>
  	<th> Project Name</th>
  </tr>
<tr>
<td> ${projectList.get(0).getProjId()} </td>
<td> ${projectList.get(0).getProjName()} </td>
</tr>

  
      
   </table>

</body>
</html>