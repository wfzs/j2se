package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class TestZJ {
	public static void main(String[] args) {
		JFrame f=new JFrame("������");
		f.setSize(400,300);
//		f.setLocation(100, 100);
		f.setLocationRelativeTo(null);
//		f.setLayout(new GridLayout(4,5));
//		f.setLayout(null);
		f.setLayout(new FlowLayout());
		
		//Label��ʾ���֣�ͼƬ
//		JLabel l=new JLabel("LOL");
//		l.setForeground(Color.red);
//		l.setBounds(50, 50, 280, 30);		
		
		//��ѡ��JCheckBox
//		JCheckBox bCheckBox=new JCheckBox("����Ӣ��");
//		bCheckBox.setBounds(50, 50, 130, 30);
//		JCheckBox bCheckBox2=new JCheckBox("ħ��Ӣ��");
//		bCheckBox2.setBounds(50, 100, 130, 30);
		
		//��ѡ��JRadioButton   ButtonGroup��ť��
//		JRadioButton b1=new JRadioButton("����Ӣ��");
//		b1.setSelected(true);
//		b1.setBounds(50, 50, 130, 30);
//		JRadioButton b2=new JRadioButton("����Ӣ��");
//		b2.setBounds(50, 100, 130, 30);
//		System.out.println(b1.isSelected());		
//		ButtonGroup bg=new ButtonGroup();
//		bg.add(b1);
//		bg.add(b2);
		
		//JComboBox ������
//		String[] heros=new String[]{"��������","����","��ʥ","�ư���"};
//		JComboBox cb=new JComboBox(heros);
//		cb.setBounds(50, 50, 80, 30);
	
//		JLabel lName=new JLabel("�˺ţ�");
//		JTextField tfName=new JTextField("");
//		tfName.setText("�������˺�");
//		tfName.setPreferredSize(new Dimension(100,30));
//		JLabel lPassword=new JLabel("���룺");
//		JTextField tfPassword=new JTextField("");
//		tfPassword.setText("����������");
//		tfPassword.setPreferredSize(new Dimension(100,30));
//		tfPassword.grabFocus();
//		JPasswordField tfPassword=new JPasswordField("");
//		tfPassword.setText("$qw^72IO");
//		tfPassword.setPreferredSize(new Dimension(100,30));
		
//		char[] password=tfPassword.getPassword();
//		System.out.println(new String(password));
		
//		JLabel l=new JLabel("�ı���");
//		JTextArea ta=new JTextArea();
//		ta.setPreferredSize(new Dimension(200,150));
//		ta.setText("����ͷ��\n�����ð�����\n");
//		ta.append("��ȥ��������������������������������������������������");
//		ta.setLineWrap(true);
		
		//������ JPregressBar
//		JProgressBar pb=new JProgressBar();
//		pb.setMaximum(100);
//		pb.setValue(50);
//		pb.setStringPainted(true);
		
		JFileChooser fc=new JFileChooser();
		fc.setFileFilter(new FileFilter(){

			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getName().toLowerCase().endsWith(".txt");
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return ".txt";
			}
			
		});
		JButton bOpen=new JButton("���ļ�");
		JButton bSave=new JButton("�����ļ�");
		
		bOpen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnVal=fc.showOpenDialog(f);
				File file=fc.getSelectedFile();
				if(returnVal==JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(f, "�ƻ����ļ�:"+file.getAbsolutePath());
				}
			}
			
		});
		
		bSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnVal =  fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "�ƻ����浽�ļ�:" + file.getAbsolutePath());
                }
			}
			
		});
		
		f.add(bOpen);
		f.add(bSave);
//		f.add(pb);
//		f.add(ta);
//		f.add(cb);
//		f.add(b2);
//		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);	
				
		
		//JOptionPane  �Ի���
//		int option=JOptionPane.showConfirmDialog(f, "�Ƿ�ʹ�����?");
//		if(JOptionPane.OK_OPTION==option){
//			String answer=JOptionPane.showInputDialog(f, "������yes,����ʹ����Һ���Ը�");
//			if("yes".equals(answer)){
//				JOptionPane.showMessageDialog(f, "����ʹ����ұ�ץס�����������3��");
//			}
//		}
	}
}
