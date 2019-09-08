package exr3;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class UI extends JFrame implements ActionListener, MouseListener{
	
	public JTextField f1;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
//////////////////////////////////////////// 라벨
	private JLabel titleLabel;
	private JLabel currentLabel;
	private JLabel current;
	private JLabel updown;
	private JLabel udflag;
	private JLabel percent;
	private JLabel deallyangLabel;
	private JLabel deallyang;
	private JLabel dealmoneyLabel;
	private JLabel dealmoney;
	private JLabel yesterdayLabel;
	private JLabel yesterday;
	private JLabel highLabel;
	private JLabel high;
	private JLabel lowLabel;
	private JLabel low;
	private JLabel cigaLabel;
	private JLabel ciga;
	private JLabel upmoneyLabel;
	private JLabel upmoney;
	private JLabel downmoneyLabel;
	private JLabel downmoney;
	private JLabel imgLabel;
	private JLabel timeLabel;
	////////////////////////////////////////////
	private ImageIcon imgv = null;
	private String imgs = null;
	private String str3 = null;
	
	
	public UI() {
		super("주식");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(500, 100, 585, 500);
		
		f1 = new JTextField();
		b1 = new JButton("검색");
		b2 = new JButton("새로고침");
		b3 = new JButton("채팅");
		b4 = new JButton("목록");
		f1.setText("회사를 입력하세요.");
		
		titleLabel = new JLabel("");
		currentLabel = new JLabel("현재가");
		current = new JLabel("");
		updown = new JLabel("");
		udflag = new JLabel("");
		percent = new JLabel("");
		deallyangLabel = new JLabel("거래량");
		deallyang = new JLabel("");
		dealmoneyLabel = new JLabel("거래대금");
		dealmoney = new JLabel("");
		yesterdayLabel = new JLabel("전일");
		yesterday = new JLabel("");
		highLabel = new JLabel("고가");
		high = new JLabel("");
		lowLabel = new JLabel("저가");
		low = new JLabel("");
		cigaLabel = new JLabel("시가");
		ciga = new JLabel("");
		upmoneyLabel = new JLabel("상한가");
		upmoney = new JLabel("");
		downmoneyLabel = new JLabel("하한가");
		downmoney = new JLabel("");
		timeLabel = new JLabel("");
		
		titleLabel.setFont(new Font(null, Font.BOLD, 20));
		timeLabel.setForeground(new Color(120, 120, 120));
		
		imgv = new ImageIcon();
		imgLabel = new JLabel();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f1.addMouseListener(this);
		f1.addActionListener(this);
		
		f1.setBounds(80, 20, 155, 30);
		b1.setBounds(250, 20, 90, 30);
		b2.setBounds(355, 20, 90, 30);
		b3.setBounds(460, 20, 90, 30);
		b4.setBounds(10,20,60,30);
		////////////////////////////////////////////
		titleLabel.setBounds(20, 60, 200, 30);
		currentLabel.setBounds(20, 100, 70, 30);
		current.setBounds(70, 100, 70, 30);
		updown.setBounds(150, 100, 60, 30);
		udflag.setBounds(130, 100, 30, 30);
		percent.setBounds(210, 100, 60, 30);
		deallyangLabel.setBounds(290, 100, 60, 30);
		deallyang.setBounds(340, 100, 60, 30);
		dealmoneyLabel.setBounds(420, 100, 60, 30);
		dealmoney.setBounds(480, 100, 100, 30);
		yesterdayLabel.setBounds(20, 140, 60, 30);
		yesterday.setBounds(60, 140, 80, 30);
		highLabel.setBounds(140, 140, 60, 30);
		high.setBounds(180, 140, 100, 30);
		lowLabel.setBounds(280, 140, 60, 30);
		low.setBounds(320, 140, 100, 30);
		cigaLabel.setBounds(420, 140, 60, 30);
		ciga.setBounds(460, 140, 100, 30);
		upmoneyLabel.setBounds(20, 180, 60, 30);
		upmoney.setBounds(70, 180, 60, 30);
		downmoneyLabel.setBounds(160, 180, 60, 30);
		downmoney.setBounds(210, 180, 60, 30);
		imgLabel.setBounds(20, 190, 300, 300);
		timeLabel.setBounds(330, 400, 200, 30);
		////////////////////////////////////////////
		////////////////////////////////////////////
		currentLabel.setVisible(false);
		deallyangLabel.setVisible(false);
		dealmoneyLabel.setVisible(false);
		yesterdayLabel.setVisible(false);
		highLabel.setVisible(false);
		lowLabel.setVisible(false);
		cigaLabel.setVisible(false);
		upmoneyLabel.setVisible(false);
		downmoneyLabel.setVisible(false);
		////////////////////////////////////////////
		add(f1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		////////////////////////////////////////////
		add(titleLabel);
		add(currentLabel);
		add(current);
		add(updown);
		add(percent);
		add(deallyangLabel);
		add(deallyang);
		add(dealmoneyLabel);
		add(dealmoney);
		add(yesterdayLabel);
		add(yesterday);
		add(highLabel);
		add(high);
		add(lowLabel);
		add(low);
		add(cigaLabel);
		add(ciga);
		add(upmoneyLabel);
		add(upmoney);
		add(downmoneyLabel);
		add(downmoney);
		add(imgLabel);
		add(udflag);
		add(timeLabel);
		////////////////////////////////////////////
		setVisible(true);
	}
	String codenumber(String str){
		if(str.equals("카카오") || str.equals("다음")){ return "035720"; }
		else if(str.equals("삼성전자")){ return "005930";}
		else if(str.equals("SK하이닉스")){ return "000660";}
		else if(str.equals("현대차")){ return "005380";}
		else if(str.equals("한국전력")){ return "015760";}
		else if(str.equals("NAVER")||str.equals("네이버")){ return "035420";}
		else if(str.equals("현대모비스")){ return "012330";}
		else if(str.equals("삼성물산")){ return "028260";}
		else if(str.equals("삼성생명")){ return "032830";}
		else if(str.equals("POSCO")||str.equals("포스코")){ return "005490";}
		else if(str.equals("기아차")){ return "000270";}
		else if(str.equals("LG")){ return "003550";}
		else if(str.equals("삼성화재")){ return "000810";}
		else if(str.equals("우리은행")){ return "000030";}
		else if(str.equals("현대건설")){ return "000720";}
		else if(str.equals("CJ대한통운")){ return "000120";}
		else if(str.equals("한화")){ return "000880";}
		else if(str.equals("두산")){ return "000150";}
		else if(str.equals("하이트진로")){ return "000080";}
		else if(str.equals("KB금융")){ return "105560";}
		else if(str.equals("한국타이어")){ return "161390";}
		else if(str.equals("이마트")){ return "139480";}
		else if(str.equals("CJ E&M")){ return "130960";}
		else if(str.equals("신세계")){ return "004170";}
		else if(str.equals("농심")){ return "004370";}
		else if(str.equals("엔씨소프트")||str.equals("NCSOFT")){ return "036570";}
		else if(str.equals("오뚜기")){ return "007310";}
		
		return "";
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (b1 == o || f1 == o) { // 버튼을 누르면 혹은 엔터치면
			String str = f1.getText();
			String str2 = codenumber(str);
			str3=str2;
			Parser p = new Parser();
			p.keyword = str2;
			
			p.goodSearch();
			
			currentLabel.setVisible(true);
			deallyangLabel.setVisible(true);
			dealmoneyLabel.setVisible(true);
			yesterdayLabel.setVisible(true);
			highLabel.setVisible(true);
			lowLabel.setVisible(true);
			cigaLabel.setVisible(true);
			upmoneyLabel.setVisible(true);
			downmoneyLabel.setVisible(true);
			
			byte[] image = URLManager.getImage(
					p.im,
		            "http://finance.daum.net/item/main.daum?code=035420");
			
			if(p.currentr.get(5).text().contains("-")) {
				titleLabel.setForeground(new Color(0,0,255));
				current.setForeground(new Color(0,0,255));
				updown.setForeground(new Color(0,0,255));
				percent.setForeground(new Color(0,0,255));
				udflag.setForeground(new Color(0,0,255));
				udflag.setText("▼");
			}
			else if(p.currentr.get(5).text().contains("+")) {
				titleLabel.setForeground(new Color(255,0,0));
				current.setForeground(new Color(255,0,0));
				updown.setForeground(new Color(255,0,0));
				percent.setForeground(new Color(255,0,0));
				udflag.setForeground(new Color(255,0,0));
				udflag.setText("▲");
			}
			
			titleLabel.setText(p.root2.get(0).text());
			current.setText(p.currentr.get(3).text());
			updown.setText(p.currentr.get(4).text());
			percent.setText(p.currentr.get(5).text());
			deallyang.setText(p.dealr.get(0).text());
			dealmoney.setText(p.dealr.get(1).text() + " 백만원");
			yesterday.setText(p.price2.get(0).text());
			
			if(p.price2.get(1).text().contains("-"))
				high.setForeground(new Color(0,0,255));
			else if(p.price2.get(1).text().contains("+"))
				high.setForeground(new Color(255,0,0));
			
			if(p.price2.get(4).text().contains("-"))
				low.setForeground(new Color(0,0,255));
			else if(p.price2.get(4).text().contains("+"))
				low.setForeground(new Color(255,0,0));
			
			if(p.price2.get(3).text().contains("-"))
				ciga.setForeground(new Color(0,0,255));
			else if(p.price2.get(3).text().contains("+"))
				ciga.setForeground(new Color(255,0,0));
			
			high.setText(p.price2.get(1).text().substring(1, p.price2.get(1).text().length()));
			low.setText(p.price2.get(4).text().substring(1, p.price2.get(4).text().length()));
			ciga.setText(p.price2.get(3).text().substring(1, p.price2.get(3).text().length()));
			
			upmoney.setText(p.price.get(1).text());
			downmoney.setText(p.price.get(2).text());
			imgv = new ImageIcon(image);
			imgLabel.setIcon(imgv);
			timeLabel.setText(getTime());
		}
		if (b2 == o){
			Parser p = new Parser();
			p.keyword = str3;
			
			p.goodSearch();
			
			currentLabel.setVisible(true);
			deallyangLabel.setVisible(true);
			dealmoneyLabel.setVisible(true);
			yesterdayLabel.setVisible(true);
			highLabel.setVisible(true);
			lowLabel.setVisible(true);
			cigaLabel.setVisible(true);
			upmoneyLabel.setVisible(true);
			downmoneyLabel.setVisible(true);
			
			byte[] image = URLManager.getImage(
					p.im,
		            "http://finance.daum.net/item/main.daum?code=035420");
			
			if(p.currentr.get(5).text().contains("-")) {
				titleLabel.setForeground(new Color(0,0,255));
				current.setForeground(new Color(0,0,255));
				updown.setForeground(new Color(0,0,255));
				percent.setForeground(new Color(0,0,255));
				udflag.setForeground(new Color(0,0,255));
				udflag.setText("▼");
			}
			else if(p.currentr.get(5).text().contains("+")) {
				titleLabel.setForeground(new Color(255,0,0));
				current.setForeground(new Color(255,0,0));
				updown.setForeground(new Color(255,0,0));
				percent.setForeground(new Color(255,0,0));
				udflag.setForeground(new Color(255,0,0));
				udflag.setText("▲");
			}
			
			titleLabel.setText(p.root2.get(0).text());
			current.setText(p.currentr.get(3).text());
			updown.setText(p.currentr.get(4).text());
			percent.setText(p.currentr.get(5).text());
			deallyang.setText(p.dealr.get(0).text());
			dealmoney.setText(p.dealr.get(1).text() + " 백만원");
			yesterday.setText(p.price2.get(0).text());
			
			if(p.price2.get(1).text().contains("-"))
				high.setForeground(new Color(0,0,255));
			else if(p.price2.get(1).text().contains("+"))
				high.setForeground(new Color(255,0,0));
			
			if(p.price2.get(4).text().contains("-"))
				low.setForeground(new Color(0,0,255));
			else if(p.price2.get(4).text().contains("+"))
				low.setForeground(new Color(255,0,0));
			
			if(p.price2.get(3).text().contains("-"))
				ciga.setForeground(new Color(0,0,255));
			else if(p.price2.get(3).text().contains("+"))
				ciga.setForeground(new Color(255,0,0));
			
			high.setText(p.price2.get(1).text().substring(1, p.price2.get(1).text().length()));
			low.setText(p.price2.get(4).text().substring(1, p.price2.get(4).text().length()));
			ciga.setText(p.price2.get(3).text().substring(1, p.price2.get(3).text().length()));
			
			upmoney.setText(p.price.get(1).text());
			downmoney.setText(p.price.get(2).text());
			imgv = new ImageIcon(image);
			imgLabel.setIcon(imgv);
			timeLabel.setText(getTime());
		}
		if(b3==o){
			Socket socket=null;
			ClientFrame cf;
			try{
				socket=new Socket("220.66.151.231",3000);
				System.out.println("연결성공!");
				cf = new ClientFrame(socket);
				new ReadThread(socket, cf).start();
			}catch(IOException ie){
				System.out.println(ie.getMessage());
			}
			
		}
		if(b4==o){
			List li = new List();
			
		}
		
	}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy - MM - dd  hh:mm부");
		return f.format(new Date());
	}
	public void mouseClicked(MouseEvent e){ f1.setText(""); }
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
class List extends JFrame implements MouseListener{
	private JList list;
	private String clist[] ={"CJ E&M","CJ대한통운","KB금융","LG","NAVER","NCSOFT","POSCO","SK하이닉스",
			"기아차","네이버","농심","다음","두산","삼성물산","삼성생명","삼성전자","신세계","엔씨소프트","오뚜기",
			"우리은행","이마트","카카오","포스코","하이트진로","한국전력","한국타이어","한화","현대건설","현대모비스","현대차"};
	public String cstr =null;
	Main m;
	public List(){
		super("목록");
		
		list = new JList(clist);
		JScrollPane scrollPane = new JScrollPane(list);
		Container ct = this.getContentPane();
		
		list.addMouseListener(this);
		//ct.add(list);
		ct.add(scrollPane);
		setBounds(230, 100, 280, 505);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e){
		if( e.getClickCount()==2){
			int index = list.locationToIndex(e.getPoint());
			
			cstr = clist[index];
			//System.out.println(index);
			
		//	System.out.println(cstr);
			m.u.f1.setText(cstr);
			m.u.f1.requestFocus();
			
			this.setVisible(false);
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
class Id extends JFrame implements ActionListener{
	static JTextField tf=new JTextField(8);
	JButton btn = new JButton("입력");	
	
	WriteThread wt;	
	ClientFrame cf;
	public Id(){}
	public Id(WriteThread wt, ClientFrame cf) {
		super("아이디");		
		this.wt = wt;
		this.cf = cf;
		
		
		setLayout(new FlowLayout());
		add(new JLabel("아이디"));
		add(tf);
		add(btn);
		
		btn.addActionListener(this);
		
		setBounds(1075, 100, 330, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {	
		wt.sendMsg();	
		cf.isFirst = false;
		cf.setVisible(true);
		this.dispose();
	}
	public static String getId(){
		return tf.getText();
	}
}




class ClientFrame extends JFrame implements ActionListener{
	JTextArea txtA = new JTextArea();
	JTextField txtF = new JTextField(15);
	JButton btnTransfer = new JButton("전송");
	JButton btnExit = new JButton("닫기");
	boolean isFirst=true;
	JPanel p1 = new JPanel();
	Socket socket;
	WriteThread wt;
	
	public ClientFrame(Socket socket) {
		super("주식  채팅");
		this.socket = socket;
		wt = new WriteThread(this);
		new Id(wt, this);
	
		add("Center", txtA);
		txtA.setEditable(false);
		p1.add(txtF);
		p1.add(btnTransfer);
		p1.add(btnExit);
		add("South", p1);
		
		//메세지를 전송하는 클래스 생성.
		
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		txtF.addActionListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1075, 100, 330, 505);
		setVisible(false);	
	}
	
	public void actionPerformed(ActionEvent e){
		String id = Id.getId();
		Object o = e.getSource();
		if(btnTransfer ==o || txtF ==o ){//전송버튼 눌렀을 경우
			//메세지 입력없이 전송버튼만 눌렀을 경우
			if(txtF.getText().equals("")){
				return;
			}			
			txtA.append("["+id+"] "+ txtF.getText()+"\n");
			wt.sendMsg();
			txtF.setText("");
		}else{
			
			this.dispose();
		}
	}

}

class WriteThread{
	Socket socket;
	ClientFrame cf;
	String str;
	String id;
	public WriteThread(ClientFrame cf) {
		this.cf  = cf;
		this.socket= cf.socket;
	}
	public void sendMsg() {
		//키보드로부터 읽어오기 위한 스트림객체 생성
		BufferedReader br=
		new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=null;
		try{
			//서버로 문자열 전송하기 위한 스트림객체 생성
			pw=new PrintWriter(socket.getOutputStream(),true);
			//첫번째 데이터는 id 이다. 상대방에게 id와 함께 내 IP를 전송한다.
			if(cf.isFirst==true){
				InetAddress iaddr=socket.getLocalAddress();				
				String ip = iaddr.getHostAddress();				
				getId();
				System.out.println("ip:"+ip+"id:"+id);
				str = "["+id+"] 님 로그인 ("+ip+")"; 
			}else{
				str= "["+id+"] "+cf.txtF.getText();
			}
			//입력받은 문자열 서버로 보내기
			pw.println(str);
		
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}finally{
			try{
				if(br!=null) br.close();
				//if(pw!=null) pw.close();
				//if(socket!=null) socket.close();
			}catch(IOException ie){
				System.out.println(ie.getMessage());
			}
		}
	}	
	public void getId(){		
		id = Id.getId(); 
	}
}
//서버가 보내온 문자열을 전송받는 스레드
class ReadThread extends Thread{
	Socket socket;
	ClientFrame cf;
	public ReadThread(Socket socket, ClientFrame cf) {
		this.cf = cf;
		this.socket=socket;
	}
	
	public void run() {
		BufferedReader br=null;
		try{
			//서버로부터 전송된 문자열 읽어오기 위한 스트림객체 생성
			br=new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			while(true){
				//소켓으로부터 문자열 읽어옴
				String str=br.readLine();
				if(str==null){
					System.out.println("접속이 끊겼음");
					break;
				}
				//전송받은 문자열 화면에 출력
				//System.out.println("[server] " + str);
				cf.txtA.append(str+"\n");
			}
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}finally{
			try{
				if(br!=null) br.close();
				if(socket!=null) socket.close();
			}catch(IOException ie){}
		}
	}
}
