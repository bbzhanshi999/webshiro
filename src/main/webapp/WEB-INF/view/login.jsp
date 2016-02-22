<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>登录页</title>
    <script type="text/javascript">
        function show(){
            var div = window.document.getElementById("signIn");
            div.style.visibility = "visible";
        }
    </script>
</head>
<body>
<div style="background-color: antiquewhite">
    <form action="${ctx}/login" method="post">
        用户名：<input type="text" name="username" placeholder="登录名"/>
        密码：<input type="password" name="password" placeholder="密码"/>
        <input type="submit" value="提交">
    </form>
</div>
<div>
    <input type="button" value="申请注册" onclick="show()"></div>

<div id="signIn" style="background-color:royalblue;visibility: hidden">
    <h6>请填写注册信息</h6>
    <form action="${ctx}/signIn" method="post">
        用户名：<input type="text" name="username" placeholder="登录名"/>
        密码：<input type="password" name="password" placeholder="密码"/>
        <input type="submit" value="提交注册">
    </form>
</div>
</body>
</html>
