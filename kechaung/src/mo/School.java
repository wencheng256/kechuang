package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class School implements Sqlable{

	
	private int id;						//非录入需要
	private String name;					//录入需要
	private int pronum;
	private int stunum;
	private int director;

	
	private Mysql mysql;
	
	public School()
	{
		mysql=Mysql.getInstance();
	}
	public School(String name)
	{
		this();
		this.name=name;
	}
	public School(int id,String name)
	{
		this(name);
		this.id=id;
	}
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		String sql="INSERT INTO `tc_school`(name) values('"+name+"')";
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO 自动生成的方法存根
		String sql="UPDATE `tc_school` SET name='"+name+"' where id="+id;
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		String sql="DELETE FROM tc_school where id="+id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<School> selectAll() {
		// TODO 自动生成的方法存根
		ArrayList<School> list=new ArrayList<School>();
		String sql="SELECT id,name from tc_school";
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				School school1=new School();
				school1.setId(rs.getInt(1));
				school1.setName(rs.getString(2));
				list.add(school1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}
	
	public void getdigi()
	{
//		private int pronum;
//		private int stunum;
//		private int director;
		String sql1="SELECT count(id) from tc_project where school="+id;
		setPronum(getcou(sql1));
		String sql2="SELECT count(id) from tc_student where school="+id;
		setStunum(getcou(sql2));
		String sql3="SELECT count(id) from tc_project_director where school="+id;
		setDirector(getcou(sql3));
	}
	
	private int getcou(String sql)
	{
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public School selectId(int id) {
		// TODO 自动生成的方法存根
		String sql="SELECT id,name from tc_school where id="+id;
		ResultSet rs=mysql.query(sql);
		School school1=new School();
		try {
			if(rs.next())
			{
				school1.setId(rs.getInt(1));
				school1.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return school1;
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
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		String sql="SELECT count(*) FROM `tc_school`";
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		School test=new School(1,"机电与信息工程学院");
		System.out.println(test.insert());
	}
	/**
	 * @return pronum
	 */
	public int getPronum() {
		return pronum;
	}
	/**
	 * @param pronum 要设置的 pronum
	 */
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	/**
	 * @return stunum
	 */
	public int getStunum() {
		return stunum;
	}
	/**
	 * @param stunum 要设置的 stunum
	 */
	public void setStunum(int stunum) {
		this.stunum = stunum;
	}
	/**
	 * @return director
	 */
	public int getDirector() {
		return director;
	}
	/**
	 * @param director 要设置的 director
	 */
	public void setDirector(int director) {
		this.director = director;
	}
}
