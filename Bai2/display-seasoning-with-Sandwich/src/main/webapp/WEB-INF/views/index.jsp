<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SandWich Condiments</title>

</head>
<body>
<h3>SandWich Condiments </h3>
<form action="saves" method="get">
    <input type="checkbox" value="letter" name="condiments"> Lettuce
    <input type="checkbox" value="tomato" name="condiments"> Tomato
    <input type="checkbox" value="mustard" name="condiments"> Mustard
    <input type="checkbox" value="sprouts" name="condiments"> Sprouts
    <br>
    <br>
    <input type="submit" value="save">
</form>
</body>
</html>