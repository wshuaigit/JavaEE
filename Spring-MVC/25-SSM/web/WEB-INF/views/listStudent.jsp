<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(function () {
        studentInfo();
    })

    function studentInfo() {
        $.ajax({
            url:"${pageContext.request.contextPath}/queryStudent",
            type:"post",
            success:function (data) {
                alert(data)
            }
        })
    }
</script>
</head>
<body>
       <div align="center">
           <p>listStudent.jsp</p>
       </div>
</body>
</html>
