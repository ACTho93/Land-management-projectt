<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>		 
		  	<div class="sidebar content-box" style="display: block;">
                <!-- Nav-bar -->
				<ul class="nav">
				    <!-- Main menu -->
				    
				    
				    <li class="current"><a href="${pageContext.request.contextPath}/admincp"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
				   
				    <sec:authorize access="hasRole('ROLE_ADMIN')">
				    	<li><a href="${pageContext.request.contextPath}/admin/cat/index"><i class="glyphicon glyphicon-list"></i> Danh mục</a></li>
				    </sec:authorize>
				    
				     <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')">
				      <li><a href="${pageContext.request.contextPath}/admin/land/index"><i class="glyphicon glyphicon-book"></i> Tin  tức</a></li>
				    </sec:authorize>
				    
				    
				    <sec:authorize access="hasRole('ROLE_ADMIN')">
				    	<li><a href="${pageContext.request.contextPath}/admin/user/index"><i class="glyphicon glyphicon-user"></i> Người dùng</a></li>
				    </sec:authorize>
				    
				    
				    <li class="submenu">
				         <a href="${pageContext.request.contextPath}/admin/contact/index">
				            <i class="glyphicon glyphicon-list"></i> Liên hệ
				            <span class="caret pull-right"></span>
				         </a>
				         <!-- Sub menu -->
				         <ul>
				            <li><a href="login.html">Login</a></li>
				            <li><a href="javascript:void(0)">Signup</a></li>
				        </ul>
				    </li>
				</ul>
				<!-- /.nav-bar -->
             </div>
		