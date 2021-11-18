<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여기는 테스트 리스트입니다</title>
    <link rel="stylesheet" href="/jung/resources/css/list.css">
    
   <!--  <script>
			function send(f) {
			
			var surname = f.rev_name1.value;
			var name = f.rev_name2.value;
			/* var phoneno = f.rev_phone1.value; */
			var checkin = f.rev_date.value;
			var checkout = f.rev_date1.value;
						
			if (name == "") {
			alert("이름을 입력해주세요");
			return;
			}
	
			if (surname == "") {
			alert("성을 입력해주세요");
			return;
			}
	
			/* if (phoneno == "") {
			alert("전화번호를 입력해주세요");
			return;
			} */
	
			/* var phoneno_pattern = /^\d{3}-\d{3,4}-\d{4}$/;
			if (!phoneno_pattern.test(phoneno)) {
			alert("올바른 형식으로 입력해주세요");
			return;
			} */
	
	
			f.action = "reserv.do";
			f.method = "POST";
			f.submit();
			}
		</script> -->
    
</head>
<body>
<form>    
		<div class="rev_name">
			<div class="rev_name1">
				<p>성</p>
				<input type="text" name="name" id="rev_name1" placeholder="내용을 입력해주세요">
			</div>
			
			<div class="rev_name2">
				<p>이름</p>
				<input type="text" name="name" id="rev_name2" placeholder="내용을 입력해주세요">
			</div>
		</div>
		
		<div class="rev_email">
			<p>이메일</p>
			<div id="rev_email1">
				<input type="text" id="rev_email" placeholder="내용을 입력해주세요">
			</div>
		</div>
		
		<div class="rev_phone">
			<p>연락처</p>
			<div class="rev_phone_row">
				<input type="text" id="rev_phone" placeholder="내용을 입력해주세요" maxlength="11">
			</div>
		</div>
										
		<div class="rev_acc">
			<p>숙소명</p>
			<div class="rev_acc_row">
				<input type="text" id="rev_acc" placeholder="내용을 입력해주세요" maxlength="100">
			</div>
		</div>
										
		<div class="rev_addr">
			<p>숙소주소</p>
			<div class="rev_addr_row">
				<input type="text" id="rev_addr" placeholder="내용을 입력해주세요" maxlength="100">
			</div>
		</div>
		
		<div class="rev_date">
			<div class="rev_checkin">
				<p>체크인</p>
				<input type="date" name="name" id="rev_date">
			</div>
			<div class="rev_checkout">
				<p>체크아웃</p>
				<input type="date" name="name" id="rev_date1">
			</div>
		</div>
			
        <div>
          	<input type="button" value="회원가입" onclick="send(this.form)">
  		</div>
</form>                   
</body>
</html>