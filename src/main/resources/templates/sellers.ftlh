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
    <h1 class="mb-3">Добавить продавца</h1>

</div>
<form method="post" action="/sellers">
    <label>Entity:
        <input type="text" name="entity" placeholder="Юр.Лицо">
    </label>
    <label>Phone:
        <input type="text" name="phone" placeholder="Номер">
    </label>
    <label>Email:
        <input type="text" name="email" placeholder="Почта">
    </label>
    <label>Adress:
        <input type="text" name="adress" placeholder="Адрес">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Юр.лицо</th>
        <th>Номер</th>
        <th>Почта</th>
        <th>Адрес</th>
        <th>Действия</th>

    </tr>
    <#list sellers as seller>
        <tr>
            <td>${seller.id}</td>
            <td>${seller.entity}</td>
            <td>${seller.phone}</td>
            <td>${seller.email}</td>
            <td>${seller.adress}</td>
            <td>
                <form method="post" action="/sellers/${seller.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="sellers/${seller.id}">Перейти</a>
            </td>

        </tr>
    </#list >

</table>
</body>
</html>
