<%--
  Created by IntelliJ IDEA.
  User: MY  GODCUP
  Date: 2019/12/29
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>商品详情</title>
    <%@include file="common/head.jsp" %>
    <link rel="stylesheet" href="common/spinner.css">
</head>
<h2 align="center">商品详情</h2>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>商品详情</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>商品ID</th>
                    <th>商品卖点</th>
                    <th>商品价格</th>
                    <th>商品数量</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.sellPoint}</td>
                    <td>${item.price}</td>
                    <td>${item.number}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="panel-body text-center">
            <h2 class="text-danger">
                <!--用来展示购买控件 -->
                <span class="glyphicon" id="shop-box"></span>
                <!--在js里面调用这个id还可以动态显示一些其他东西，例如动态时间等（需要插件）-->
                <span id="checkCar" class="glyphicon"><a class="btn btn-primary btn-lg" href=""
                                                         target="_blank">查看我的购物车</a></span>
                <!--如何获取该页面弹出层输入的学生ID， 传给上面的url-->
            </h2>
        </div>
    </div>
</div>
<!--登录弹出层 -->
<div id="chooseModel" class="modal fade" style="display:none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-studentId"> </span>请选择登录方式:
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-4 col-xs-offset-2">
                        <button type="button" class="btn btn-primary btn-lg" id="adminLogin">管理员登录</button>
                    </div>
                    <div class="col-xs-4">
                        <button type="button" class="btn btn-info btn-lg" id="userLogin">用户登录</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="userModel" class="modal fade" style="display:none">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span id="userText" class="glyphicon glyphicon-studentId"></span>
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="username" id="userIdKey"
                               placeholder="请输入帐号" class="form-control">
                    </div>
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="password" name="password" id="passwordKey"
                               placeholder="请输入密码" class="form-control">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <!--  验证信息 -->
                <span id="userMessage"> </span>
                <button type="button" id="userBtn" class="btn btn-success">
                    登录
                </button>
                <a href="#" class="btn" data-dismiss="modal">关闭</a>
            </div>
        </div>
    </div>
</div>
<body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/resources/script/jquery.cookie.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/shopStoreing.js" type="text/javascript"></script>
</body>

<script type="text/javascript">
    $(function () {
        shopStoreing.detail.init({
            id:${item.id}
        });
    });
</script>
</html>
