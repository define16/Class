package jv20;

import java.awt.*;
import java.awt.event.*;
  
public class ExAppForm extends Frame{
    // �޴���
    MenuBar xMenuBar;    
    // ����
    Panel xToolBar;    
    // ���¹�
    Panel xStatusBar;

    public ExAppForm(String title){
        super(title);
        setLayout(new BorderLayout(0, 0));

        setupMenuBar();     // �޴��� ����
        setupToolBar();     // ���� ����
        setupStatusBar();   // ���¹� ����
        
        // ���� �г��� ������ �ؽ�Ʈ ���� ������Ʈ�� �߰��Ѵ�.
        add(new TextArea("���� �г�"), BorderLayout.CENTER);
    }
    
    /* �޴��ٸ� �����Ѵ� */
    private void setupMenuBar(){
        xMenuBar = new MenuBar();
        Menu menu;

        /* ���� �޴��� ����� */
        menu = new Menu("File");
        menu.add(new MenuItem("New", new MenuShortcut(KeyEvent.VK_N)));
        menu.add(new MenuItem("Open"));
        menu.add(new MenuItem("Save"));
        menu.addSeparator();
        menu.add(new MenuItem("Exit"));
        xMenuBar.add(menu);

        /* Help �޴��� ����� */        
        menu = new Menu("Help");
        menu.add(new MenuItem("About"));
        menu.add(new MenuItem("Help"));
        xMenuBar.setHelpMenu(menu);

        /* �޴��ٸ� �����ӿ� �߰��Ѵ�. */        
        setMenuBar(xMenuBar);
    }

    /* ���ٸ� �����. */
    private void setupToolBar(){
        
        /* ���ٸ� ����� FlowLayout�� ����Ѵ�. */
        xToolBar = new Panel(new BorderLayout(2, 2));
        xToolBar.setBackground(Color.lightGray);
    
        /* ��ư���� �߰��Ѵ� */
        Panel panel = new Panel(new GridLayout(1, 0, 2, 2));
        panel.add(new Button("Open"));    
        panel.add(new Button("Save"));
        xToolBar.add(panel, BorderLayout.WEST);
        
        panel = new Panel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        panel.add(new Label(" Search:", Label.RIGHT));    
        panel.add(new TextField(10));
        xToolBar.add(panel, BorderLayout.EAST);
        
        /* ���ٸ� �������� ���ʿ� �߰��Ѵ�. */
        add(xToolBar, BorderLayout.NORTH);
    }
    
    /* ���¹ٸ� ����� */
    private void setupStatusBar(){
        Label label;
        
        /* ���¹ٸ� ����� BorderLayout�� ����Ѵ� */
        xStatusBar = new Panel(new BorderLayout(2, 2));
        xStatusBar.setBackground(Color.darkGray);
        
        /* ���� ������ �����ִ� ���̺��� �߰��Ѵ� */
        label = new Label("  80%  ", Label.CENTER);
        label.setBackground(Color.lightGray);
        xStatusBar.add(label, BorderLayout.WEST);

        /* ���� ������ �����ִ� ���̺��� �߰��Ѵ� */        
        label = new Label(" ���� �����Դϴ�. ", Label.LEFT);
        label.setBackground(Color.lightGray);
        xStatusBar.add(label, BorderLayout.CENTER);
        
        /* ���� �ٸ� �������� ���ʿ� �߰��Ѵ� */
        add(xStatusBar, BorderLayout.SOUTH);
    }
    

    public static void main(String args[]){
        /* �������� �����. */
        ExAppForm mf = new ExAppForm("���� ���α׷� ��");

        /* ������ �̺�Ʈ �ڵ鷯 ���*/
        mf.addWindowListener(
            new WindowAdapter() {
                 /* ���� �̺�Ʈ ó�� */
                public void windowClosing(WindowEvent ev){
                    System.exit(0);
                }   
            }
        );
 
        mf.setSize(300, 400);
        mf.setVisible(true);
    }
}

