<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="github.*, java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>yuichi0925/test_netbeans</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="getCommits.js"></script>
<script src="getRepos.js"></script>
</head>

<body>

<h2>yuichi0925/test_netbeans</h2>

<script type="text/javascript">
getRepos("yuichi0925/test_netbeans");
getCommits("yuichi0925/test_netbeans");
</script>

<span id="repos"></span>
<div id="output"></div>
</body>
</html>

<!--
http://localhost:8080/dbblog_copy/github.jsp
 -->