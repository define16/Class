package Practice;

import java.awt.*;

import javax.swing.*;

class MyFrame extends JFrame
{
	public MyFrame() //Jframe �� ����Ͽ��� MyFrame�� ����
	{
		JButton button = new JButton("��ư"); //��ư�� ����
		this.add(button); //�����̳ʿ� ��ư�� �߰�
		
		setSize(300, 200); //JFrame�� �̿��� �����̳ʸ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		
		setLayout(new FlowLayout()); //��ġ������ ����
		
		setVisible(true);
	}
}
public class MyframeTest {
	public static void main(String args[]){
		MyFrame f = new MyFrame();
	}

}
