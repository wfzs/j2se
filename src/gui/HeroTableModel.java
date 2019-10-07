package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import jdbc.Hero;
import jdbc.HeroDAO;

public class HeroTableModel extends AbstractTableModel{
	String[] columnNames = new String[] { "id", "name", "hp", "damage" };
//    String[][] heros = new String[][] { { "1", "����", "616", "100" },
//            { "2", "��Ī", "512", "102" }, { "3", "����", "832", "200" } };
	List<Hero> heros=new HeroDAO().list();
    
    //���ض�����        
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
//		return heros.length;
		return heros.size();
	}
	
	//���ض�����
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	// ��ȡÿһ�е�����
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
 
    // ��Ԫ���Ƿ�����޸�
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
	
	//����ÿһ����Ԫ�������
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Hero h=heros.get(rowIndex);
		if(columnIndex==0)
			return h.id;
		if(columnIndex==1)
			return h.name;
		if(columnIndex==2)
			return h.hp;
		if(columnIndex==3)
			return h.damage;
		return null;
	}

}
