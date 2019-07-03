<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <section class="container">
        <div class="login">
            <h1>Авторизация</h1>
            <form method="post"  action="<c:url value='/login' />" method='POST'>
                <c:if test="${not empty message}">
                    <span class="error">${message}</span>
                </c:if>
                <p><input type="text" name="login" value="" placeholder="Логин"></p>
                <p><input type="password" name="password" value="" placeholder="Пароль"></p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <p class="submit"><input type="submit" name="commit" value="Войти"></p>
            </form>
        </div>
    </section>

</body>
</html>
