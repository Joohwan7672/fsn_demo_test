<%@ include file="../layout/header.jsp" %>
  <form id="signup_form" method="post" action="/twitter/signup_ok">
	  <div>
		  <span>이름</span>
		  <input type="text" id="user_name" name="user_name" value="${object.user_name}" />
	  </div>
	  <div>
		  <span>휴대폰 번호 또는 이메일주소</span>
		  <input type="text" id="user_id" name="user_id" value="${object.user_id}" />
		  <span id="chk_result"></span>
	  </div>
	  <div>
		  <span>비밀번호</span>
		  <input type="password" id="user_password" name="user_password" value="${object.password}" />
	  </div>
	  <div>
		  <input type="button" id="signup_save" value="save" />
		  <a href="./list">목록</a>
	  </div>
  </form>
  </body>
  <script>
  $(document).ready(function(){
	  $("#user_id").blur(function(){
		  var user_id = $("#user_id").val();
		  var email_format = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		  if (!user_id){
			  alert("이메일을 입력하세요.");
			  return false;
		  }else{
			  if( !email_format.test(user_id)){
				 alert("이메일 형식을 확인하세요.");
				 return false;
			  }else{
				  $.ajax({
						type:"post"		
						,url:"/twitter/email_chk/"		
						,data:{"user_id": user_id}	//  요청에 전달되는 프로퍼티를 가진 객체
						,dataType:"text"
						,success:function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
							if(args == "Y"){
								$("#chk_result").html('사용가능');
							}else{
								$("#chk_result").html('중복된 아이디');
							}
						 }
						,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
					    	console.log(e.responseText);
					    }
					});				  
			  }
		  }
	  });
	  
	  $("#signup_save").on('click', function(){
		  var email_format = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		  var user_name = $("#user_name").val();
		  var user_id = $("#user_id").val();
		  var user_password = $("#user_password").val();
		  
		  if (!user_name){
			  alert("이름을 입력하세요.");
			  return false;
		  }
		  
		  if (!user_id){
			  alert("이메일을 입력하세요.");
			  return false;
		  }else{
			  if( !email_format.test(user_id)){
				 alert("이메일 형식을 확인하세요.");
				 return false;
			  }
		  }
		  
		  if(!user_password){
			  alert("비밀번호를 입력하세요.");
			  return false;
		  }
		  $("#signup_form").submit();
	  })
  })

  </script>
</html>