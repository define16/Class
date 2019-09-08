package jv17;

import java.awt.*;
import javax.swing.*;

class TablePanel extends JPanel{

    TablePanel(){
       setLayout(new BorderLayout());

        String col_names[] = {"ID", "이름", "직업", "참석 여부"};
       Object data[][] = {
             {"0181", "Bill Cat", "Political Candidate", new Boolean(false)},
             {"0915", "Opus Penguin", "Science", new Boolean(true)},
             {"1912", "Milo Bloom", "Reporter", new Boolean(true)},
             {"3182", "Steve Dallas", "Legal", new Boolean(false)},
             {"5476", "Billy Boinger", "Entertainment", new Boolean(true)},
       };
       JTable table = new JTable(data, col_names);
       add(new JScrollPane(table));
   }
}

public class TableTest {
	public static void main(String args[]){
		JFrame f = new JFrame("JTable Test");
		TablePanel table = new TablePanel();
		f.getContentPane().add(table);
		f.setSize(300, 200);
		f.setVisible(true);
	}
}