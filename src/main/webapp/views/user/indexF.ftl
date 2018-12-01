<html>
<head>
    <title>jfinalDemo</title>
    <script src="${ctx}/static/js/jquery-1.9.1.min.js"></script>
</head>
<body>
<h1>用户列表</h1>

<div class="table_box">
            <#list users as user>
                 用户名：${user.username}
                 密  码：${user.password}
                 年  龄: ${user.age}
            </#list>
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</div>
</body>
<script type="text/javascript">
    /* 鼠标点击特效 - 7Core.CN */
    var a_idx = 0;
    jQuery(document).ready(function ($) {
        $("body").click(function (e) {
            var a = new Array("富强", "民主", "文明", "和谐", "自由", "平等", "公正", "法治", "爱国", "敬业", "诚信", "友善");
            var $i = $("<span/>").text(a[a_idx]);
            a_idx = (a_idx + 1) % a.length;
            var x = e.pageX, y = e.pageY;
            $i.css({
                "z-index": 100000000,
                "top": y - 20,
                "left": x,
                "position": "absolute",
                "font-weight": "bold",
                "color": "#ff6651"
            });
            $("body").append($i);
            $i.animate({"top": y - 180, "opacity": 0}, 1500, function () {
                $i.remove();
            });
        });
    });
</script>
</html>
