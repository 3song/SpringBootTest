<%--
  Created by IntelliJ IDEA.
  User: 10482
  Date: 2019-01-06
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path=request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
        $("p").click(function(){
            $(this).hide();
        });
    });
   function addUser() {
       $.ajax({
           type: "GET",
           url: "addUser",
           data: {username:$("#username").val(), content:$("#content").val()},
           dataType: "json",
           success: function(data){

           }
       });
   }
</script>
<html>
<head>
    <title>addUser</title>
</head>
<body>
    <c:set var="path" value="<%=basePath%>"/>
    <form action="${path}/addUser">
        <input type="text" name="username" value=""/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
