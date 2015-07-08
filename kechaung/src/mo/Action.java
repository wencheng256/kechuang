package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class Action implements Sqlable{
	
	private String name;
	private int id;
	private int parent;
	private String link;
	private int is_d;
	
	private Mysql mysql;
	
	public Action()
	{
		mysql=Mysql.getInstance();
	}

	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		String format="INSERT INTO tc_action(name,parent,link,is_d) values('%s',%d,'%s',%d)";
		String sql=String.format(format,name,parent,link,is_d);
		System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO 自动生成的方法存根
		String format="UPDATE tc_action SET name='%s',parent=%d,link='%s',is_d=%d where id=%d";
		String sql=String.format(format,name,parent,link,is_d,id);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		String format="DELETE FROM tc_action where id=%d";
		String sql=String.format(format,id);
		return mysql.execute(sql);
	}

	@Override
	public Iterator<Action> selectAll() {
		// TODO 自动生成的方法存根
		String sql="SELECT id,name,parent,link,is_d from tc_action";
		ArrayList<Action> list=new ArrayList<Action>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Action ac=new Action();
				ac.setId(rs.getInt(1));
				ac.setName(rs.getString(2));
				ac.setParent(rs.getInt(3));
				ac.setLink(rs.getString(4));
				ac.setIs_d(rs.getInt(5));
				list.add(ac);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}
	public Iterator<Action> selectAlld() {
		// TODO 自动生成的方法存根
		String sql="SELECT id,name,parent,link,is_d from tc_action where is_d="+1;
		ArrayList<Action> list=new ArrayList<Action>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Action ac=new Action();
				ac.setId(rs.getInt(1));
				ac.setName(rs.getString(2));
				ac.setParent(rs.getInt(3));
				ac.setLink(rs.getString(4));
				ac.setIs_d(rs.getInt(5));
				list.add(ac);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}


	@Override
	public Action selectId(int id) {
		// TODO 自动生成的方法存根
		String sql="SELECT id,name,parent,link,is_d from tc_action where id="+id;
		Action ac=new Action();
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				ac.setId(rs.getInt(1));
				ac.setName(rs.getString(2));
				ac.setParent(rs.getInt(3));
				ac.setLink(rs.getString(4));
				ac.setIs_d(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ac;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return 0;
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
	 * @return parent
	 */
	public int getParent() {
		return parent;
	}

	/**
	 * @param parent 要设置的 parent
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}

	/**
	 * @return link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link 要设置的 link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return id_dir
	 */

	/**
	 * @return is_d
	 */
	public int getIs_d() {
		return is_d;
	}

	/**
	 * @param is_d 要设置的 is_d
	 */
	public void setIs_d(int is_d) {
		this.is_d = is_d;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Action ac=new Action();
		System.out.println(ac.selectId(2).getName());
	}

}
