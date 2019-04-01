<%--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/25/2019
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.


--%>


<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath}/js/product/product_list.js"></script>
<script type="text/javascript" src="${basePath}/js/common/page.js"></script>

<form>
    <div>
            <div class="form-group">
                <label for="nameId" class="col-sm-2 control-label" >姓名：</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control required" name="name" id="nameId"  placeholder="请输入名字">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control required" name="password" id="password">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label"> 有效: </label>
                <div class="col-md-10">
                    <label class="radio-inline"><input  type="radio" name="valid" checked value="1" > RemeberMEe</label>
                </div>
            </div>
    </div>


</form>

<script type="text/javascript" src="${basePath}/js/login/login_edit.js"></script>








</body>
</html>
