<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${product.name}</title>
</head>
<body>
<h3> Продукт - ${product.name} </h3>
<h3> Стоимость - ${product.cost} </h3>
<h3> Количество - ${product.amount} </h3>
<br>
<form method="post" action="/products/${product.id}/update">
    <label>
        Продукт: <input name="Name" value="${product.name}">
    </label>
    <label>
        Стоимость: <input name="cost" value="${product.cost}">
    </label>
    <label>
        Количество: <input name="amount" value="${product.amount}">
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
