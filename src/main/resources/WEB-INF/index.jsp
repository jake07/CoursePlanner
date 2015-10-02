<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello React</title>
    <script type="text/javascript" src="../js/react.js"></script>
</head>
<body>
<div id="content">${content}</div>
<script type="text/javascript" src="../js/commentBox.js"></script>
<script type="text/javascript">
    $(function () {
        renderClient(${data});
    });
</script>
</body>
</html>