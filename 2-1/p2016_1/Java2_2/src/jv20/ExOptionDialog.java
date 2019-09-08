package jv20;

import java.awt.*;
import java.awt.event.*;
  
public class ExOptionDialog extends Frame{
    Panel panelSizeOption;
        // ������ �ɼ� �г�
    Panel panelNameOption;
        // �̸� �ɼ� �г�

    Panel panelButtons;
        // ��ư �г�
    Panel panelButtonBar;
        // ��ư �г��� ���� �г�

    public ExOptionDialog(String title){
        super(title);
        // ���̾ƿ� �Ŵ����� ������� �ʴ´�.
        setLayout(null);
        setResizable(false);
        
        /* ������ �ɼ� �г��� ����� GridLayout���� �����Ѵ�. */
        panelSizeOption = new Panel(new GridLayout(0, 1));        
        
        // �ɼ� ���̺��� �ܴ�.
        panelSizeOption.add(new Label("�׷��� ũ��"));
        
        // �ɼ��� ��Ÿ���� üũ�ڽ����� �߰��Ѵ�.
        CheckboxGroup cg = new CheckboxGroup();
        panelSizeOption.add(new Checkbox("one", cg, false));
        panelSizeOption.add(new Checkbox("two", cg, false));
        panelSizeOption.add(new Checkbox("three", cg, false));

        /* ������ �ɼ� �г��� ũ��� ��ġ�� ���ؼ� �����ӿ� �߰��Ѵ�. */
        panelSizeOption.setBounds(25, 45, 105, 100);            
        add(panelSizeOption);
        
        /* �̸� �ɼ� �г��� ����� GridLayout���� �����Ѵ�. */
        panelNameOption = new Panel(new GridLayout(0, 1));
        
        // �ɼ� ���̺��� �ܴ�.
        panelNameOption.add(new Label("�׷� �̸�"));
        panelNameOption.add(new TextField());

        /* �̸� �ɼ� �г��� ũ��� ��ġ�� ���ؼ� �����ӿ� �߰��Ѵ�. */
        panelNameOption.setBounds(145, 45, 100, 45);            
        add(panelNameOption);


        /* ��ư�ٸ� ����� FlowLayout���� ������ �д�. */
        panelButtonBar = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelButtonBar.setBackground(Color.lightGray);

        /* �� �ƴϿ� ��ư�� ��ư �гο� �߰���Ų��. */
        panelButtons = new Panel(new GridLayout(1, 2, 15, 5));
        
        panelButtons.add(new Button("��"));
        panelButtons.add(new Button("�ƴϿ�"));

        /* ��ư�ٿ� ��ư �г��� ���� ���� �����̳ʿ� �߰��Ѵ� */
        panelButtonBar.add(panelButtons);
        add(panelButtonBar);
        
        panelButtonBar.setBounds(5, 160, 290, 34);
    }

    public static void main(String args[]){
        /* �������� �����. */
        ExOptionDialog mf = new ExOptionDialog("�ɼ� ��ȭ ����");

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

