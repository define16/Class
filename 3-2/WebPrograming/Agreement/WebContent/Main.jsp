<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인정보 활용 동의서</title>
  <link rel="stylesheet" type="text/css" href="moblie.css"/>


<script></script>
<script type="text/javascript">
function checkAble(frm){
	   if(frm.agreeable.checked==true){
	      frm.disagreeable.checked=false;
	      frm.data_name.disabled=false;
	      frm.data_birth.disabled=false;
	      frm.data_phone.disabled=false;
	      frm.submit_test.disabled=false;
	   }
	   else {
	      frm.data_name.disabled=true;
	      frm.data_birth.disabled=true;
	      frm.data_phone.disabled=true;
	      frm.submit_test.disabled=true;
	   }
	    }
	    
	  function checkDisable(frm){
	   if(frm.disagreeable.checked==true){
	      frm.agreeable.checked=false;
	      frm.data_name.disabled=true;
	      frm.data_birth.disabled=true;
	      frm.data_phone.disabled=true;
	      frm.submit_test.disabled=false;
	   }
	   else {
	      frm.data_name.disabled=true;
	      frm.data_birth.disabled=true;
	      frm.data_phone.disabled=true;
	      frm.submit_test.disabled=true;
	   }

	  }
    
    function nowtime() {
    	var meg;
        var today = new Date();
        
        var year = today.getFullYear();
        var month = today.getMonth()+1;
        var day = today.getDate();

        
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();

     	h=dasi(h);
     	m=dasi(m);
    	s=dasi(s);

    	document.getElementById('time').value = year + "-" + month + "-" + day + " " + h + " : " + m + " : " + s;
    	var t = setTimeout(function(){nowtime()},1000000);
    }

    function dasi(i) {
    	if(i<10) {
    		i= "0" + i;
    		
    	}
    return i;
    }

</script>
</head>

<body>


<header data-role="header">
	<h1>개인정보 활용 동의서</h1>
</header>



<p>
본인은 한림대학교  공과대학 SW캠프에 참석하기 위해 융합소프트웨어학과에 개인정보 공유를 동의합니다.
</p>

<form name="form"  method="post" action="Result.jsp" onsubmit="nowtime()">
<center>
<table>
<tr>
	<td>
		<input type="checkbox" name="agreeable" onclick="checkAble(this.form)" value="1">
		<label>동의</label>
	</td>
	<td>
		<input type="checkbox" name="disagreeable" onclick="checkDisable(this.form)" value="1" >
		<label>동의하지않음</label>
	</td>
</tr>
<tr>
	<td colspan="2">
	<input type="text" name="data_name" placeholder="이름" disabled>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="text" name="data_birth" placeholder="생년월일 ex) 19010101" disabled>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="text" name="data_phone" placeholder="휴대폰 번호" disabled>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="text" name="time" id="time" style=" display: none" >
	</td>
<tr>
	<td colspan="2">
		<input type="submit" name="submit_test" value="확인" disabled >
	</td>
</tr>
</table>
</center>
</form>





</body>
</html>