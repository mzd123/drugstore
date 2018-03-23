<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<script src="/js/jquery-3.1.1.js"></script>
<script>
    var deletes = ["3", "ff266c238499466ca2f5b1286e886397", "9b31943be94e48739755487759807781"];
    $(function () {
        $.ajax({
            type: "get",
            url: "/drugstore/authoritys/get_an_order",
            data: {items_ids_jsonstring: JSON.stringify(deletes)},
            dataType: "json",
            success: function (data) {
            },
            error: function () {
                alert("删除记录失败！")
            }
        })
    })

</script>
<body>

</body>
</html>
