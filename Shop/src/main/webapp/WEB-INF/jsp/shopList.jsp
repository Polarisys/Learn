<%--
  Created by IntelliJ IDEA.
  User: MY  GODCUP
  Date: 2019/12/28
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>商品列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>商品列表</h2>
        </div>
        <form name="firstForm" action="<%=request.getContextPath()%>/shops/search" method="post">
            <div class="panel-heading ">
                <table class="table table-bookName">
                    <thead>
                    <tr>
                        <th width="90" align="lift">商品关键字：</th>
                        <th width="150" align="lift">
                            <input type="text" name="title" class="allInput" value="${title}" placeholder="输入检索关键字^o^"/>
                        </th>
                        <th>
                            <input type="submit" value="检索" id="tabSub"/>
                        </th>
                    </tr>
                    </thead>
                </table>
            </div>
        </form>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>商品ID</th>
                    <th>商品标题</th>
                    <th>商品价格</th>
                    <th>商品数量</th>
                    <th>商品状态</th>
                    <th>创建时间</th>
                    <th>详细</th>
                </tr>
                </thead>
                <tbody id="shopList">
                <c:forEach items="${list}" var="sk">
                    <tr>
                        <td>${sk.id}</td>
                        <td>${sk.title}</td>
                        <td>${sk.price}</td>
                        <td>${sk.number}</td>
                        <td>${sk.status}</td>
                        <td>${sk.created}</td>
                        <td><a class="btn btn-info" href="/shop/shops/${sk.id}/detail " target="_blank">详细</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <nav aria-label="Page navigation">
            <ul class="pager pagination-lg">
                <li>
                    <a href="#" aria-label="Previous" id="previous"><span aria-hidden="true"><<</span></a>
                </li>
                <li><a href="#" id="first-column" class="columnFlag"></a></li>
                <li><a href="#" id="second-column" class="columnFlag"></a></li>
                <li><a href="#" id="third-column" class="columnFlag"></a></li>
                <li><a href="#" id="forth-column" class="columnFlag"></a></li>
                <li><a href="#" id="fifth-column" class="columnFlag"></a></li>
                <li>
                    <a href="#" aria-label="Next" id="next"><span aria-hidden="true">>></span></a>
                </li>
                <li><span>输入每页的条数</span><input type="text" id="recordNumber" value="5"></li>
            </ul>
        </nav>
    </div>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/resources/script/jquery.cookie.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/shopStoreing.js" type="text/javascript"></script>
</body>

<script type="text/javascript">
    $(function () {
        shopStoreing.list.init();
    });
</script>
</html>
