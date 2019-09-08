<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인정보 활용 동의서j</title>
<script src="JQueryMobile/jquery.js"></script>
<script src="JQueryMobile/jquery.mobile-1.4.5.js"></script>
<link rel="stylesheet" href="JQueryMobile/jquery.mobile-1.4.5.css" />

<script type="text/javascript">
$(document).ready(function() 
		{ 
		    $("input:radio[id=agreeable]").click(function() 
		    { 
		    	$("#data_name").textinput('enable');
		    	$("#data_birth").textinput('enable');
		    	$("#data_phone").textinput('enable');
		    }); 
		    
		    $("input:radio[id=disagreeable]").click(function() 
			{ 
		    	$("#data_name").textinput('disable');
		    	$("#data_birth").textinput('disable');
		    	$("#data_phone").textinput('disable');

			});
	
		});


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


<div id="content">
<p>
본인은 한림대학교  공과대학 SW캠프에 참석하기 위해 융합소프트웨어학과에 개인정보 공유를 동의합니다.
</p>

<form name="form" id="form" method="get" action="ResultJ.jsp" onsubmit="nowtime();">

<fieldset data-role="controlgroup">

     	<input type="radio" name="radio" id="agreeable" class="agreeable" value="agree" />
     	<label for="agreeable">동의</label>

     	<input type="radio" name="radio" id="disagreeable" class="disagreeable" value="disagree" />
     	<label for="disagreeable">동의안함</label>

</fieldset>

		<input type="text" name="data_name" id="data_name" placeholder="이름" disabled="disabled"/>

		<input type="text" name="data_birth" id="data_birth" placeholder="생년월일 ex) 19010101" disabled="disabled"/>

		<input type="text" name="data_phone" id="data_phone" placeholder="휴대폰 번호" disabled="disabled"/>

		<input type="text" name="time" id="time" style=" display: none" data-role = "none"/>

		<input type="submit" name="submit_test" value="확인"/>
</form>
</div>

<div data-role="footer" data-position="fixed" data-position="inline">
     <p>Copyright (C) HALLYM University</p>
      </div>

</body>
</html>