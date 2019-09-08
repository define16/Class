package jv20;

import java.awt.*;
import java.awt.event.*;
  
public class ExAppForm extends Frame{
    // 메뉴바
    MenuBar xMenuBar;    
    // 툴바
    Panel xToolBar;    
    // 상태바
    Panel xStatusBar;

    public ExAppForm(String title){
        super(title);
        setLayout(new BorderLayout(0, 0));

        setupMenuBar();     // 메뉴바 설정
        setupToolBar();     // 툴바 설정
        setupStatusBar();   // 상태바 설정
        
        // 내용 패널의 영역에 텍스트 영역 컨포넌트를 추가한다.
        add(new TextArea("내용 패널"), BorderLayout.CENTER);
    }
    
    /* 메뉴바를 설정한다 */
    private void setupMenuBar(){
        xMenuBar = new MenuBar();
        Menu menu;

        /* 파일 메뉴를 만든다 */
        menu = new Menu("File");
        menu.add(new MenuItem("New", new MenuShortcut(KeyEvent.VK_N)));
        menu.add(new MenuItem("Open"));
        menu.add(new MenuItem("Save"));
        menu.addSeparator();
        menu.add(new MenuItem("Exit"));
        xMenuBar.add(menu);

        /* Help 메뉴를 만든다 */        
        menu = new Menu("Help");
        menu.add(new MenuItem("About"));
        menu.add(new MenuItem("Help"));
        xMenuBar.setHelpMenu(menu);

        /* 메뉴바를 프레임에 추가한다. */        
        setMenuBar(xMenuBar);
    }

    /* 툴바를 만든다. */
    private void setupToolBar(){
        
        /* 툴바를 만들고 FlowLayout을 사용한다. */
        xToolBar = new Panel(new BorderLayout(2, 2));
        xToolBar.setBackground(Color.lightGray);
    
        /* 버튼들을 추가한다 */
        Panel panel = new Panel(new GridLayout(1, 0, 2, 2));
        panel.add(new Button("Open"));    
        panel.add(new Button("Save"));
        xToolBar.add(panel, BorderLayout.WEST);
        
        panel = new Panel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        panel.add(new Label(" Search:", Label.RIGHT));    
        panel.add(new TextField(10));
        xToolBar.add(panel, BorderLayout.EAST);
        
        /* 툴바를 프레임의 북쪽에 추가한다. */
        add(xToolBar, BorderLayout.NORTH);
    }
    
    /* 상태바를 만든다 */
    private void setupStatusBar(){
        Label label;
        
        /* 상태바를 만들고 BorderLayout을 사용한다 */
        xStatusBar = new Panel(new BorderLayout(2, 2));
        xStatusBar.setBackground(Color.darkGray);
        
        /* 진행 정보를 보여주는 레이블을 추가한다 */
        label = new Label("  80%  ", Label.CENTER);
        label.setBackground(Color.lightGray);
        xStatusBar.add(label, BorderLayout.WEST);

        /* 상태 정보를 보여주는 레이블을 추가한다 */        
        label = new Label(" 상태 정보입니다. ", Label.LEFT);
        label.setBackground(Color.lightGray);
        xStatusBar.add(label, BorderLayout.CENTER);
        
        /* 상태 바를 프레임의 남쪽에 추가한다 */
        add(xStatusBar, BorderLayout.SOUTH);
    }
    

    public static void main(String args[]){
        /* 프레임을 만든다. */
        ExAppForm mf = new ExAppForm("응용 프로그램 폼");

        /* 윈도우 이벤트 핸들러 등록*/
        mf.addWindowListener(
            new WindowAdapter() {
                 /* 종료 이벤트 처리 */
                public void windowClosing(WindowEvent ev){
                    System.exit(0);
                }   
            }
        );
 
        mf.setSize(300, 400);
        mf.setVisible(true);
    }
}

