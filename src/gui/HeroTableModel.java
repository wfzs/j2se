package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import jdbc.Hero;
import jdbc.HeroDAO;

public class HeroTableModel extends AbstractTableModel{
	String[] columnNames = new String[] { "id", "name", "hp", "damage" };
//    String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
//            { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
	List<Hero> heros=new HeroDAO().list();
    
    //返回多少行        
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
//		return heros.length;
		return heros.size();
	}
	
	//返回多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	// 获取每一列的名称
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
 
    // 单元格是否可以修改
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
	
	//返回每一个单元格的名称
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
