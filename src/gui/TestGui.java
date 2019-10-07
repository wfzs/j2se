package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGui {
	public static void main(String[] args) {
		//主窗体
		JFrame f=new JFrame("LOL");
		//主窗体大小
		f.setSize(400,300);
		
//		Point p=getPointFromLocationFile();
//		if(p!=null){
//			f.setLocation(p.x,p.y);
//		}
//		else{
//			f.setLocation(200,200);
//		}		
		//窗口位置
		f.setLocationRelativeTo(null);
//		f.setLocation(200, 200);
		
		//主窗体中的组件设置为绝对定位
//		f.setLayout(null);
		f.setLayout(new FlowLayout());
//		f.setLayout(new BorderLayout());
//		f.setLayout(new GridLayout(2,2));
		
		
		JDialog d=new JDialog(f);
		
//		d.setModal(true);
		d.setTitle("这是一个模态的对话框");
		d.setSize(200,200);
		d.setLocationRelativeTo(f);
//		d.setLocation(200, 180);
		d.setLayout(null);
		
		final JLabel l=new JLabel();
		
		ImageIcon i=new ImageIcon("D:\\project\\j2se\\shana.png");
		l.setIcon(i);
		//同时设置组件大小和位置
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		
		
		//键盘监听
//		d.addKeyListener(new KeyListener(){
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getKeyCode()==39){
//					l.setLocation(l.getX()+10, l.getY());
//				}
//				if(e.getKeyCode()==37){
//					l.setLocation(l.getX()-10, l.getY());
//				}
//				if(e.getKeyCode()==40){
//					l.setLocation(l.getX(), l.getY()+10);
//				}
//				if(e.getKeyCode()==38){
//					l.setLocation(l.getX(), l.getY()-10);
//				}
//			}
//		});
		JButton b=new JButton("打开一个模态窗口");
//		b.setBounds(50, 10, 300, 20);
		JButton b2=new JButton("我在左下角");
//		b2.setBounds(50, 80, 300, 20);
		JButton b3=new JButton("我在右下角");
//		b3.setBounds(50, 150, 300, 20);
		JButton b4=new JButton("我在中间");
//		b4.setPreferredSize(new Dimension(180,40));
		
//		d.add(l);
		//鼠标监听
//		l.addMouseListener(new MouseAdapter(){		
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				Random r=new Random();
//				int x=r.nextInt(f.getWidth()-l.getWidth());
//				int y=r.nextInt(f.getHeight()-l.getHeight());
//				l.setLocation(x, y);
//			}		
//		});
		//按钮组件
//		JButton b=new JButton("隐藏图片");
		
//		b.setBounds(150, 200, 100, 30);		
	
		
		b.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e){
				JButton bb=new JButton("锁定大小");
				bb.setBounds(50, 50, 100, 30);
				bb.addActionListener(new ActionListener(){
					boolean change=false;
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						d.setResizable(change);
						change=!change;
						bb.setText(change?"解锁大小":"锁定大小");
					}
					
				});
				d.add(bb);
				d.setVisible(true);	
			}
		});
		
		
		f.add(b);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.setResizable(false);
		//关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//让窗体变得可见
		f.setVisible(true);
//		d.setVisible(true);
		
//		new SavingPostionThread(f).start();
	}
	static class Point{
		int x;
		int y;		
	}
	public static Point getPointFromLocationFile(){
		File file=new File("D:\\project\\j2se\\location.txt");
		Point p=null;
		try(FileInputStream fis=new FileInputStream(file);
				DataInputStream dis=new DataInputStream(fis)){
			int x=dis.readInt();
			int y=dis.readInt();
			p=new Point();
			p.x=x;
			p.y=y;
		}catch(FileNotFoundException e){
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return p;
	}
}
