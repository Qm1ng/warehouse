<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FADI - 存貨管理</title>
<link href="<c:url value="/resources/css/layui.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css" >
</head>
<body class="layui-layout-body animated fadeIn" id="layuiContainer">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo"><a href="${pageContext.request.contextPath}/welcome">FADI - 存貨管理</a></div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
            </ul>
            <ul class="layui-nav layui-layout-right">
            </ul>
        </div>

        <div class="layui-side layui-bg-black animated fadeInLeft">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="${pageContext.request.contextPath}/overview">所有商品</a>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="${pageContext.request.contextPath}/category">商品分類</a>
                    </li>
					<li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="${pageContext.request.contextPath}/section">部門分類</a>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="${pageContext.request.contextPath}/create">新增商品</a>
                    </li>
                </ul>
            </div>
        </div>


        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
			<h1>WELCOME</h1>
			<p>big camera stock management system</p>
            </div>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            Big Camera 2018 - All right reserved.
        </div>
    </div>
    <script src="<c:url value=" /resources/js/layui.js " />"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });
        function doDeletion() {
            return confirm("確定刪除嗎 ?");
        }
    </script>
</body>

</body>
</html>