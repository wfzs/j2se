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
		//������
		JFrame f=new JFrame("LOL");
		//�������С
		f.setSize(400,300);
		
//		Point p=getPointFromLocationFile();
//		if(p!=null){
//			f.setLocation(p.x,p.y);
//		}
//		else{
//			f.setLocation(200,200);
//		}		
		//����λ��
		f.setLocationRelativeTo(null);
//		f.setLocation(200, 200);
		
		//�������е��������Ϊ���Զ�λ
//		f.setLayout(null);
		f.setLayout(new FlowLayout());
//		f.setLayout(new BorderLayout());
//		f.setLayout(new GridLayout(2,2));
		
		
		JDialog d=new JDialog(f);
		
//		d.setModal(true);
		d.setTitle("����һ��ģ̬�ĶԻ���");
		d.setSize(200,200);
		d.setLocationRelativeTo(f);
//		d.setLocation(200, 180);
		d.setLayout(null);
		
		final JLabel l=new JLabel();
		
		ImageIcon i=new ImageIcon("D:\\project\\j2se\\shana.png");
		l.setIcon(i);
		//ͬʱ���������С��λ��
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		
		
		//���̼���
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
		JButton b=new JButton("��һ��ģ̬����");
//		b.setBounds(50, 10, 300, 20);
		JButton b2=new JButton("�������½�");
//		b2.setBounds(50, 80, 300, 20);
		JButton b3=new JButton("�������½�");
//		b3.setBounds(50, 150, 300, 20);
		JButton b4=new JButton("�����м�");
//		b4.setPreferredSize(new Dimension(180,40));
		
//		d.add(l);
		//������
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
		//��ť���
//		JButton b=new JButton("����ͼƬ");
		
//		b.setBounds(150, 200, 100, 30);		
	
		
		b.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e){
				JButton bb=new JButton("������С");
				bb.setBounds(50, 50, 100, 30);
				bb.addActionListener(new ActionListener(){
					boolean change=false;
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						d.setResizable(change);
						change=!change;
						bb.setText(change?"������С":"������С");
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
		//�رմ����ʱ���˳�����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�ô����ÿɼ�
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
