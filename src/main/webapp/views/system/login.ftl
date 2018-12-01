<html>
<head>
    <title>jfinalDemo</title>
    <script src="${ctx}/static/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>


</head>
<body>
<h1>JFinal Demo 项目首页</h1>

<div class="table_box">
    <input type="text" name="username" placeholder="用户名" />
    <input type="password" name="password" placeholder="密码" />
    <div class="error" style="width: 200px;height: 30px;display: none;color: red">
        用户名或者密码错误
    </div>
    <input type="button" value="登录" />

    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</div>
</body>
<script type="text/javascript">
    var g={ctx:'${ctx}'};
    $('input[type="button"]').click(function(){
        var username=$('input[name="username"]').val();
        var password=$('input[name="password"]').val();
        var  jsonData={username:username,password:password};
        $.ajax({
            type:"post",
            data:jsonData,
            url:g.ctx+"/user/login",
            success:function(result){
                if (result.status=="OK") {
                    window.location.href=g.ctx+"/user/pushView";
                }else{
                    layui.use('layer',function(){
                        layer.alert("用户名或密码错误！",{
                            icon: 5, time: 2000, offset: 't', closeBtn: 0, title: '错误信息', btn: [], anim: 2, shade: 0
                        });
                    });
                }
            }

        });
    });

</script>
</html>