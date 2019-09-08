import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SliderChangeEx extends JFrame {
	Container contentPane;	
	JLabel colorLabel;
	JSlider [] sl = new JSlider [3]; // 3개의 슬라이더 배열 생성
	SliderChangeEx() {
		setTitle("슬라이더와 ChangeEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());		

		colorLabel = new JLabel("        SLIDER EXAMPLE        ");
		

		// 슬라이더를 3 개 생성하고 모양을 제어한다.



		....

		
		contentPane.add(colorLabel);		
		setSize(300,230);
		setVisible(true);
	}

	// Change 리스너 구현
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) { //슬라이더 컴포넌트의 값이 변경되면 호출됨

			...

		}
	}
	public static void main(String [] args) {
		new SliderChangeEx();
	}
} 




