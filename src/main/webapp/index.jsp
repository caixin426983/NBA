<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>Bootstrap 实例 - 条纹表格</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="Script/Bootstrap/bootstrap-table.js"></script>
    <script src="Script/Bootstrap/bootstrap-table-zh-CN.js"></script>
</head>
<body>



<table id="cusTable" class="table table-striped" data-toggle="table"
       data-url="data1.json"
       data-striped="true"
       data-pagination="true"
       data-side-pagination="server"
>
    <thead>
    <tr>
        <th data-field="id">Item ID</th>
        <th data-field="username">Item Name</th>
        <th data-field="chinaName">Item Price</th>
    </tr>
    </thead>
</table>
</body>

<script>

    $(function () {



    });
</script>
</html>
