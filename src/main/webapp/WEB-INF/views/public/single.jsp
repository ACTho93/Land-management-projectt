<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="clearfix content">

	<h1>${landById.name}</h1>
	<div class="clearfix post-meta">
		<p>
			<span><i class="fa fa-clock-o"></i> Địa chỉ:
				${landById.address}</span> <span><i class="fa fa-folder"></i> Diện
				tích: ${landById.area}m2</span> <span><i class="fa fa-folder"></i>
				Lượt xem: ${landById.count_views}</span> <span> 
				<c:choose>
					<c:when test="${checkLike}">
						<a href="javascript:void(0)"><img
							onclick="clickLike(${landById.id},${checkLike})"
							height="20px" width="20px"
							src="${pageContext.request.contextPath}/publicUrl/images/LIKE1.png"></a>
					</c:when>
					<c:otherwise>
						<a href="javascript:void(0)"><img
							onclick="clickLike(${landById.id},${checkLike})"
							height="20px" width="20px"
							src="${pageContext.request.contextPath}/publicUrl/images/LIKE0.png"></a>
					</c:otherwise>

				</c:choose> Thích ${countLike} </span>
		</p>
	</div>

	<div class="vnecontent">
		<p>${landById.detail}</p>
	</div>


	<br />

	<div>
		<form class="form-cmt">
			<div class="article">
				<div class="aclass">
					<h2>Post a comment</h2>
				</div>
				<input type="text" name="cmt" id="cmt" value="" placeholder="" />
				<button name="button" type="button"
					onclick="return getComment(${landById.id})">Submit Comment</button>
			</div>


		</form>
	</div>

	<br />
	<div class="ajax-data">
		<form class="form-cmt">
			<div class="article">
				<c:choose>
					<c:when test="${not empty listCmtById}">
						<c:forEach items="${listCmtById}" var="listCmt">
							<input type="text" name="" id="" value="${listCmt.comment}" />
							<p>
								<span><a style="font-size: 10px; padding-left: 45px"
									href="javascript:void(0)">Thích</a></span> <span><a
									style="font-size: 10px; padding-left: 55px"
									href="javascript:void(0)">Phản hồi</a></span>
							</p>
						</c:forEach>
					</c:when>

				</c:choose>


			</div>
		</form>
	</div>


	<a class="btn"
		href="${pageContext.request.contextPath}/single/${land.id-1}">Bài
		trước</a> <a class="btn"
		href="${pageContext.request.contextPath}/single/${land.id+1}">Bài
		kế</a>

</div>
<div>
	<div class="more_themes">
		<h2>
			Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i>
		</h2>
		<div class="more_themes_container">
			<c:choose>
				<c:when test="${not empty listlandRelated}">
					<c:forEach items="${listlandRelated}" var="listRelated">
						<div class="single_more_themes floatleft">
							<img
								src="${pageContext.request.contextPath}/files/${listRelated.picture}"
								alt="" /> <a href=""><h2>${listRelated.name}</h2></a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div>Không có bài viết liên quan!</div>
				</c:otherwise>
			</c:choose>
		</div>
		<br />
	</div>
</div>


<script type="text/javascript">
	function getComment(id){
		var cmt = $("#cmt").val();
		$.ajax({
			url: '${pageContext.request.contextPath}/single/'+id,
				type : 'POST',
				cache : false,
				data : {
					cmt : cmt
				},
				success : function(data) {
					$(".ajax-data").html(data);
				},
				error : function() {
					alert("có lỗi trong quá trình xử lý!");
				}
			});
			return false;
		}
	
	function clickLike(landId, isLike){

		if(isLike){
			//console.log("huy like")
			$.ajax({
				url: '${pageContext.request.contextPath}/admin/land/cancel-like',
					type : 'POST',
					cache : false,
					data : {
						landId : landId,
						isLike : isLike
					},
					success : function(data) {
						//window.location.reload();
						//history.go(0);
					},
					error : function() {
						alert("có lỗi trong quá trình xử lý thêm like!");
					}
				});
		} else{
			//console.log("them like")
			$.ajax({
				url: '${pageContext.request.contextPath}/admin/land/add-like',
					type : 'POST',
					cache : false,
					data : {
						landId : landId,
						isLike : isLike
					},
					success : function(data) {
						//window.location.reload();
						//history.go(0);
					},
					error : function() {
						alert("có lỗi trong quá trình xử lý hủy like!");
					}
				});
		}
		
	}
	</script>