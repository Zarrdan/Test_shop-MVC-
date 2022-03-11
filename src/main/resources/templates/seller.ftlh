<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${seller.entity}</title>
</head>
<body>
<h3> Юр.Лицо - ${seller.entity} </h3>
<h3> Телефон - ${seller.phone} </h3>
<h3> Почта - ${seller.email} </h3>
<h3> Адрес - ${seller.adress} </h3>
<br>
<form method="post" action="/sellers/${seller.id}/update">
    <label>
        Юр.Лицо: <input name="entity" value="${seller.entity}">
    </label>
    <label>
        Телефон: <input name="phone" value="${seller.phone}">
    </label>
    <label>
        Почта: <input name="email" value="${seller.email}">
    </label>
    <label>
        Адрес: <input name="Adress" value="${seller.adress}">
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
