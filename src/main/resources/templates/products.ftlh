<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="p-5 text-center bg-light">
    <h1 class="mb-3">New item</h1>

</div>
<form method="post" action="/products">
    <label>Name:
        <input type="text" name="name" placeholder="Наименование продукта">
    </label>
    <label>Cost:
        <input type="number" name="cost" placeholder="Стоимость">
    </label>
    <label>Amount:
        <input type="number" name="Amount" placeholder="Количество">
    </label>
    <input type="submit" value="Добавить">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Продукт</th>
        <th>Стоимость</th>
        <th>Количество</th>
        <th>Действия</th>
    </tr>
    <#list products as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.cost}</td>
            <td>${product.amount}</td>
            <td>
                <form method="post" action="/products/${product.id}/delete">
                    <button type="submit" class="btn-danger" action="/users">Delete</button>
                </form>
                <a href="products/${product.id}">Edit</a>
            </td>
        </tr>
    </#list >
</table>

</body>
</html>
