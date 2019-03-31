<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path=request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>#[[$Title$]]#</title>
</head>
<script type="application/javascript">
    function addUser() {
        window.location.href="<%=path%>/toAdd"
    }
</script>
<body>
<c:forEach items="${list}" var="user" varStatus="i">
    ${user.username}
</c:forEach>
<button onclick="addUser()">添加</button>
</body>
</html>
