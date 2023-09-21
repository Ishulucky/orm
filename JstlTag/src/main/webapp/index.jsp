<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/sampletag.tld" prefix="ish" %>
<%@ page import="com.jstl.JstlTagDrop" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom Tag Example</title>
</head>
<body>
    <h1>Custom JSP Tag Example</h1>
    from:
<ish:list tableName="ishu_trains" columnName="trn_start" url="jdbc:postgresql://192.168.110.48:5432/plf_training" 
    user="plf_training_admin" password="pff123"/><br>  <br> <br> <br> 
to:
<ish:list tableName="ishu_trains" columnName="trn_end" 
    url="jdbc:postgresql://192.168.110.48:5432/plf_training" user="plf_training_admin" password="pff123"/>
train name:
<ish:list tableName="ishu_trains" columnName="trn_name" valueColumn="trn_no"
    url="jdbc:postgresql://192.168.110.48:5432/plf_training" user="plf_training_admin" password="pff123"/>

   
</body>
</html>