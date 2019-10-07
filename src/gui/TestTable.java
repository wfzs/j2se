package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jdbc.Hero;
import jdbc.HeroDAO;

public class TestTable {
	//�� htm�� table���Ϊ��̬�������ڸ��±�����ݵ�ʱ�򣬾ͺ����׷��������������
	static HeroTableModel htm = new HeroTableModel();
	static JTable t = new JTable(htm);
	
	// �ѷ�ҳ��ť�����������������÷���
    static JButton bFirst = new JButton("��ҳ");
    static JButton bPre = new JButton("��һҳ");
    static JButton bNext = new JButton("��һҳ");
    static JButton bLast = new JButton("ĩҳ");
    static JComboBox<Integer> cb = new JComboBox<Integer>();
    private static boolean cbListenerEnabled = true;
 
    static int number = 10;// ÿҳ��ʾ10��
    static int start = 0;// ��ʼ��ҳ��
	
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
        f.setSize(410, 340);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());        
//        JPanel p=new JPanel();
//        JLabel l=new JLabel("��ʱδѡ����Ŀ");
//        JLabel name=new JLabel("����");
//        JTextField tf1=new JTextField();
//        tf1.setPreferredSize(new Dimension(80,30));
//        JLabel hp=new JLabel("Ѫ��");
//        JTextField tf2=new JTextField();
//        tf2.setPreferredSize(new Dimension(80,30));
        JPanel p=new JPanel();
        JButton add=new JButton("����");
        JButton delete=new JButton("ɾ��");
        JButton edit=new JButton("�༭");
        p.add(add);
        p.add(delete);
        p.add(edit);
        add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddDialog(f).setVisible(true);
			}
        	
        });
        cb.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cbListenerEnabled)
                    return;
                 
                int currentPage = (int) cb.getSelectedItem();
                start = (currentPage-1)*number;
                updateTable();
                updateButtonStatus();
                 
            }
        });
        delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=t.getSelectedRow();
				if(-1==row){
					JOptionPane.showMessageDialog(f, "ɾ��ǰ����ѡ��һ��");
					return;
				}
				if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(f, "ȷ��ɾ����")){
					return;
				}
				//��ȡid
				Hero hero = htm.heros.get(row);
				int id =hero.id;
				
				//ɾ��
				new HeroDAO().delete(id);
				
				//����table
				updateTable();
			}
        	
        });
        edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=t.getSelectedRow();
				if(-1==row){
					JOptionPane.showMessageDialog(f, "�༭ǰ��Ҫ��ѡ��һ��");
					return;
				}
				Hero h=htm.heros.get(row);
				EditDialog ed=new EditDialog(f);
				ed.tfHp.setText(String.valueOf(h.hp));
				ed.tfName.setText(h.name);
				ed.setVisible(true);
			}
        	
        });
        JPanel p2=new JPanel();
        p2.add(bFirst);
        p2.add(bPre);
        p2.add(cb);
        p2.add(bNext);
        p2.add(bLast);
        addPageListener();
//        p.add(name);
//        p.add(tf1);
//        p.add(hp);
//        p.add(tf2);
//        p.add(add);
        //����һ��TableModel
//        HeroTableModel htm= new HeroTableModel();
         
        //���� TableModel������ Table
//        JTable t = new JTable(htm);        
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		t.getSelectionModel().setSelectionInterval(0, 0);
        JScrollPane sp = new JScrollPane(t);
  
//        f.add(p,BorderLayout.NORTH);
//        f.add(sp, BorderLayout.CENTER);
//        f.add(p,BorderLayout.SOUTH);
//        f.add(p2,BorderLayout.SOUTH);
        
        f.setLayout(null);
        sp.setBounds(0, 0, 394, 200);
        p.setBounds(0, 200, 394, 50);
        p2.setBounds(0, 250, 394, 200);
        f.add(sp);
        f.add(p);
        f.add(p2);
        updateButtonStatus();
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
        
//        t.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO Auto-generated method stub
//				int row=t.getSelectedRow();
//				Hero h=htm.heros.get(row);
//				tf1.setText(h.name);
//				tf2.setText(String.valueOf(h.hp));
//			}
//        	
//        });
        
//        add.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				HeroDAO dao=new HeroDAO();
//				Hero h=new Hero();
//				String name=tf1.getText().trim();				
//				if(name.length()==0){
//					JOptionPane.showMessageDialog(f, "���Ʋ���Ϊ��");
//					tf1.grabFocus();
//					return;
//				}
//				h.name=name;
//				String hp=tf2.getText().trim();
//				try {
//					Float.valueOf(hp);	
//				} catch (Exception e2) {
//					// TODO: handle exception
//					e2.printStackTrace();
//					JOptionPane.showMessageDialog(f, "Ѫ��ֻ�����������");
//					tf2.grabFocus();
//					return;
//				}				
//				h.hp=Float.valueOf(hp);;
//				
//				dao.add(h);
//				
//				htm.heros=dao.list();
//				// ����JTable��updateUI��ˢ�½��档
//                // ˢ�½����ʱ�򣬻ᵽtablemodel��ȥȡ���µ�����
//                // ���ܿ����¼ӽ�ȥ��������
// 
//                t.updateUI();
//                
//                // ѡ�� ��һ�� ����Ϊ DAO�ǰ��� ID�������ѯ�����Ե�һ�о����¼��������     
////                t.getSelectionModel().setSelectionInterval(htm.getRowCount(), htm.getRowCount());
//			}
//        	
//        });
	}
	private static void addPageListener() {
		 
	        bFirst.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                start = 0;
	                updateTable();
	                updateButtonStatus();
	            }
	        });
	        bPre.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                start -= number;
	                updateTable();
	                updateButtonStatus();
	            }
	        });
	        bNext.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                start += number;
	                updateTable();
	                updateButtonStatus();
	            }
	        });
	        bLast.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                start = last();
	                updateTable();
	                updateButtonStatus();
	            }
	 
	        });
	 
	    }
	private static int last() {
        // ���һҳ��ʼ��λ��
        int last;
 
        int total = new HeroDAO().getTotal();
 
        // ���һҳҪ�������Ƿ��ܹ�����ÿҳ��ʾ������number
 
        if (0 == total % number) {
            // ����������20����ô���һҳ��ʼ��λ�þ���10
            last = total - number;
        } else {
            // ����������21����ô���һҳ��ʼ��λ�þ���20
            last = total - total % number;
        }
        return last;
 
    }
	private static void updateButtonStatus() {
        int last = last();
 
        // �Ƿ�����һҳ
        if (0 != start) {
            bFirst.setEnabled(true);
            bPre.setEnabled(true);
        }
 
        // �Ƿ��ǵ�һҳ
        if (0 == start) {
            bFirst.setEnabled(false);
            bPre.setEnabled(false);
        }
 
        // �Ƿ������һҳ
        if (start == last) {
            bLast.setEnabled(false);
            bNext.setEnabled(false);
        }
        // �Ƿ�����һҳ
        if (start < last) {
            bLast.setEnabled(true);
            bNext.setEnabled(true);
        }
 
    }
	static class AddDialog extends JDialog{
		JLabel lName = new JLabel("����");
		JLabel lHp = new JLabel("Ѫ��");
		
		JTextField tfName =new JTextField();
		JTextField tfHp =new JTextField();
		
		JButton bSubmit =new JButton("�ύ");
		
		AddDialog(JFrame f){
			super(f);
			this.setModal(true);
			int gap = 50;
			this.setLayout(null);
			
			JPanel pInput= new JPanel();
			JPanel pSubmit= new JPanel();
			
			pInput.setLayout(new GridLayout(2, 2,gap,gap));
			pInput.add(lName);
			pInput.add(tfName);
			pInput.add(lHp);
			pInput.add(tfHp);
			
			pSubmit.add(bSubmit);
			
			pInput.setBounds(50,20,200,100);
			pSubmit.setBounds(0,130,300,150);
			
			this.add(pInput);
			this.add(pSubmit);

			this.setSize(300, 220);
			this.setLocationRelativeTo(f);
			bSubmit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(checkEmpty(tfName, "����")){
						if(checkNumber(tfHp, "hp")){
						
							String name = tfName.getText();
							int hp = Integer.parseInt(tfHp.getText());
							
							Hero h = new Hero();
							h.name = name;
							h.hp = hp;
							
							new HeroDAO().add(h);
							
							JOptionPane.showMessageDialog(f, "�ύ�ɹ� ");
							
							AddDialog.this.setVisible(false);
							updateTable();
						}
					}
					
				}
			});
			
		}
	}
	
	public static void updateTable(){
		htm.heros = new HeroDAO().list();
		t.updateUI();
		if(!htm.heros.isEmpty())
			t.getSelectionModel().setSelectionInterval(0, 0);
	}
	
	private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        return true;
    }
	private static boolean checkNumber(JTextField tf, String msg) {
		String value = tf.getText();
		if(0==value.length()){
			JOptionPane.showMessageDialog(null,msg + " ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,msg + " ֻ��������");
			tf.grabFocus();
			return false;
		}
		
		return true;
	}
	static class EditDialog extends JDialog {
		JLabel lName = new JLabel("����");
		JLabel lHp = new JLabel("Ѫ��");

		JTextField tfName = new JTextField();
		JTextField tfHp = new JTextField();

		JButton bSubmit = new JButton("�ύ");

		EditDialog(JFrame f) {
			super(f);
			this.setModal(true);
			int gap = 50;
			this.setLayout(null);

			JPanel pInput = new JPanel();
			JPanel pSubmit = new JPanel();

			pInput.setLayout(new GridLayout(2, 2, gap, gap));
			pInput.add(lName);
			pInput.add(tfName);
			pInput.add(lHp);
			pInput.add(tfHp);

			pSubmit.add(bSubmit);

			pInput.setBounds(50, 20, 200, 100);
			pSubmit.setBounds(0, 130, 300, 150);

			this.add(pInput);
			this.add(pSubmit);

			this.setSize(300, 220);
			this.setLocationRelativeTo(f);
			bSubmit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(checkEmpty(tfName, "����")){
						if(checkNumber(tfHp, "hp")){
						
							String name = tfName.getText();
							int hp = Integer.parseInt(tfHp.getText());
							
							Hero h = new Hero();
							h.name = name;
							h.hp = hp;
							
							new HeroDAO().add(h);
							
							JOptionPane.showMessageDialog(f, "�ύ�ɹ� ");
							
							EditDialog.this.setVisible(false);
							updateTable();
						}
					}
					
				}
			});
		}
	}
}
