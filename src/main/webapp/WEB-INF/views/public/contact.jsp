<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>  
					
					<div class="clearfix content">
						
						<div class="contact_us">
						
							<h1>Liên hệ với chúng tôi</h1>
							
							<p>
							TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br />
							Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br />
							Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
							</p>
							<br />
							<c:if test="${not empty msg}">
							<p style="color: green">${msg}</p>
							</c:if>
							<form action="${pageContext.request.contextPath}/lien-he" method="post">
								<p style="color: red">(*): Bắt buộc</p>
								<p>Họ Tên *:</p>
								<p><input type="text" name="fullname" class="wpcf7-text" placeholder="Họ tên *"/>
								<form:errors cssStyle="color: red"  path="contact.fullname"></form:errors></p>
								
								<p>EmailTo * ( người nhận ):</p>
								<p><input type="text" value="aocongtho93@gmail.com" name="emailto" class="wpcf7-email" placeholder="emailto"/>
								<form:errors cssStyle="color: red"  path="contact.emailto"></form:errors></p>
								
								
								<p>Subject:</p>
								<p><input type="text" name="subject" class="wpcf7-text" placeholder="Chủ đề *"/>
								<form:errors cssStyle="color: red"  path="contact.subject"></form:errors></p>
								
								<p>Email *:</p>
								<p><input type="text" name="email" class="wpcf7-text" placeholder="email *"/>
								<form:errors cssStyle="color: red"  path="contact.email"></form:errors></p>
								
								<p>Link Zalo:</p>
								<p><input type="text" name="zalo" class="wpcf7-text" placeholder="zalo"/>
								
								<p>Link Facebook:</p>
								<p><input type="text" name="facebook" class="wpcf7-text" placeholder="facebook"/>
								
								<p>Content *:</p>
								<p><textarea name="content" class="wpcf7-textarea" placeholder="Nội dung *"></textarea>
								<form:errors cssStyle="color: red"  path="contact.content"></form:errors></p>
								<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ"/></p>
							</form>
						</div>
						
					</div>
					
	<script type="text/javascript">

	 document.getElementById("color").classList.add('cat-item');
	
</script>		
