<html>
    <head>
        <title>jfinalDemo</title>
    </head>
    <body>
        <h1>JFinal Demo 项目首页</h1>

        <div class="table_box">
            <#list users as user>
                 用户名：${user.username}
                 密  码：${user.password}
                 年  龄: ${user.age}
            </#list>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    </body>
</html>
