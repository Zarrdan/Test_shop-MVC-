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
    <h1 class="mb-3">Оставить отзыв</h1>

</div>
<form method="post" action="/reviews">
    <label>Name:
        <input type="text" name="name" placeholder="Наименование продукта">
    </label>
    <label>Review:
        <input type="text" name="review" placeholder="Напишите отзыв">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Наименование продукта</th>
        <th>Отзыв</th>
    </tr>
    <#list reviews as review>
        <tr>
            <td>${review.id}</td>
            <td>${review.name}</td>
            <td>${review.review}</td>
        </tr>
    </#list >
</table>
</body>
</html>