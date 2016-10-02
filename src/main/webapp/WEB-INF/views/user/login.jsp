<%@ include file="../layout/header.jsp" %>
<div class="login">
	<h1>FSN Twitter Login</h1>
	<form id="login_form" method="post" action="/twitter/login_chk">
		<table>
			<tr>
				<td>이메일주소</td>
				<td><input type="text" id="user_id" name="user_id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="user_password" name="user_password" /></td>
			</tr>
			<tr>
				<td colspan="2" class="align_c">
					<input type="button" id="login_chk" value="로그인" />
					<a href="./signup"><input type="button" value="회원가입" /></a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
  <script>
  $(document).ready(function(){
	  $("#user_id").focus();
	  
	  $("#login_chk").on('click', function(){
		  var email_format = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		  var user_id = $("#user_id").val();
		  var user_password = $("#user_password").val();
		  
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
		  $("#login_form").submit();
	  })
	  
	  $("#user_password").keypress(function(e) { 
		    if (e.keyCode == 13){
		        $("#login_chk").click();
		    }    
		});
  })

  </script>
</html>