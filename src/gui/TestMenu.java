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
//		b1.setToolTipText("�ӵ�Ӣ��");
//		
//		tb.setFloatable(false);
		
		//���
		String[] columnNames={"id","name","hp","damage"};
		String[][] heros={{"1","����","500","80"},{"2","��Ī","400","40"},
				{"3","��","450","70"},{"4","�ư���","480","100"}};
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
		//�˵���
		JMenuBar mb=new JMenuBar();
		
		//�˵�
		JMenu m1=new JMenu("Ӣ��");
		JMenu m2=new JMenu("����");
		JMenu m3=new JMenu("����");
		JMenu m4=new JMenu("�ٻ�ʦ");
		JMenu m5=new JMenu("�츳��");
//		JMenu m1=new JMenu("�ļ�(F)");
//		JMenu m2=new JMenu("�༭(E)");
//		JMenu m3=new JMenu("��ʽ(O)");
//		JMenu m4=new JMenu("�鿴(V)");
//		JMenu m5=new JMenu("����(H)");
		
		//�˵���
		m1.add(new JMenuItem("��ս-Warriar"));
        m1.add(new JMenuItem("Զ��-Range"));
        m1.add(new JMenuItem("����-physical"));
        m1.add(new JMenuItem("̹��-Tank"));
        m1.add(new JMenuItem("��ϵ-Mage"));
        m1.add(new JMenuItem("����-Support"));
        m1.add(new JMenuItem("��Ұ-Jungle"));
        m1.add(new JMenuItem("ͻ��-Charge"));
        m1.add(new JMenuItem("����-Boy"));
        m1.add(new JMenuItem("Ů��-Girl"));
        m1.addSeparator();
        m1.add("����-All");
//		m1.add(new JMenuItem("�½�(N)     Ctrl+N"));
//		m1.add(new JMenuItem("��(O)..   Ctrl+O"));
//		m1.add(new JMenuItem("����(S)     Ctrl+S"));
//		m1.add(new JMenuItem("���Ϊ(A)..."));
//		m1.addSeparator();
//		m1.add(new JMenuItem("ҳ������(U)..."));
//		m1.add(new JMenuItem("��ӡ(P)     Ctrl+P"));
//		m1.addSeparator();
//		m1.add(new JMenuItem("�˳�(X)"));
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		
		f.setJMenuBar(mb);
	}		
	
}
