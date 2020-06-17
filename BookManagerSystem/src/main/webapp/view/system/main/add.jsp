<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath %>/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>/css/admin.css">
<script src="<%=basePath %>/js/jquery.js"></script>
<script src="<%=basePath %>/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form  class="form-x" action="<%=basePath %>/BookSevlet">  
    <!--再form 的属性action中的请求路径...传递不过去  如何实现 ：隐藏域实现  -->
    <input type="hidden" name="path" value="addbook">
      <div class="form-group">
        <div class="label">
          <label>图书名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="bookname" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
     
     
     
        <div class="form-group">
          <div class="label">
            <label>图书类型：</label>
          </div>
          <div class="field">
            <select name="bookType" class="input w50">
          
              <option value="1">1</option>
               <option value="2">2</option>
                <option value="3">3</option>
              
            
            </select>
            <div class="tips"></div>
          </div>
        </div>
         <div class="form-group">
          <div class="label">
            <label>是否可借：</label>
          </div>
          <div class="field">
            <input type="text" class="input w50" value="" name="isBorrow" data-validate="required:请输入标题" />
            <div class="tips"></div>
          </div>
        </div>
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>作者：</label>
        </div>
       <div class="field">
          <input type="text" class="input w50" value="" name="author" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="price" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>出版社：</label>
        </div>
        <div class="field"> 
          <script src="js/laydate/laydate.js"></script>
          <input type="text" class="laydate-icon input w50" name="press" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value=""  data-validate="required:日期不能为空" style="padding:10px!important; height:auto!important;border:1px solid #ddd!important;" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>发行时间：</label>
        </div>
       <div class="field">
          <input type="text" class="input w50" value="" name="publishtime" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      
     
      
     
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
</html>