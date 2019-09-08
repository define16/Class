package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AloneFrame extends JFrame implements ActionListener {

	JButton homebt1, backbt1, internetbt1;
	JTabbedPane alonetabbedPane;

	public AloneFrame() {
		super("��Ȧ��");
		setSize(490, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 100);
		setLayout(null);

		homebt1 = new JButton("ó������");
		homebt1.setBounds(162, 0, 160, 30);
		homebt1.addActionListener(this);
		add(homebt1); // ù ��° ���������� ���ư��� ��ư�Դϴ�

		backbt1 = new JButton("�ڷ�");
		backbt1.setBounds(2, 0, 160, 30);
		backbt1.addActionListener(this);
		add(backbt1); // 2��° �����ӿ��� 2��° �гη� ���� ��ư�Դϴ�

		internetbt1 = new JButton("��õ������");
		internetbt1.setBounds(322, 0, 160, 30);
		internetbt1.addActionListener(this);
		add(internetbt1); // �����۸�ũ�� �̿��� "��õ������"���� ���� ��ư�Դϴ�

		alonetabbedPane = new JTabbedPane();
		alonetabbedPane.setBounds(0, 30, 485, 432);
		populateTabbedPane(); // �Ǳ���� �̿��ϱ� ���ؼ� �����Դϴ�
		getContentPane().add(alonetabbedPane);

		setResizable(false);
		setVisible(true);
	}

	// "�������� ���ࡱ,��ģ����� ���ࡱ,�����ΰ� ���ࡱ,�������� ���ࡱ �� ���� �ҽ������� ���� �ִ� ����鸸 �޶� ���ϴ�.
	private void populateTabbedPane() { // �� ������ �����ϴ� �гε��Դϴ�
		alonetabbedPane.addTab("�Ҿ簭��", null, new Dam(), "��õ���� ���� ������");
		alonetabbedPane.addTab("��������", null, new YujeongKim(), "���簡 ��� ������");
		alonetabbedPane.addTab("�ִϸ��̼� �ڹ���", null, new AnimationMuseum(), "������ �����");
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == homebt1) {
			setVisible(false);
			MainFrame mf = new MainFrame();
		}
		if (arg0.getSource() == backbt1) {
			setVisible(false);
			backWithwho bww = new backWithwho();

			if (arg0.getSource() == internetbt1) {
				String temp = "";
				try {
					temp = URLEncoder.encode(temp, "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String Url = "http://tour.chuncheon.go.kr/open_content/page/main.asp";
				Hyper.openUrl(Url); // �����۸�ũ����Դϴ�.
			}

		}
	}
}
