<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Find User By Id</title>
</head>
<body>

    <#if errorMessage??>
        <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
    </#if>

    <#if user??>
        <p>${user.id}, ${user.name}, ${user.login}, ${user.age}, ${user.gender}, ${pulse}</p>

    </#if>
</body>
</html>