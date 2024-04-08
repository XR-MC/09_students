<%--
  Created by IntelliJ IDEA.
  User: TerryLiu
  Date: 2024/3/22
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      .grid{
        width: 100%;
        border-collapse: collapse;
      }

      .grid td,th{
        padding: 3px 5px;
        border:solid 1px cadetblue;
      }
    </style>
  </head>
  <body>
    <a href="init">新增学生信息</a>
    <table class="grid">
      <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>所属年级</th>
        <th>家庭住址</th>
        <th>状态</th>
        <th>&nbsp;</th>
      </tr>

      <c:forEach items="${list}" var="l">
        <tr>
          <td>${l.stuNo}</td>
          <td>${l.stuName}</td>
          <td>${l.gender}</td>
          <td>${l.age}</td>
          <td>${l.tel}</td>
          <td>${l.gradeId}</td>
          <td>${l.address}</td>
          <td>${l.state}</td>
          <td>
            <a href="#">删除</a>&nbsp;
            <a href="#">修改</a>
          </td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>
