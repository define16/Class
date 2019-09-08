package excersie;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

class CardSample extends JFrame {
	/***************** 변경된 부분 **********************/
	// CardLayout 생성
	private CardLayout cardLayout = new CardLayout();
	/**********************************************/

	// Panel 생성
	private JPanel redPan = new JPanel();
	private JPanel bluePan = new JPanel();
	private JPanel greenPan = new JPanel();
	private JPanel yellowPan = new JPanel();
	private JPanel grayPan = new JPanel();

	public CardSample() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 300, 500);
		this.setTitle("CardLayout : yellowPan");

		// Panel 배경색 지정
		redPan.setBackground(Color.RED);
		bluePan.setBackground(Color.BLUE);
		greenPan.setBackground(Color.GREEN);
		yellowPan.setBackground(Color.YELLOW);
		grayPan.setBackground(Color.GRAY);

		/***************** 변경된 부분 **********************/
		// Layout 설정
		this.setLayout(cardLayout);

		this.add("redPan", redPan);
		this.add("bluePan", bluePan);
		this.add("greenPan", greenPan);
		this.add("yellowPan", yellowPan);
		this.add("grayPan", grayPan);

		// 보여질 판 선택
		cardLayout.show(getContentPane(), "yellowPan");
		/**********************************************/

		this.setVisible(true);
	}
}
