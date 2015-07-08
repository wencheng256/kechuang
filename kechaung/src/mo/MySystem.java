package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class MySystem {
	
	private int id;
	private String name;
	private String value;
	private String title;
	private static Mysql mysql=Mysql.getInstance();
	
	public MySystem()
	{
		
	}
	
	public MySystem(int id)
	{
		this.id=id;
	}
	
	public static boolean putValue(String name,String value,String title)
	{
		String format="INSERT INTO tc_system(name,`value`,`title`) values('%s','%s','%s')";
		String sql=String.format(format, name,value,title);
		return mysql.execute(sql);
	}
	public boolean update()
	{
		String format="UPDATE tc_system SET name='%s',`value`='%s',`title`='%s' where id=%d";
		String sql=String.format(format, name,value,title,id);
		System.out.println(sql);
		return mysql.execute(sql);
	}
	
	public static String getValue(String name)
	{
		String format="SELECT value from tc_system where name='"+name+"'";
		String sql=String.format(format, name);
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Iterator<MySystem> selectAll() {
		// TODO 自动生成的方法存根
		ArrayList<MySystem> list=new ArrayList<MySystem>();
		String sql="SELECT id,name,value,title from tc_system";
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				MySystem rt=new MySystem();
				rt.setId(rs.getInt(1));
				rt.setName(rs.getString(2));
				rt.setValue(rs.getString(3));
				rt.setTitle(rs.getString(4));
				list.add(rt);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}	
	
	public MySystem selectId(int id) {
		// TODO 自动生成的方法存根
		ArrayList<MySystem> list=new ArrayList<MySystem>();
		String sql="SELECT id,name,value,title from tc_system where id="+id;
		System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		MySystem rt=new MySystem();
		try {
			if(rs.next())
			{
				rt.setId(rs.getInt(1));
				rt.setName(rs.getString(2));
				rt.setValue(rs.getString(3));
				rt.setTitle(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rt;
	}	
	
	public boolean insert()
	{
		String format="INSERT INTO tc_system(name,`value`,title) values('%s','%s','%s')";
		String sql=String.format(format, name,value,title);
		return mysql.execute(sql);
	}
	public boolean delete()
	{
		String format="DELETE from tc_system where id="+id;
		System.out.println(format);
		return mysql.execute(format);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title 要设置的 title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
