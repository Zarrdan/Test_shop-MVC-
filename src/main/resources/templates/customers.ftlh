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
    <h1 class="mb-3">Покупатели</h1>

    </div>

<form method="post" action="/customers">
    <div class="p-5 text-center bg-light">
    <label>First name:
        <input type="text" name="first_Name" placeholder="Имя">
    </label>
    <label>Last name:
        <input type="text" name="last_Name" placeholder="Фамилия">
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
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Номер</th>
        <th>Почта</th>
        <th>Адрес</th>
        <th>Действия</th>
    </tr>
    <#list customers as customer>

        <tr>

            <td>${customer.id}</td>
            <td>${customer.first_Name}</td>
            <td>${customer.last_Name}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>
            <td>${customer.adress}</td>
            <td>
                <form method="post" action="/customers/${customer.id}/delete">
                    <button type="submit" class="btn-danger" action="/users">Удалить</button>
                </form>
                <a href="/customers/${customer.id}/products">Корзина</a>
                <a href="customers/${customer.id}">Изменить данные</a>
            </td>

        </tr>

    </#list >
</table>
</body>
</html>
