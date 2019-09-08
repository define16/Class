<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
<%@ page import="java.io.*" %>
<jsp:useBean id="IP" class="beans.IPadress" scope="page"/>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	String agreeable = request.getParameter("agreeable");
	String disagreeable =  request.getParameter("disagreeable");
	String name = request.getParameter("data_name");	//이름
	String birthday =request.getParameter("data_birth");	//생년월일 ex)19010101
	String number =  request.getParameter("data_phone");	//휴대폰 번호
	String IPAdress = IP.getIPAdress();
	String time =  request.getParameter("time");
	
	boolean flag = true;

	
	if(agreeable != null){
		if(name == ""){
			out.println("<script>alert('이름을 입력해주세요.'); </script>");
			flag = false;
		}
		else if(birthday.equals(null) || birthday.length() != 8){
			out.println("<script>alert('생년월일을 정확히 입력해주세요.');</script>");
			flag = false;
		}
		else if(!birthday.substring (0,2).equals("19")  && !birthday.substring (0,2).equals("20")) {
			out.println("<script>alert('연도을 정확히 입력해주세요.');</script>");
			flag = false;
		}
		else if(!birthday.substring (4,5).equals("0")  && !birthday.substring (4,5).equals("1")) {
			out.println("<script>alert('12월을 초과합니다.');</script>");
			flag = false;
		}
		else if(!birthday.substring (6,7).equals("0")  && !birthday.substring (6,7).equals("1") && !birthday.substring (6,7).equals("2") && !birthday.substring (6,7).equals("3")) {
			out.println("<script>alert('31일을 초과합니다.');</script>");
			flag = false;
		}
		else if(number.equals(null) || number.length() != 11){
			out.println("<script>alert('휴대폰번호를 정확히 입력해주세요.');</script>");
			flag = false;
		}
		else if(!number.substring (0,2).equals("01")) {
			out.println("<script>alert('휴대폰번호를 정확히 입력해주세요.');</script>");
			flag = false;
		}
		else {
			if(birthday.substring (4,5).equals("1") && !birthday.substring (5,6).equals("0") && !birthday.substring (5,6).equals("1") && !birthday.substring (5,6).equals("2")) {
				out.println("<script>alert('12월을 초과합니다.');</script>");
				flag = false;
			}
			else if(birthday.substring (4,5).equals("0") && birthday.substring (5,6).equals("0")) {
				out.println("<script>alert('00월을 사용할 수 없습니다.');</script>");
				flag = false;
			}
			else if(birthday.substring (6,7).equals("3") && !birthday.substring (7,8).equals("0") && !birthday.substring (7,8).equals("1")) {
				out.println("<script>alert('31일을 초과합니다.');</script>");
				flag = false;
			}
			else if(birthday.substring (6,7).equals("0") && birthday.substring (7,8).equals("0")) {
				out.println("<script>alert('00일을 사용할 수 없습니다.');</script>");
				flag = false;
			}
			else if(!birthday.substring (0,4).equals("1988") && !birthday.substring (0,4).equals("1992") && !birthday.substring (0,4).equals("1996") &&
					!birthday.substring (0,4).equals("2000") && birthday.substring (4,6).equals("02")) {
				if(birthday.substring (6,8).equals("29") || birthday.substring (6,7).equals("3")) {
					out.println("<script>alert('28일을 초과했습니다.');</script>");
					flag = false;
				}
			}
			else if(birthday.substring (0,4).equals("1988") || birthday.substring (0,4).equals("1992") || birthday.substring (0,4).equals("1996") ||
					birthday.substring (0,4).equals("2000") ) {
				if(birthday.substring (4,6).equals("02") && !birthday.substring (6,7).equals("0") && !birthday.substring (6,7).equals("1") && !birthday.substring (6,7).equals("2")) {
					out.println("<script>alert('29일을 초과했습니다.');</script>");
					flag = false;
						
				}
			}
			else if(birthday.substring (4,6).equals("04") || birthday.substring (4,6).equals("06") || birthday.substring (4,6).equals("09") || birthday.substring (4,6).equals("11")) {
				if(birthday.substring (6,7).equals("3") && !birthday.substring (7,8).equals("0")){
					out.println("<script>alert('30일을 초과했습니다.');</script>");
					flag = false;
				}
			}
	}

%>

<h2> 학생 정보 입력 결과</h2>
동의 : <%= agreeable%><p>
비동의 : <%= disagreeable%><p>
성명 : <%= name%><p>
생년월일 : <%= birthday%><p>
휴대폰 번호 : <%= number%><p>
IP : <%= IPAdress %><p>
시간 : <%= time %><p>


<%
if(flag){
	try {
	   File sFile = new File("D://Programing Folder/Web/University/Agreement/WebContent/test.txt");
	   sFile.createNewFile();
	   BufferedWriter fw = new BufferedWriter(new FileWriter("D://Programing Folder/Web/University/Agreement/WebContent/test.txt",true));
	   fw.write(agreeable+" "+disagreeable+" "+name+" "+birthday+" "+number+" "+IPAdress+" "+ time);
	   fw.newLine();
	   fw.close();
	}catch(Exception e){
	   e.printStackTrace();
	}
}
%>


<script>
	var flag = <%= flag %>
	if(!flag){
		window.location = "Main.jsp";
	}else {
		alert('완료되었습니다.')
			window.open('about:blank', '_self'); window.close();
			history.pushState(null, null, 'about:blank');
			window.onpopstate = function(event) {
				history.go(1);
		}
</script>
</body>
</html>