<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Продукты</title>
</head>
<body>
<h1>Корзина</h1>
<table>
    <tr>
        <th> ID</th>
        <th> Product</th>
        <th> Cost</th>
        <th> Amount</th>
        <th> Действие</th>
        <th> Оставить отзыв</th>
    </tr>
<#list products as product>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.cost}</td>
        <td>${product.amount}</td>
        <td>
            <form method="post" action="/customers/${customerId}/products/delete">
                <input name="productId" type="hidden" value="${product.id}">
                <input type="submit" value="Убрать">
            </form>
        </td>
    </tr>
</#list>
</table>
<h1>Продукты</h1>
<table>
    <tr>
        <th> ID</th>
        <th> Product</th>
        <th> Cost</th>
        <th> Amount</th>
        <th> Действие</th>
    </tr>
    <#list unusedProducts as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.cost}</td>
            <td>${product.amount}</td>
            <td>
                <form method="post" action="/customers/${customerId}/products">
                    <input name="productId" type="hidden" value="${product.id}">
                    <input type="submit" value="Добавить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
