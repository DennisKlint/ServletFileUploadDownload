<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Files</title>
</head>
<body>
<%@ page import="java.io.*" %>
<% 
String file = application.getRealPath("/uploads");
File f = new File(file);
String [] fileNames = f.list();
File [] fileObjects= f.listFiles();
for (int i = 0; i < fileObjects.length; i++) {
if(!fileObjects[i].isDirectory()){
	String fname = file+fileNames[i];
    %> <a href=<%= "FileDownloadServlet?" + "file_name" + "=" + fileNames[i] %> ><%
	out.println(fileNames[i]);
    %></a><br><%
 }
}
%>
</body>
</html>