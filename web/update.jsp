<%--
  Created by IntelliJ IDEA.
  User: TerryLiu
  Date: 2024/3/29
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改学生信息</title>
    <style type="text/css">



        .grid{
            width: 600px;
            margin: 0px auto;
            border-collapse: collapse;
        }

        .grid th,td{
            padding: 5px 6px;
            border: solid 1px cadetblue;
        }

        .grid th{
            text-align: right;
            background: lightgray;
        }
        a,th,td{
            font-family: 楷体;color: black;font-size: x-large;
        }

    </style>
</head>
<body>
    <form method="post" action="update">
<%--        使用隐藏域--%>
        <input type="hidden" name="stuNo" value="${student.stuNo}" />

        <table class="grid">
            <caption>修改学生信息</caption>
            <tr>
                <th>姓名：</th>
                <td>
                    <input type="text" name="userName" value="${student.stuName}"/>
                </td>
            </tr>
            <tr>
                <th>性别：</th>
                <td>
                    <c:if test="${student.gender}" var="flag">
                        <input type="radio" name="gender" value="1" checked="checked"/>男
                        <input type="radio" name="gender" value="0"/>女
                    </c:if>
                    <!-- jstl标签没有else语句，所以重复用if-->
                    <c:if test="${!flag}">
                        <input type="radio" name="gender" value="1"/>男
                        <input type="radio" name="gender" value="0" checked="checked"/>女
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>年龄：</th>
                <td>
                    <input type="text" name="age" value="${student.age}"/>
                </td>
            </tr>
            <tr>
                <th>联系电话：</th>
                <td>
                    <input type="text" name="tel" value="${student.tel}"/>
                </td>
            </tr>
            <tr>
                <th>所属年级：</th>
                <td>
                    <select name="gradeId">
                        <option value="0">---请选择---</option>

                        <c:forEach items="${grades}" var="g">
<%--                            <option value="${g.gradeId}">${g.gradeName}</option>--%>


<%--                            判断学生当前年级Id与所属Id是否相等 --%>
<%--                            学生所属Id与当前下拉列表年级Id相同--%>
                            <c:if test="${g.gradeId==student.gradeId}" var="flag1">
                                <option value="${g.gradeId}" selected="selected">${g.gradeName}</option>
                            </c:if>

<%--                            学生所属Id与当前下拉列表年级Id不一致--%>
                            <c:if test="${!flag1}">
                                <option value="${g.gradeId}">${g.gradeName}</option>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>家庭住址：</th>
                <td>
                    <input type="text" name="address" value="${student.address}"/>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="提交" />
                    <input type="reset" value="重置" />
                </th>
            </tr>
        </table>
    </form>
</body>
</html>
