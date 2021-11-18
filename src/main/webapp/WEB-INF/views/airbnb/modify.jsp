<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
<link rel="stylesheet" href="/jung/resources/css/modify.css">
	<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
	
	<script>
	
	
		function send(f){
			var phoneno = f.phoneno.value.trim();
			var email = f.email.value.trim();
			var addr = f.addr.value.trim();
			var pwd = f.pwd.value.trim();
			
			if(phoneno == ''){
				alert("전화번호를 입력하세요");
				return;
			}
			
			if(email == ''){
				alert("이메일주소를 입력하세요");
				return;
			}
			
			if(addr == ''){
				alert("주소를 입력하세요");
				return;
			}
			
			if(pwd == ''){
				alert("비밀번호를 입력하세요");
				return;
			}
			
			var url = "modify.do";
			var param = "idx="+f.idx.value+
						"&phoneno="+encodeURIComponent(phoneno)+"&email="+encodeURIComponent(email)+
						"&addr="+encodeURIComponent(addr)+
						"&pwd="+encodeURIComponent(pwd);
		
			sendRequest(url, param, resultFn, "POST");
		}
		
		function resultFn(){
			
			if(xhr.readyState == 4 && xhr.status == 200){
				
				var data = xhr.responseText;
				
				if(data == 'no'){
					alert("수정실패");
				}else{
					alert("수정성공");
					location.href='myPage.do';
				}
			}
		}
	</script>


</head>
<body>
<form>
	<input type="hidden" name="idx" value="${cus[0].idx}">

		<div class="container">
	        <div class="logo"><img src="${pageContext.request.contextPath}/resources/img/11.png" alt="주거상점" width="250" height="100"></div>
	
	        <div>
	            <h5 class="name">이름</h5>
	            <div class="name_box">
	                ${ cus[0].name }
	                <img src="${pageContext.request.contextPath}/resources/img/locked.png" alt="" class="locked1"> 
	            </div>  
	                     
	
	            <h5>아이디</h5>
	            <div class="id_box">
	                ${ cus[0].id }
	                <img src="${pageContext.request.contextPath}/resources/img/locked.png" alt="" class="locked2">
	            </div>  
	                   
	
	            <h5>전화번호</h5>
	            <div class="tel_box1">
	                ${ cus[0].phoneno }
	            </div>
	            	
	            <div class="tel_box2">
	                <input type="tel" name="phoneno" placeholder="ex) 010-0000-0000" autofocus>
	            </div>
	
	
	            <h5>이메일</h5>
	            <div class="email_box1">
	                ${ cus[0].email }
	            </div>
	
	            <div class="email_box2">
	                <input type="email" name="email" placeholder="ex) abc@abc.com">
	            </div>
	
	
	            <h5>주소</h5>
	            <div class="addr_box1">
	                ${ cus[0].addr }
	            </div>
	
	            <div class="addr_box2">
	                <input type="text" name="addr" value="">
	            </div>
	
	            
	            <h5>비밀번호</h5>
	            <div class="pwd_box2">
	                <input type="password" name="pwd" value="">
	            </div>
	            
	
	            <div>
	                <input type="button" value="수정하기" class="btn_modify" onclick="send(this.form);">
	                <input type="button" value="돌아가기" class="btn_cancel" onclick="location.href='myPage.do'">
	            </div>
	        </div>
	
	    </div>
	</form>
	</body>

</html>