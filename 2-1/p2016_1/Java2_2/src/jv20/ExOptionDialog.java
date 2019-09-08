package jv20;

import java.awt.*;
import java.awt.event.*;
  
public class ExOptionDialog extends Frame{
    Panel panelSizeOption;
        // 사이즈 옵션 패널
    Panel panelNameOption;
        // 이름 옵션 패널

    Panel panelButtons;
        // 버튼 패널
    Panel panelButtonBar;
        // 버튼 패널을 담을 패널

    public ExOptionDialog(String title){
        super(title);
        // 레이아웃 매니저를 사용하지 않는다.
        setLayout(null);
        setResizable(false);
        
        /* 사이즈 옵션 패널을 만들고 GridLayout으로 설정한다. */
        panelSizeOption = new Panel(new GridLayout(0, 1));        
        
        // 옵션 레이블을 단다.
        panelSizeOption.add(new Label("그룹의 크기"));
        
        // 옵션을 나타내는 체크박스들을 추가한다.
        CheckboxGroup cg = new CheckboxGroup();
        panelSizeOption.add(new Checkbox("one", cg, false));
        panelSizeOption.add(new Checkbox("two", cg, false));
        panelSizeOption.add(new Checkbox("three", cg, false));

        /* 사이즈 옵션 패널의 크기와 위치를 정해서 프레임에 추가한다. */
        panelSizeOption.setBounds(25, 45, 105, 100);            
        add(panelSizeOption);
        
        /* 이름 옵션 패널을 만들고 GridLayout으로 설정한다. */
        panelNameOption = new Panel(new GridLayout(0, 1));
        
        // 옵션 레이블을 단다.
        panelNameOption.add(new Label("그룹 이름"));
        panelNameOption.add(new TextField());

        /* 이름 옵션 패널의 크기와 위치를 정해서 프레임에 추가한다. */
        panelNameOption.setBounds(145, 45, 100, 45);            
        add(panelNameOption);


        /* 버튼바를 만들어 FlowLayout으로 설정해 둔다. */
        panelButtonBar = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelButtonBar.setBackground(Color.lightGray);

        /* 예 아니오 버튼을 버튼 패널에 추가시킨다. */
        panelButtons = new Panel(new GridLayout(1, 2, 15, 5));
        
        panelButtons.add(new Button("예"));
        panelButtons.add(new Button("아니오"));

        /* 버튼바와 버튼 패널을 각각 상위 컨테이너에 추가한다 */
        panelButtonBar.add(panelButtons);
        add(panelButtonBar);
        
        panelButtonBar.setBounds(5, 160, 290, 34);
    }

    public static void main(String args[]){
        /* 프레임을 만든다. */
        ExOptionDialog mf = new ExOptionDialog("옵션 대화 상자");

        /* 윈도우 이벤트 핸들러 등록*/
        mf.addWindowListener(
            new WindowAdapter() {
                 /* 종료 이벤트 처리 */
                public void windowClosing(WindowEvent ev){
                    System.exit(0);
                }   
            }
        );
 
        mf.setSize(300, 200);
        mf.setVisible(true);
    }
}

