<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ѱ� ���� ����</title>
</head>
<body>

<h2> �ѱ� ���� ������ ���� </h2><hr>

<%@ page import="org.apache.commons.mail.SimpleEmail" %>

<%
String charSet = "euc-kr";
String hostSMTP = "localhost";
//String hostSMTP = "smtp.gmail.com";
String hostSMTPid = "koesd1114@gmail.com";
//String hostSMTPid = "hskang7";
String hostSMTPpasswd = "Cho93!!26";
String toEmail = "koesd1114@gmail.com";
String toName = "�� ȯ��";
String fromEmail = "koesd1114@gmail.com";
String fromName = "�� ����";
String subject = "SimpleEmail Ŭ������ �̿��� ���� ������";
String msg = "������ �� ���� ������!!";

try {
	SimpleEmail email = new SimpleEmail();
	email.setDebug(true);  
	email.setCharset(charSet);  
	email.setHostName(hostSMTP);
	email.setAuthentication(hostSMTPid, hostSMTPpasswd);
	email.setTLS(true); 
	email.addTo(toEmail, toName, charSet);
	email.setFrom(fromEmail, fromName, charSet);
	email.setSubject(subject);
	email.setMsg(msg);
	email.send();
	
	out.println("���� ������ ����!!!");
} catch (Exception e) {
	out.println("���� ������ ����!!! <hr>");
	out.println(e.toString() + "<hr>");
}
%>

</body>
</html>