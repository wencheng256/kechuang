package mo;

import java.util.Iterator;

public interface Sqlable {
	
	public boolean insert();
	public boolean update();
	public boolean delete();
	public Iterator selectAll();
	public Sqlable selectId(int id);
	public int getCount();
}
