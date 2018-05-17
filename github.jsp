<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="github.Topic1,github.*, java.io.*,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GitHub連携の練習ページ</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="sample.js"></script>
<script src="getCommits.js"></script>
<script src="getRepos.js"></script>
</head>

<body>

<script type="text/javascript">
document.write("jQueryのバージョンは" + $.fn.jquery + "です");
</script>

<h2>サンプル</h2>
<p>コミット者：<span id="out1"></span></p>
<p>表示2：<span id="out2"></span></p>
<p>ボタンを押すと通信が始まります</p>
<input type="button" id="btn1" value="ボタン1">

<br><br><br><br>

<hr>
<h2>GitHub連携の練習ページ</h2>
<a href="test_netbeans.jsp">yuichi0925/test_netbeans</a>
<p>リポジトリの情報を取得します。取得したいリポジトリ名を入力してください。</p><br>
<form action="Servlet" method ="POST">
リポジトリ名：<input type="text" name="repos_name" size="40">
<input type="submit" id="btn" value="表示">
</form>
<p>(例)　yuichi0925/test_netbeans</p>

<%
Topic1 topic = (Topic1)request.getAttribute("topic");
String repos_name = new String();
if(topic!=null){
%>

入力内容：「<%=topic.getRepos_name()%>」
<%repos_name = topic.getRepos_name();%>

<%
}
%>

<script type="text/javascript">
getRepos("<%=repos_name%>");
getCommits("<%=repos_name%>");
</script>

<br><br><br><br>

<span id="repos"></span>
<div id="output"></div>


</body>
</html>


<!--
http://localhost:8080/dbblog_copy/github.jsp
 -->