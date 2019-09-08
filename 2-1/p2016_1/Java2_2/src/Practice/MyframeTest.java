package Practice;

import java.awt.*;

import javax.swing.*;

class MyFrame extends JFrame
{
	public MyFrame() //Jframe 을 상속하여서 MyFrame을 정의
	{
		JButton button = new JButton("버튼"); //버튼을 생성
		this.add(button); //컨테이너에 버튼을 추가
		
		setSize(300, 200); //JFrame을 이용해 컨테이너를 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		
		setLayout(new FlowLayout()); //배치관리자 설정
		
		setVisible(true);
	}
}
public class MyframeTest {
	public static void main(String args[]){
		MyFrame f = new MyFrame();
	}

}
