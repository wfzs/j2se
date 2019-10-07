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
	//把 htm和 table设计为静态，后面在更新表格数据的时候，就很容易访问这个两个对象
	static HeroTableModel htm = new HeroTableModel();
	static JTable t = new JTable(htm);
	
	// 把分页按钮放在这里，后面监听器好访问
    static JButton bFirst = new JButton("首页");
    static JButton bPre = new JButton("上一页");
    static JButton bNext = new JButton("下一页");
    static JButton bLast = new JButton("末页");
    static JComboBox<Integer> cb = new JComboBox<Integer>();
    private static boolean cbListenerEnabled = true;
 
    static int number = 10;// 每页显示10个
    static int start = 0;// 开始的页码
	
	public static void main(String[] args) {
		JFrame f = new JFrame("LoL");
        f.setSize(410, 340);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());        
//        JPanel p=new JPanel();
//        JLabel l=new JLabel("暂时未选中条目");
//        JLabel name=new JLabel("名称");
//        JTextField tf1=new JTextField();
//        tf1.setPreferredSize(new Dimension(80,30));
//        JLabel hp=new JLabel("血量");
//        JTextField tf2=new JTextField();
//        tf2.setPreferredSize(new Dimension(80,30));
        JPanel p=new JPanel();
        JButton add=new JButton("增加");
        JButton delete=new JButton("删除");
        JButton edit=new JButton("编辑");
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
					JOptionPane.showMessageDialog(f, "删除前请先选中一行");
					return;
				}
				if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(f, "确定删除？")){
					return;
				}
				//获取id
				Hero hero = htm.heros.get(row);
				int id =hero.id;
				
				//删除
				new HeroDAO().delete(id);
				
				//更新table
				updateTable();
			}
        	
        });
        edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=t.getSelectedRow();
				if(-1==row){
					JOptionPane.showMessageDialog(f, "编辑前需要先选中一行");
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
        //创建一个TableModel
//        HeroTableModel htm= new HeroTableModel();
         
        //根据 TableModel来创建 Table
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
//					JOptionPane.showMessageDialog(f, "名称不能为空");
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
//					JOptionPane.showMessageDialog(f, "血量只能是数字组合");
//					tf2.grabFocus();
//					return;
//				}				
//				h.hp=Float.valueOf(hp);;
//				
//				dao.add(h);
//				
//				htm.heros=dao.list();
//				// 调用JTable的updateUI，刷新界面。
//                // 刷新界面的时候，会到tablemodel中去取最新的数据
//                // 就能看到新加进去的数据了
// 
//                t.updateUI();
//                
//                // 选中 第一行 ，因为 DAO是按照 ID倒排序查询，所以第一行就是新加入的数据     
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
        // 最后一页开始的位置
        int last;
 
        int total = new HeroDAO().getTotal();
 
        // 最后一页要看总是是否能够整除每页显示的数量number
 
        if (0 == total % number) {
            // 假设总数是20，那么最后一页开始的位置就是10
            last = total - number;
        } else {
            // 假设总数是21，那么最后一页开始的位置就是20
            last = total - total % number;
        }
        return last;
 
    }
	private static void updateButtonStatus() {
        int last = last();
 
        // 是否有上一页
        if (0 != start) {
            bFirst.setEnabled(true);
            bPre.setEnabled(true);
        }
 
        // 是否是第一页
        if (0 == start) {
            bFirst.setEnabled(false);
            bPre.setEnabled(false);
        }
 
        // 是否是最后一页
        if (start == last) {
            bLast.setEnabled(false);
            bNext.setEnabled(false);
        }
        // 是否有下一页
        if (start < last) {
            bLast.setEnabled(true);
            bNext.setEnabled(true);
        }
 
    }
	static class AddDialog extends JDialog{
		JLabel lName = new JLabel("名称");
		JLabel lHp = new JLabel("血量");
		
		JTextField tfName =new JTextField();
		JTextField tfHp =new JTextField();
		
		JButton bSubmit =new JButton("提交");
		
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
					
					if(checkEmpty(tfName, "名称")){
						if(checkNumber(tfHp, "hp")){
						
							String name = tfName.getText();
							int hp = Integer.parseInt(tfHp.getText());
							
							Hero h = new Hero();
							h.name = name;
							h.hp = hp;
							
							new HeroDAO().add(h);
							
							JOptionPane.showMessageDialog(f, "提交成功 ");
							
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
            JOptionPane.showMessageDialog(null,msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }
	private static boolean checkNumber(JTextField tf, String msg) {
		String value = tf.getText();
		if(0==value.length()){
			JOptionPane.showMessageDialog(null,msg + " 不能为空");
			tf.grabFocus();
			return false;
		}
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,msg + " 只能是整数");
			tf.grabFocus();
			return false;
		}
		
		return true;
	}
	static class EditDialog extends JDialog {
		JLabel lName = new JLabel("名称");
		JLabel lHp = new JLabel("血量");

		JTextField tfName = new JTextField();
		JTextField tfHp = new JTextField();

		JButton bSubmit = new JButton("提交");

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
					
					if(checkEmpty(tfName, "名称")){
						if(checkNumber(tfHp, "hp")){
						
							String name = tfName.getText();
							int hp = Integer.parseInt(tfHp.getText());
							
							Hero h = new Hero();
							h.name = name;
							h.hp = hp;
							
							new HeroDAO().add(h);
							
							JOptionPane.showMessageDialog(f, "提交成功 ");
							
							EditDialog.this.setVisible(false);
							updateTable();
						}
					}
					
				}
			});
		}
	}
}
