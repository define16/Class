package jv20;

import java.awt.*;
import java.awt.event.*;
  
public class TabPanel extends Frame{
    // 탭 바와 탭 패널
    Panel xTabBar, xTabPanel;
    // 탭 버튼들
    Button buttonCard1, buttonCard2;
    
    // 내용 패널
    Panel panelContent;
    // 카드 패널들
    Panel panelCard1, panelCard2;
  

    /* 탭 버튼이 눌려진 이벤트를 처리하기 위한 이벤트 리스너 */
    class TabListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            // 카드 레이아웃 매니저를 얻는다.
            CardLayout layout = (CardLayout)panelContent.getLayout();
            
            // 해당하는 카드를 보여준다.
            layout.show(panelContent, ev.getActionCommand());
        }
    }

    public TabPanel(String title){
        super(title);
        setLayout(new BorderLayout(2, 0));

        /*
            탭 버튼들을 설정한다
        */
        /* 탭바를 만들고 FlowLayout을 사용한다. */
        xTabBar = new Panel(new FlowLayout(FlowLayout.LEFT, 3, 0));

        /* 탭 패널을 만들고 GridLayout을 사용한다 */
        xTabPanel = new Panel(new GridLayout(1, 0, 1, 0));
        
        /* 탭 패널에 탭 버튼들을 추가한다 */
        buttonCard1 = new Button("Card 1");
        xTabPanel.add(buttonCard1);
        
        buttonCard2 = new Button("카드 2번");
        xTabPanel.add(buttonCard2);

        xTabBar.add(xTabPanel);            

        /* 탭바를 프레임의 북쪽에 추가한다. */
        add(xTabBar, BorderLayout.NORTH);

        /* 버튼에 이벤트 리스너를 등록한다. */        
        TabListener tab_listener = new TabListener();
        buttonCard1.addActionListener(tab_listener);
        buttonCard2.addActionListener(tab_listener);
        
        /* 
            내용 패널을 만든다. 
        */
        /* 카드 레이아웃을 사용하는 새 패널을 만든다 */
        panelContent = new Panel(new CardLayout(5, 5));
        panelContent.setBackground(Color.lightGray);
        
        /* 1번 카드를 만들어 추가한다 */
        panelCard1 = new Panel(new BorderLayout());
        panelCard1.add(
            new Button("Card1 입니다"), BorderLayout.CENTER
        );
        panelContent.add(panelCard1, buttonCard1.getActionCommand());

        /* 2번 카드를 만들어 추가한다 */
        panelCard2 = new Panel(new BorderLayout());
        panelCard2.add(
            new Label("Card2 입니다", Label.CENTER), 
            BorderLayout.CENTER
        );
        panelContent.add(panelCard2, buttonCard2.getActionCommand());
     
        add(panelContent, BorderLayout.CENTER);
    }
    

    public static void main(String args[]){
        /* 프레임을 만든다. */
        TabPanel mf = new TabPanel("TabPanel");

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

