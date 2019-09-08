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
		super("나홀로");
		setSize(490, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 100);
		setLayout(null);

		homebt1 = new JButton("처음으로");
		homebt1.setBounds(162, 0, 160, 30);
		homebt1.addActionListener(this);
		add(homebt1); // 첫 번째 프레임으로 돌아가는 버튼입니다

		backbt1 = new JButton("뒤로");
		backbt1.setBounds(2, 0, 160, 30);
		backbt1.addActionListener(this);
		add(backbt1); // 2번째 프레임에서 2번째 패널로 가는 버튼입니다

		internetbt1 = new JButton("춘천관광넷");
		internetbt1.setBounds(322, 0, 160, 30);
		internetbt1.addActionListener(this);
		add(internetbt1); // 하이퍼링크를 이용해 "춘천관광넷"으로 가는 버튼입니다

		alonetabbedPane = new JTabbedPane();
		alonetabbedPane.setBounds(0, 30, 485, 432);
		populateTabbedPane(); // 탭기능을 이용하기 위해서 선언입니다
		getContentPane().add(alonetabbedPane);

		setResizable(false);
		setVisible(true);
	}

	// "“나만의 여행”,“친구들과 여행”,“연인과 여행”,“가족과 여행” 다 같은 소스이지만 여기 있는 내용들만 달라 집니다.
	private void populateTabbedPane() { // 탭 마다의 존재하는 패널들입니다
		alonetabbedPane.addTab("소양강댐", null, new Dam(), "춘천에서 가장 유명한");
		alonetabbedPane.addTab("김유정관", null, new YujeongKim(), "역사가 살아 숨쉬는");
		alonetabbedPane.addTab("애니메이션 박물관", null, new AnimationMuseum(), "동심의 세계로");
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
				Hyper.openUrl(Url); // 하이퍼링크기능입니다.
			}

		}
	}
}
