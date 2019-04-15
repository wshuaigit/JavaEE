
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
            $(function () {
                $(".button").click(function () {
                    $.ajax({

                        url:"myajax.do",
                        data:{
                            "name":"zhangsan",
                            "age":23
                        },
                        type:"post",
                        dataType:"json",
                        success:function (resp) {
                            alert(resp)
                        }
                    })
                })
            })
    </script>

  </head>
  <body>
            index.jsp<br><br>
            <button class="button">发起ajax请求</button>
  </body>
</html>
