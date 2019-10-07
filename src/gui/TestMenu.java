package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class TestMenu {
	public static void main(String[] args) {
		JFrame f=new JFrame("LOL");
		f.setSize(400,300);
		f.setLocationRelativeTo(null);
		
//		addMenu(f);
//		
//		JToolBar tb=new JToolBar();
//		JButton b1=new JButton(new ImageIcon("D:\\project\\j2se\\images\\1.jpg"));
//		JButton b2=new JButton(new ImageIcon("D:\\project\\j2se\\images\\2.jpg"));
//		JButton b3=new JButton(new ImageIcon("D:\\project\\j2se\\images\\3.jpg"));
//		JButton b4=new JButton(new ImageIcon("D:\\project\\j2se\\images\\4.jpg"));
//		JButton b5=new JButton(new ImageIcon("D:\\project\\j2se\\images\\5.jpg"));
//		JButton b6=new JButton(new ImageIcon("D:\\project\\j2se\\images\\6.jpg"));
//		tb.add(b1);
//		tb.add(b2);
//		tb.add(b3);
//		tb.add(b4);
//		tb.add(b5);
//		tb.add(b6);
//		b1.setToolTipText("坑爹英雄");
//		
//		tb.setFloatable(false);
		
		//表格
		String[] columnNames={"id","name","hp","damage"};
		String[][] heros={{"1","盖伦","500","80"},{"2","提莫","400","40"},
				{"3","易","450","70"},{"4","菲奥娜","480","100"}};
		JTable t=new JTable(heros,columnNames);		
		t.getColumnModel().getColumn(0).setPreferredWidth(20);
		JScrollPane sp=new JScrollPane(t);
		
		f.setLayout(new BorderLayout());
//		tb.setBounds(0, 0, 380, 100);
//		f.add(t,BorderLayout.NORTH);	
//		f.setContentPane(sp);
		
		f.add(sp,BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	private static void addMenu(JFrame f) {
		//菜单栏
		JMenuBar mb=new JMenuBar();
		
		//菜单
		JMenu m1=new JMenu("英雄");
		JMenu m2=new JMenu("道具");
		JMenu m3=new JMenu("符文");
		JMenu m4=new JMenu("召唤师");
		JMenu m5=new JMenu("天赋树");
//		JMenu m1=new JMenu("文件(F)");
//		JMenu m2=new JMenu("编辑(E)");
//		JMenu m3=new JMenu("格式(O)");
//		JMenu m4=new JMenu("查看(V)");
//		JMenu m5=new JMenu("帮助(H)");
		
		//菜单项
		m1.add(new JMenuItem("近战-Warriar"));
        m1.add(new JMenuItem("远程-Range"));
        m1.add(new JMenuItem("物理-physical"));
        m1.add(new JMenuItem("坦克-Tank"));
        m1.add(new JMenuItem("法系-Mage"));
        m1.add(new JMenuItem("辅助-Support"));
        m1.add(new JMenuItem("打野-Jungle"));
        m1.add(new JMenuItem("突进-Charge"));
        m1.add(new JMenuItem("男性-Boy"));
        m1.add(new JMenuItem("女性-Girl"));
        m1.addSeparator();
        m1.add("所有-All");
//		m1.add(new JMenuItem("新建(N)     Ctrl+N"));
//		m1.add(new JMenuItem("打开(O)..   Ctrl+O"));
//		m1.add(new JMenuItem("保存(S)     Ctrl+S"));
//		m1.add(new JMenuItem("另存为(A)..."));
//		m1.addSeparator();
//		m1.add(new JMenuItem("页面设置(U)..."));
//		m1.add(new JMenuItem("打印(P)     Ctrl+P"));
//		m1.addSeparator();
//		m1.add(new JMenuItem("退出(X)"));
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		
		f.setJMenuBar(mb);
	}		
	
}
