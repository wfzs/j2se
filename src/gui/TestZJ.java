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
		JFrame f=new JFrame("计算器");
		f.setSize(400,300);
//		f.setLocation(100, 100);
		f.setLocationRelativeTo(null);
//		f.setLayout(new GridLayout(4,5));
//		f.setLayout(null);
		f.setLayout(new FlowLayout());
		
		//Label显示文字，图片
//		JLabel l=new JLabel("LOL");
//		l.setForeground(Color.red);
//		l.setBounds(50, 50, 280, 30);		
		
		//复选框JCheckBox
//		JCheckBox bCheckBox=new JCheckBox("物理英雄");
//		bCheckBox.setBounds(50, 50, 130, 30);
//		JCheckBox bCheckBox2=new JCheckBox("魔法英雄");
//		bCheckBox2.setBounds(50, 100, 130, 30);
		
		//单选框JRadioButton   ButtonGroup按钮组
//		JRadioButton b1=new JRadioButton("物理英雄");
//		b1.setSelected(true);
//		b1.setBounds(50, 50, 130, 30);
//		JRadioButton b2=new JRadioButton("物理英雄");
//		b2.setBounds(50, 100, 130, 30);
//		System.out.println(b1.isSelected());		
//		ButtonGroup bg=new ButtonGroup();
//		bg.add(b1);
//		bg.add(b2);
		
		//JComboBox 下拉框
//		String[] heros=new String[]{"卡特琳娜","安妮","剑圣","菲奥娜"};
//		JComboBox cb=new JComboBox(heros);
//		cb.setBounds(50, 50, 80, 30);
	
//		JLabel lName=new JLabel("账号：");
//		JTextField tfName=new JTextField("");
//		tfName.setText("请输入账号");
//		tfName.setPreferredSize(new Dimension(100,30));
//		JLabel lPassword=new JLabel("密码：");
//		JTextField tfPassword=new JTextField("");
//		tfPassword.setText("请输入密码");
//		tfPassword.setPreferredSize(new Dimension(100,30));
//		tfPassword.grabFocus();
//		JPasswordField tfPassword=new JPasswordField("");
//		tfPassword.setText("$qw^72IO");
//		tfPassword.setPreferredSize(new Dimension(100,30));
		
//		char[] password=tfPassword.getPassword();
//		System.out.println(new String(password));
		
//		JLabel l=new JLabel("文本域：");
//		JTextArea ta=new JTextArea();
//		ta.setPreferredSize(new Dimension(200,150));
//		ta.setText("抢人头！\n抢你妹啊抢！\n");
//		ta.append("我去送了了了了了了了了了了了了了了了了了了了了了了了了");
//		ta.setLineWrap(true);
		
		//进度条 JPregressBar
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
		JButton bOpen=new JButton("打开文件");
		JButton bSave=new JButton("保存文件");
		
		bOpen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnVal=fc.showOpenDialog(f);
				File file=fc.getSelectedFile();
				if(returnVal==JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(f, "计划打开文件:"+file.getAbsolutePath());
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
                    JOptionPane.showMessageDialog(f, "计划保存到文件:" + file.getAbsolutePath());
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
				
		
		//JOptionPane  对话框
//		int option=JOptionPane.showConfirmDialog(f, "是否使用外挂?");
//		if(JOptionPane.OK_OPTION==option){
//			String answer=JOptionPane.showInputDialog(f, "请输入yes,表明使用外挂后果自负");
//			if("yes".equals(answer)){
//				JOptionPane.showMessageDialog(f, "你是使用外挂被抓住，被罚捡肥皂3次");
//			}
//		}
	}
}
