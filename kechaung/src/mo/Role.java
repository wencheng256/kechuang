package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class Role implements Sqlable{
	
	private int id;
	private String name;
	
	
	private Mysql mysql;
	
	public Role()
	{
		mysql=Mysql.getInstance();
	}

	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		String format="INSERT INTO tc_role(name) values('%s')";
		String sql=String.format(format, name);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO 自动生成的方法存根
		String format="UPDATE tc_role SET name='%s'";
		String sql=String.format(format, name);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		String format="delete from tc_role where id=%d";
		String sql=String.format(format, id);
		return mysql.execute(sql);
	}

	@Override
	public Iterator<Role> selectAll() {
		// TODO 自动生成的方法存根
		ArrayList<Role> list=new ArrayList<Role>();
		String sql="SELECT id,name from tc_role";
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Role rt=new Role();
				rt.setId(rs.getInt(1));
				rt.setName(rs.getString(2));
				list.add(rt);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}

	@Override
	public Role selectId(int id) {
		// TODO 自动生成的方法存根
		Role rt=new Role();
		String sql="SELECT id,name from tc_role where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				rt.setId(rs.getInt(1));
				rt.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rt;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return 0;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
