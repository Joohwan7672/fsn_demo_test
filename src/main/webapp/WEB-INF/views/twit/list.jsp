<%@ include file="../layout/header.jsp" %>
<%@ page session="true" %>
<div class="left">
	<span class="new_twit_sub">내정보</span><br>
	<span>${sessionScope.tw_session.user_name}(${sessionScope.tw_session.user_id})</span><br>
	<a href="/twitter/logout">로그아웃</a>
</div>
<div class="center">
	<div class="new_twit">
		<span class="new_twit_sub">새 트윗 작성</span>
		<form id="new_twit_form" >
			<input type="hidden" name="twit_wr_user_idx" value="${sessionScope.tw_session.user_idx}">
			<textarea id="twit_content" name="twit_content" rows="5" cols="50"></textarea>
		</form>
		<input type="button" id="twit_save" value="저장">
		<input type="button" id="twit_cancel" value="취소">
	</div>
	<c:forEach var="item" items="${twit_list}" varStatus="status">
		<div class="twit_content">
			<span>${item.user_name} ${item.twit_wr_date}</span><br>
			<span>${item.twit_content}</span>
			<%-- <input type="button" class="twit_modify" alt="${item.twit_idx}" value="수정"> --%>
			<input type="button" class="twit_delete" alt="${item.twit_idx}" value="삭제">
		</div>
	</c:forEach>
</div>
<div class="right">
	<span class="recommand_sub">팔로우 추천</span><br>
	<c:forEach var="item" items="${user_list}" varStatus="status" end="2">
		<span>${item.user_name}(${item.user_id})</span>
		<span><input type="button" class="follow_ok" alt="${item.user_idx}" value="팔로우 "></span><br>
	</c:forEach>
</div>
</body>
<script>
$(document).ready(function(){
	$(".follow_ok").on('click', function(){
		var target_user_idx = $(this).attr('alt')
		$.ajax({
			type:"post"		
			,url:"/twitter/follow_ok/"		
			,data:{"target_user_idx": target_user_idx}
			,dataType:"html"
			,success:function(args){
				if(args == "Y"){
					location.replace('/twitter/twit_list');
				}else{
					alert("시스템 오류. 잠시후 다시 시도해 주세요.");
				}
			 }
			,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
		    	console.log(e.responseText);
		    }
		});	
	})
	
	$("#twit_save").on('click', function(){
		if($("#twit_content").val()){
			var frm_data = $('#new_twit_form').serialize();
	        $.ajax({
	            type: 'post',
	            url: '/twitter/twit_save',
	            data: frm_data,
	            dataType: 'html',
	            success: function (args) {
	                if (args.trim() == "Y") {
	                	location.replace('/twitter/twit_list');
	                } else {
	                    alert("시스템 오류. 잠시후 다시 시도하세요.");
	                }
	            },error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
			    	console.log(e.responseText);
			    }
	        });
		}else{
			alert("내용을 입력해 주세요.");
			$("#twit_content").focus();
		}
	})
	
	$("#twit_cancel").on('click', function(){
		$("#twit_content").val('');
	})
	
	$(".twit_delete").on('click', function(){
		var twit_idx = $(this).attr('alt');
		if(confirm("트윗을 삭제하겠습니까?")){
			$.ajax({
		           type: 'post',
		           url: '/twitter/twit_delete',
		           data: {"twit_idx": twit_idx},
		           dataType: 'html',
		           success: function (args) {
		               if (args.trim() == "Y") {
		               	location.replace('/twitter/twit_list');
		               } else {
		                   alert("시스템 오류. 잠시후 다시 시도하세요.");
		               }
		           },error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
			    	console.log(e.responseText);
			    }
		       });
		}
	})
})
</script>

</html>