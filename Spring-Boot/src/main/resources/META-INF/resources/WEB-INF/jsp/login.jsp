<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
	<head>
			<title>Login Page</title>
			</head>
			<div>		Welcome to the login page!
			</div>
		<form:form method="post" modelAttribute="loginDTO">
    <!-- Name field with error display -->
    <div>
        <label for="name">Name:</label>
        <form:input path="name" id="name" />
        <form:errors path="name" cssClass="error" />
    </div>
    
    <!-- Password field with error display -->
    <div>
        <label for="password">Password:</label>
        <form:input type="password" path="password" id="password" />
        <form:errors path="password" cssClass="error" />
    </div>
    
    <button type="submit">Login</button>
</form:form>

		
	</body>
</html>