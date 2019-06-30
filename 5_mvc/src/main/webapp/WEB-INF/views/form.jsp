<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Form</title>
</head>
<body>

    <form:form modelAttribute="human" method="post" action="${contextPath}/form">
        <form:label path="name">
            First name
        </form:label>
        <form:input type="text" path="name" />
        </p>
        <form:label path="age">
            Age
        </form:label>
        <form:input type="text" path="age"/>
        </p>
        <button type="submit">Submit</button>
    </form:form>

</body>
</html>
