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
    <title>新增学生信息</title>
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

    </style>
</head>
<body>
    <form method="post" action="add">
        <table class="grid">
            <caption>新增学生信息</caption>
            <tr>
                <th>姓名：</th>
                <td>
                    <input type="text" name="userName" />
                </td>
            </tr>
            <tr>
                <th>性别：</th>
                <td>
                    <input type="radio" name="gender" value="1"/>男
                    <input type="radio" name="gender" value="0"/>女
                </td>
            </tr>
            <tr>
                <th>年龄：</th>
                <td>
                    <input type="text" name="age" />
                </td>
            </tr>
            <tr>
                <th>联系电话：</th>
                <td>
                    <input type="text" name="tel" />
                </td>
            </tr>
            <tr>
                <th>所属年级：</th>
                <td>
                    <select name="gradeId">
                        <option value="0">---请选择---</option>

                    </select>
                </td>
            </tr>
            <tr>
                <th>家庭住址：</th>
                <td>
                    <input type="text" name="address" />
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
