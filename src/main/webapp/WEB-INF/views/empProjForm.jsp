<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page isELIgnored ="false"  %>    
<%@ page import = "tech.suj.Model.Project" %>
<%@ page import = "tech.suj.Model.Employee4" %>
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
<form action="empProjResult" method="post">
Name      : <input type="text" name="empName" />       <br/> <br/>
Email Id  : <input type="text" name="empEmailId" />    <br/> <br/>
Phone No  : <input type="text" name="empPhoneNo" />    <br/> <br/>
Grade   : <input type="text" name="empGrade" />  <br/> <br/>
Projects : 


<label for="Projects : ">Choose projects for the Employee :</label>
    <select name="projects" id="projects" multiple>
    
    
            
            
        <option value="Councelling">${projectListAsStr[0]}</option>
        <option value="Treatment">${projectListAsStr[1]}</option>
        <option value="All State On-line E-commerce">${projectListAsStr[2]}</option>
        <option value="Build and Track Personality with Your  God Gifts">${projectListAsStr[3]}</option>
    </select>
<input type="submit" value="Submit Form"           />
</form>
</body>
</html>