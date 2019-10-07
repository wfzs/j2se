package gui;

import java.awt.BorderLayout;
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

import com.sun.org.apache.bcel.internal.generic.LASTORE;

import jdbc.Hero;
import jdbc.HeroDAO;

public class Table {
	static HeroTableModel htm=new HeroTableModel();
	static JTable t=new JTable(htm);
	
	// �ѷ�ҳ��ť�����������������÷���
    static JButton bFirst = new JButton("��ҳ");
    static JButton bPre = new JButton("��һҳ");
    static JButton bNext = new JButton("��һҳ");
    static JButton bLast = new JButton("ĩҳ");
    static JComboBox<Integer> cb=new JComboBox<>();
    private static boolean cbListenerEnabled = true;
    
    static int number = 10;// ÿҳ��ʾ10��
    static int start = 0;// ��ʼ��ҳ��
    
	public static void main(String[] args) {
		JFrame f=new JFrame("LOL");
		f.setSize(410,330);
		f.setLocationRelativeTo(null);
		f.setLayout(null);				
		
		JPanel l=new JPanel();
		JButton add=new JButton("����");	
		JButton delete=new JButton("ɾ��");
		JButton edit=new JButton("�༭");
		l.add(add);
		l.add(delete);
		l.add(edit);
		
		JPanel pPage=new JPanel();
		pPage.add(bFirst);
		pPage.add(bPre);
		pPage.add(cb);
		pPage.add(bNext);
		pPage.add(bLast);
		
		addPageLisenter();
		JScrollPane sp=new JScrollPane(t);
		
		t.getColumnModel().getColumn(0).setPreferredWidth(20);
		
		sp.setBounds(0, 0, 394, 200);
		l.setBounds(0, 200, 394, 50);
		pPage.setBounds(0, 250, 394, 50);
		f.add(sp);
		f.add(l);
		f.add(pPage);
		updateButtonStatus();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!cbListenerEnabled)
					return;
				int currentPage=(int)cb.getSelectedItem();
				start=(currentPage-1)*number;
				updateUI();
				updateButtonStatus();
			}
		});
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddDialog(f).setVisible(true);
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=t.getSelectedRow();
				if(row==-1){
					JOptionPane.showMessageDialog(f, "δѡ������");
					return;
				}
				if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(f, "ȷ��ɾ����")){
					return;
				}
				Hero h=htm.heros.get(row);
				new HeroDAO().delete(h.id);
				updateUI();				
//				updateButtonStatus();
			}
		});
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=t.getSelectedRow();
				if(row==-1){
					JOptionPane.showMessageDialog(f, "δѡ������");
					return;
				}
				Hero h=htm.heros.get(row);
				editDialog et=new editDialog(f);
				et.tfName.setText(h.name);
				et.tfHp.setText(String.valueOf(h.hp));
				et.setVisible(true);				
			}
		});
	}
	private static void addPageLisenter() {
		// TODO Auto-generated method stub
		bFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start=0;
				updateUI();
				updateButtonStatus();
			}
		});
		bPre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start-=number;
				updateUI();
				updateButtonStatus();
			}
		});
		bNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start+=number;
				updateUI();
				updateButtonStatus();
			}
		});
		bLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start=last();
				updateUI();
				updateButtonStatus();
			}
		});
	}
	protected static int last() {
		// TODO Auto-generated method stub
		int last;
		int total=new HeroDAO().getTotal();
		
		if(0==total%number){
			last=total-number;
		}else{
			last=total-total%number;
		}
		return last;
	}
	private static void updateButtonStatus() {
		// TODO Auto-generated method stub
		int last=last();
		if(start==0){
			bFirst.setEnabled(false);
			bPre.setEnabled(false);
		}
		if(start!=0){
			bFirst.setEnabled(true);
			bPre.setEnabled(true);
		}
		if(start==last){
			bNext.setEnabled(false);
			bLast.setEnabled(false);
		}
		if(start<last){
			bNext.setEnabled(true);
			bLast.setEnabled(true);
		}
		
		//��ҳ��
		int pageNumber=last/number+1;
		cbListenerEnabled=false;
		cb.removeAllItems();
		for(int i=0;i<pageNumber;i++){
			cb.addItem(i+1);
		}
		
		cbListenerEnabled=true;
		//��ǰҳ��
		int currentpage=start/number+1;
		cb.setSelectedItem(currentpage);
	}
	static class AddDialog extends JDialog{
		JLabel lName = new JLabel("����");
		JLabel lHp = new JLabel("Ѫ��");
		
		JTextField tfName =new JTextField();
		JTextField tfHp =new JTextField();
		
		JButton bSubmit =new JButton("�ύ");
		public AddDialog(JFrame f){
			super(f);
			this.setModal(true);
			this.setLayout(null);
			JPanel pInput=new JPanel();
			JPanel pSubmit=new JPanel();
			
			pInput.setLayout(new GridLayout(2,2,50,50));
			pInput.add(lName);
			pInput.add(tfName);
			pInput.add(lHp);
			pInput.add(tfHp);
			
			pSubmit.add(bSubmit);
			
			pInput.setBounds(50,20,200,100);
			pSubmit.setBounds(0,130,300,150);
			
			this.add(pInput);
			this.add(pSubmit);
			
			this.setSize(300,220);
			this.setLocationRelativeTo(f);
			
			bSubmit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(checkEmpty(tfName, "����")){
						if(checkNumber(tfHp, "Ѫ��")){
							String name=tfName.getText().trim();
							float hp=Float.valueOf(tfHp.getText().trim());
							Hero hero=new Hero();
							hero.name=name;
							hero.hp=hp;
							HeroDAO dao=new HeroDAO();
							dao.add(hero);
							JOptionPane.showMessageDialog(f, "�ύ�ɹ�");
							AddDialog.this.setVisible(false);
							updateUI();
							updateButtonStatus();
						}
					}
				}
			});
		}
	}
	static class editDialog extends JDialog{
		JLabel lName = new JLabel("����");
		JLabel lHp = new JLabel("Ѫ��");
		
		JTextField tfName =new JTextField();
		JTextField tfHp =new JTextField();
		
		JButton bSubmit =new JButton("�ύ");
		public editDialog(JFrame f){
			super(f);
			this.setModal(true);
			this.setLayout(null);
			
			JPanel pInput=new JPanel();
			JPanel pSubmit=new JPanel();
			pInput.setLayout(new GridLayout(2, 2, 50, 50));
			pInput.add(lName);
			pInput.add(tfName);
			pInput.add(lHp);
			pInput.add(tfHp);
			
			pSubmit.add(bSubmit);
			
			pInput.setBounds(50,20,200,100);
			pSubmit.setBounds(0,130,300,150);
			this.add(pInput);
			this.add(pSubmit);
			
			this.setSize(300,220);
			this.setLocationRelativeTo(f);
			
			bSubmit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(checkEmpty(tfName, "����")){
						if(checkNumber(tfHp, "hp")){
							int row=t.getSelectedRow();							
							Hero h=htm.heros.get(row);
							h.name=tfName.getText().trim();
							h.hp=Float.valueOf(tfHp.getText().trim());
							new HeroDAO().update(h);
							JOptionPane.showMessageDialog(f, "�޸ĳɹ�");
							editDialog.this.setVisible(false);
							updateUI();
						}
					}
				}
			});
		}
	}
	public static void updateUI(){
		htm.heros=new HeroDAO().list(start,number);
		t.updateUI();
		if(!htm.heros.isEmpty()){
			t.getSelectionModel().setSelectionInterval(0, 0);
		}
	}
	public static boolean checkEmpty(JTextField tf,String msg){
		String str=tf.getText().trim();
		if(str.length()==0){
			JOptionPane.showMessageDialog(null, msg+"����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	public static boolean checkNumber(JTextField tf,String msg){
		String str=tf.getText().trim();
		if(str.length()==0){
			JOptionPane.showMessageDialog(null, msg+"����Ϊ��");
			tf.grabFocus();
			return false;
		}
		try {
			Float.valueOf(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, msg+"ֻ�����������");
			tf.grabFocus();
			return false;
		}
		return true;
	}
}
