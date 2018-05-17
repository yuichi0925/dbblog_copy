<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="blog.Topic, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>シンプルBlog</title>
</head>
<body>

<h2>シンプルBlog</h2>

<a href="read">リロード</a>

<form action="post" method="POST">
タイトル<input type="text" name="title" size="40">
<br>
<textarea name="content" rows="5" cols="40"></textarea>
<br>
<input type="submit" value="投稿">
</form>

<%
List topics = (List)request.getAttribute("topics");
if(topics != null){
	for(int i=topics.size()-1; i>=0; i--){
	//for(int i=0;i<topics.size(); i++){ 逆順に表示
		Topic topic = (Topic)topics.get(i);
%>

<hr>
タイトル：<%=topic.getTitle() %>
(<%=topic.getPostDate() %>)
<pre><%=topic.getContent()%></pre>

<%
	}
}
%>

</body>
</html>