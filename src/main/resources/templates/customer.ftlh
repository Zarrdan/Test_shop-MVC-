<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${customer.first_Name}</title>
</head>
<body>
<h3> Имя - ${customer.first_Name} </h3>
<h3> Фамилия - ${customer.last_Name} </h3>
<h3> Телефон - ${customer.phone} </h3>
<h3> Почта - ${customer.email} </h3>
<h3> Адрес - ${customer.adress} </h3>
<br>
<form method="post" action="/customers/${customer.id}/update">
    <label>
        Имя: <input name="first_Name" value="${customer.first_Name}">
    </label>
    <label>
        Фамилия: <input name="last_Name" value="${customer.last_Name}">
    </label>
    <label>
        Телефон: <input name="phone" value="${customer.phone}">
    </label>
    <label>
        Почта: <input name="email" value="${customer.email}">
    </label>
    <label>
        Адрес: <input name="adress" value="${customer.adress}">
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
