<#-- @ftlvariable name="users" type="java.util.List<ru.yusupov.models.User>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Token</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td><a href="/user/${user.id}">${user.login}</a></td>
        <td>${user.token}</td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>