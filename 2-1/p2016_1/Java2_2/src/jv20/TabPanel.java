package jv20;

import java.awt.*;
import java.awt.event.*;
  
public class TabPanel extends Frame{
    // �� �ٿ� �� �г�
    Panel xTabBar, xTabPanel;
    // �� ��ư��
    Button buttonCard1, buttonCard2;
    
    // ���� �г�
    Panel panelContent;
    // ī�� �гε�
    Panel panelCard1, panelCard2;
  

    /* �� ��ư�� ������ �̺�Ʈ�� ó���ϱ� ���� �̺�Ʈ ������ */
    class TabListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            // ī�� ���̾ƿ� �Ŵ����� ��´�.
            CardLayout layout = (CardLayout)panelContent.getLayout();
            
            // �ش��ϴ� ī�带 �����ش�.
            layout.show(panelContent, ev.getActionCommand());
        }
    }

    public TabPanel(String title){
        super(title);
        setLayout(new BorderLayout(2, 0));

        /*
            �� ��ư���� �����Ѵ�
        */
        /* �ǹٸ� ����� FlowLayout�� ����Ѵ�. */
        xTabBar = new Panel(new FlowLayout(FlowLayout.LEFT, 3, 0));

        /* �� �г��� ����� GridLayout�� ����Ѵ� */
        xTabPanel = new Panel(new GridLayout(1, 0, 1, 0));
        
        /* �� �гο� �� ��ư���� �߰��Ѵ� */
        buttonCard1 = new Button("Card 1");
        xTabPanel.add(buttonCard1);
        
        buttonCard2 = new Button("ī�� 2��");
        xTabPanel.add(buttonCard2);

        xTabBar.add(xTabPanel);            

        /* �ǹٸ� �������� ���ʿ� �߰��Ѵ�. */
        add(xTabBar, BorderLayout.NORTH);

        /* ��ư�� �̺�Ʈ �����ʸ� ����Ѵ�. */        
        TabListener tab_listener = new TabListener();
        buttonCard1.addActionListener(tab_listener);
        buttonCard2.addActionListener(tab_listener);
        
        /* 
            ���� �г��� �����. 
        */
        /* ī�� ���̾ƿ��� ����ϴ� �� �г��� ����� */
        panelContent = new Panel(new CardLayout(5, 5));
        panelContent.setBackground(Color.lightGray);
        
        /* 1�� ī�带 ����� �߰��Ѵ� */
        panelCard1 = new Panel(new BorderLayout());
        panelCard1.add(
            new Button("Card1 �Դϴ�"), BorderLayout.CENTER
        );
        panelContent.add(panelCard1, buttonCard1.getActionCommand());

        /* 2�� ī�带 ����� �߰��Ѵ� */
        panelCard2 = new Panel(new BorderLayout());
        panelCard2.add(
            new Label("Card2 �Դϴ�", Label.CENTER), 
            BorderLayout.CENTER
        );
        panelContent.add(panelCard2, buttonCard2.getActionCommand());
     
        add(panelContent, BorderLayout.CENTER);
    }
    

    public static void main(String args[]){
        /* �������� �����. */
        TabPanel mf = new TabPanel("TabPanel");

        /* ������ �̺�Ʈ �ڵ鷯 ���*/
        mf.addWindowListener(
            new WindowAdapter() {
                 /* ���� �̺�Ʈ ó�� */
                public void windowClosing(WindowEvent ev){
                    System.exit(0);
                }   
            }
        );
 
        mf.setSize(300, 200);
        mf.setVisible(true);
    }
}

