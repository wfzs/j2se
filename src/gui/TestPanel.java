package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;

public class TestPanel {
	static long allFileSize=0;
	static long currentFileSize=0;
	public static void calculateFileSize(File f){
		if(f.isFile()){
			allFileSize+=f.length();
		}
		if(f.isDirectory()){
			File[] fs=f.listFiles();
			for (File file : fs) {
				calculateFileSize(file);
			}
		}
	}
	public static void main(String[] args) {
//		JFrame f=new JFrame("LOL");
//		f.setSize(400,300);
//		f.setLocation(200, 200);
//		
//		f.setLayout(null);
//		
//		JPanel p1=new JPanel();
//		p1.setBounds(50, 50, 300, 60);
//		p1.setBackground(Color.RED);
//		
//		p1.setLayout(new FlowLayout());
//		
//		JButton b1=new JButton("英雄1");
//		JButton b2=new JButton("英雄2");
//		JButton b3=new JButton("英雄3");
//		
//		p1.add(b1);
//		p1.add(b2);
//		p1.add(b3);
//		
//		JPanel p2=new JPanel();
//		JButton b4=new JButton("英雄4");
//		JButton b5=new JButton("英雄5");
//		JButton b6=new JButton("英雄6");
//		p2.add(b4);
//		p2.add(b5);
//		p2.add(b6);
//		p2.setBackground(Color.BLACK);
//		p2.setBounds(10, 150, 300, 60);
		
//		JButton bb=new JButton("HELLO WORLD");
//		bb.setBounds(10, 10, 80, 20);
		
//		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,p2);
//		sp.setDividerLocation(80);
		
//		JTextArea ta=new JTextArea();
//		for(int i=0;i<1000;i++){
//			ta.append(String.valueOf(i));
//		}
//		ta.setLineWrap(true);
//		JScrollPane sp=new JScrollPane();
//		sp.setViewportView(ta);
		
//		JTabbedPane tp=new JTabbedPane();
//		tp.add(p1);
//		tp.add(p2);
//		
//		tp.setTitleAt(0, "红色tab");
//		tp.setTitleAt(1, "黑色tab");
//		
//		ImageIcon i=new ImageIcon("d:/project/j2se/j.png");
//		tp.setIconAt(0, i);
//		tp.setIconAt(1, i);
//		f.add(p1);
//		f.add(p2);
//		f.getContentPane().add(sp);f.add(sp);这些方法都不成功		
//		f.setContentPane(tp);
		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
//		JFrame f=new JFrame("CardLayout");
//		f.setSize(400, 300);
//		f.setLocationRelativeTo(null);

//		JPanel comboxPane=new JPanel();
//		String buttonPanel="按钮面板";
//		String inputPanel="输入框面板";
//		String combo[]={buttonPanel,inputPanel};
//		JComboBox<String> cb=new JComboBox<String>(combo);
//		comboxPane.add(cb);
//		
//		JPanel card1=new JPanel();
//		card1.add(new JButton("按钮1"));
//		card1.add(new JButton("按钮2"));
//		card1.add(new JButton("按钮3"));
//		
//		JPanel card2=new JPanel();
//		card2.add(new JTextField("输入框",20));
//		
//		JPanel card=new JPanel(new CardLayout());
//		card.add(buttonPanel,card1);
//		card.add(inputPanel,card2);
//		
//		f.add(comboxPane,BorderLayout.NORTH);
//		f.add(card,BorderLayout.CENTER);
//		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
//		
//		cb.addItemListener(new ItemListener(){
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//				CardLayout c=(CardLayout)(card.getLayout());
//				c.show(card, (String)e.getItem());
//			}
//			
//		});
		
//		JPanel p1=new JPanel();
//		p1.setBounds(50, 50, 300, 60);
//		JButton b1=new JButton("盖伦");
//		JButton b2=new JButton("提莫");
//		JButton b3=new JButton("安妮");
//		p1.add(b1);
//		p1.add(b2);
//		p1.add(b3);
//		
//		JPanel p2=new JPanel();
//		JLabel l=new JLabel();
//		ImageIcon i=new ImageIcon("D:\\project\\j2se\\pics\\gareen.jpg");
//		l.setIcon(i);
//		p2.add(l);
//		p2.setBounds(10, 150, 300, 60);
//		
//		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,p2);
//		sp.setDividerLocation(80);
//		
//		f.add(sp);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
//		
//		switchPic(b1,"gareen",l);
//		switchPic(b2,"teemo",l);
//		switchPic(b3,"annie",l);
		
//		JFrame f=new JFrame("LOL");
//		f.setSize(800,600);
//		f.setLocationRelativeTo(null);
//		f.setLayout(null);
		
//		JTabbedPane tp=new JTabbedPane();
//		ImageIcon icon=new ImageIcon("d:/project/j2se/j.png");
//		File file=new File("D:\\project\\j2se\\src\\gui");
//		File[] fs=file.listFiles();
//		int i=0;
//		for(File ff:fs){
//			if(ff.getName().endsWith(".java")){
//				JScrollPane p=new JScrollPane();
//				JavaPane(p,ff);
////				JavaFilePanel p=new JavaFilePanel(ff);
//				tp.add(p);
//				tp.setIconAt(i, icon);
//				tp.setTitleAt(i, ff.getName().substring(0,6)+"...");
//				i++;
//			}			
//		}
//		f.setContentPane(tp);
//		
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		JFrame f=new JFrame("LOL");
		f.setSize(400,200);
		f.setLocationRelativeTo(null);
		f.setLayout(new FlowLayout());
		
		JLabel l1=new JLabel("源文件地址：");
		JTextField tf1=new JTextField();
		tf1.setPreferredSize(new Dimension(100,30));
		JLabel l2=new JLabel("复制到：");
		JTextField tf2=new JTextField();
		tf2.setPreferredSize(new Dimension(100,30));
		JButton b=new JButton("开始复制");
		JLabel l3=new JLabel("文件复制进度：");
		
		JProgressBar pb=new JProgressBar();
		pb.setMaximum(100);
		pb.setStringPainted(true);
//		Thread t=new Thread(){
//			public void run(){
//				int sleep=100;
//				for(int i=0;i<100;i++){
//					pb.setValue(i+1);
//					try {
//						Thread.sleep(sleep+i*10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		t.start();	
		f.add(l1);
		f.add(tf1);
		f.add(l2);
		f.add(tf2);
		f.add(b);
		f.add(l3);
		f.add(pb);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);			
				
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentFileSize=0;
				String srcFile=tf1.getText();
				calculateFileSize(new File(srcFile));
				String srcPath=tf1.getText();
				String destPath=tf2.getText();
				new Thread(()->copyFolder(srcPath,destPath)).start();
				b.setEnabled(false);
			}
			public void copyFile(String srcPath,String destPath){
				File srcFile=new File(srcPath);
				File destFile=new File(destPath);
				byte[] buffer=new byte[1024];
				try(FileInputStream fis=new FileInputStream(srcFile);
						FileOutputStream fos=new FileOutputStream(destFile)) {
					while(true){
						int num=fis.read(buffer);
						if(num==-1)
							break;
						fos.write(buffer, 0, num);
						fos.flush();
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			public void copyFolder(String srcPath,String destPath){
				File srcFolder=new File(srcPath);
				File destFolder=new File(destPath);
				if(!srcFolder.exists())
					return;
				if(!srcFolder.isDirectory())
					return;
				if(destFolder.isFile())
					return;
				if(!destFolder.exists())
					destFolder.mkdirs();
				File[] fs=srcFolder.listFiles();
				for (File file : fs) {
					if(file.isFile()){
						File newdestFile=new File(destFolder,file.getName());
						copyFile(file.getAbsolutePath(),newdestFile.getAbsolutePath());
						
						currentFileSize+=file.length();
						int progress=(int)(((double)currentFileSize/(double)allFileSize)*100);
						pb.setValue(progress);
						if(progress==100){
							JOptionPane.showMessageDialog(f, "复制完毕");
							b.setEnabled(true);
						}
					}
					if(file.isDirectory()){
						File newdestFolder=new File(destFolder,file.getName());
						copyFolder(file.getAbsolutePath(),newdestFolder.getAbsolutePath());
					}
				}
			}
		});
	}
	private static void JavaPane(JScrollPane sp,File f){
		String fileContent=getFileContent(f);
		JTextArea ta=new JTextArea(fileContent);
		sp.setViewportView(ta);
	}

	private static String getFileContent(File f) {
		// TODO Auto-generated method stub
		String fileContent=null;
		try(FileReader fr=new FileReader(f)) {
			char[] c=new char[(int)f.length()];
			fr.read(c);
			fileContent=new String(c);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fileContent;
	}
	private static void switchPic(JButton b, String string,JLabel l) {
		// TODO Auto-generated method stub
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ImageIcon i=new ImageIcon("D:\\project\\j2se\\pics\\"+string+".jpg");
				l.setIcon(i);
			}
			
		});
	}
}	
