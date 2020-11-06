<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
    <h2>专业管理系统</h2>
    <form action="${pageContext.request.contextPath}/major/list" method="post" id="myform">
        <input type="hidden" id="pageNum" name="pageNum">
        学院名称:
        <select name="searchId" id="">
            <option value="-1">==请选择==</option>
            <c:forEach items="${collegeList}" var="college">
                <option value="${college.cid}"
                        <c:if test="${college.cid == condition.searchId}">selected</c:if>
                >${college.canme}</option>
            </c:forEach>
        </select>
        专业名称: <input type="text" name="searchName" value="${condition.searchName}">
        学分: <input type="text" name="startPay" value="${condition.startPay}"> 到
        <input type="text" name="endPay" value="${condition.endPay}">
        <input type="submit" value="查询">
        <input type="button" value="添加专业" onclick="addMajor()">
    </form>
    <table border="1" cellspacing="0" cellpadding="10" width="80%">
        <tr>
            <th>专业编号</th>
            <th>专业名称</th>
            <th>学制</th>
            <th>学分</th>
            <th>学院名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="major">
            <tr>
                <td>${major.mid}</td>
                <td>${major.mname}</td>
                <td>${major.LifeYear}</td>
                <td>${major.credit}</td>
                <td>${major.college.cname}</td>
                <td>
                    <a href="javascript:deleteById(${major.mid})">删除</a>
                    &nbsp; | &nbsp;
                    <a href="javascript:detailMajor(${major.mid})">详细</a>
                    &nbsp; | &nbsp;
                    <a href="javascript:toUpdate(${major.mid})">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <%-- 分页组件--%>
    <table>
        <tr>
            <td><a href="javascript:toPage(1)">首页</a></td>
            <td><a href="javascript:toPage(${pageInfo.pageNum-1})">上一页</a></td>
            <td><a href="javascript:toPage(${pageInfo.pageNum+1})">下一页</a></td>
            <td><a href="javascript:toPage(${pageInfo.pages})">尾页</a></td>
            <td>
                跳转到
                <input type="text" id="t_p">
            </td>
            <td><input type="button" value="Go" onclick="goToPage()"></td>
        </tr>
    </table>
    总记录数:${pageInfo.total} 总页面数:${pageInfo.pages} 当前页面:${pageInfo.pageNum}
</center>
</body>
<script>
    function toPage(pageNum) {
        //给隐藏域赋值
        $("#pageNum").val(pageNum);
        //提交表单
        $("#myform").submit();
    }
    function goToPage() {
        toPage($("#t_p").val());
    }
    function addMajor() {
        location.href = "${pageContext.request.contextPath}/major/toAddMajor";
    }
    function toUpdate(mid) {
        location.href = "${pageContext.request.contextPath}/major/toUpdateMajor?mid="+mid
    }
    function deleteById(mid) {
        location.href = "${pageContext.request.contextPath}/major/deleteMajor?mid="+mid
    }
    function detailMajor(mid) {
        location.href = "${pageContext.request.contextPath}/major/findMajor?mid="+mid
    }
</script>
<script>
    <c:if test="${insert=='success'}">
        alert("添加成功")
    </c:if>
    <c:if test="${insert=='fail'}">
        alert("添加失败")
    </c:if>
    <c:if test="${update=='success'}">
        alert("修改成功")
    </c:if>
    <c:if test="${update=='fail'}">
        alert("修改失败")
    </c:if>
    <c:if test="${delete=='success'}">
        alert("删除成功")
    </c:if>
    <c:if test="${delete=='fail'}">
        alert("删除失败")
    </c:if>
</script>
</html>
