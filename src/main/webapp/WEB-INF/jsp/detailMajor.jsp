<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <title>专业简介</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>专业简介</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/major/detailMajor" method="post">
        <input type="hidden" name="mid" value="${major.mid}">
        <div class="form-group">
            <label>专业名称</label>
            <input type="text" name="mname" value="${major.mname}" class="form-control" required disabled >
        </div>
        <div class="form-group">
            <label>学分</label>
            <input type="text" name="credit" value="${major.credit}" class="form-control" required disabled>
        </div>
        <div class="form-group">
            <label>毕业年限</label>
            <input type="text" name="lifeyear" value="${major.lifeyear}" class="form-control" required disabled>
        </div>
        <div class="form-group">
            <label>专业介绍</label>
            <input type="text" name="introduction" value="${major.introduction}" class="form-control" required disabled>
        </div>
        <div class="form-group">
            <label>学院名称</label>
            <select name="cid" id="">
                <option value="-1">==请选择==</option>
                <%-- 动态--%>
                <c:forEach items="${collegeList}" var="college">
                    <option value="${college.cid}"
                            <c:if test="${major.cid == college.cid}">selected</c:if>
                    >${college.canme}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="返回列表页">
        </div>
    </form>
</div>
</body>
</html>


