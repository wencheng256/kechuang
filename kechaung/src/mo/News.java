package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class News implements Sqlable {

	private int id;
	private String date;					//自动生成
	private String  title;
	private int user;
	private String content;
	private String username;
	private int type;
	
	private Mysql mysql;
	
	public News()
	{
		mysql=Mysql.getInstance();
	}
	
	
	public News(int id) {
		// TODO 自动生成的构造函数存根
		this();
		this.user=id;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_news(title,writer,date,type,content) values('%s',%d,now(),%d,'%s')";
		String sql=String.format(format, title,user,type,content);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_news SET title='%s',writer=%d,date=now(),type=%d,content='%s' where id=%d";
		String sql=String.format(format, title,user,type,content,id);
		System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		String sql="DELETE FROM tc_news where id="+id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<News> selectAll() {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.writer,DATE_FORMAT(a.date,'%Y-%m-%d'),a.type,a.content,b.name from tc_news as a , tc_user as b where a.writer=b.id";
		ArrayList<News> list=new ArrayList<News>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				News n=new News();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setUser(rs.getInt(3));
				n.setDate(rs.getString(4));
				n.setType(rs.getShort(5));
				n.setContent(rs.getString(6));
				n.setUsername(rs.getString(7));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	
	public Iterator<News> selectSchool(int school) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.writer,DATE_FORMAT(a.date,'%Y-%m-%d'),a.type,a.content,b.name from tc_news as a , tc_user as b where a.writer=b.id and b.school in (0,"+school+")";
		//System.out.println(sql);
		ArrayList<News> list=new ArrayList<News>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				News n=new News();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setUser(rs.getInt(3));
				n.setDate(rs.getString(4));
				n.setType(rs.getShort(5));
				n.setContent(rs.getString(6));
				n.setUsername(rs.getString(7));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	
	public Iterator<News> selectSchool1(int school) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.writer,DATE_FORMAT(a.date,'%Y-%m-%d'),a.type,a.content,b.name from tc_news as a , tc_user as b where a.writer=b.id and b.school = "+school+"";
		//System.out.println(sql);
		ArrayList<News> list=new ArrayList<News>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				News n=new News();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setUser(rs.getInt(3));
				n.setDate(rs.getString(4));
				n.setType(rs.getShort(5));
				n.setContent(rs.getString(6));
				n.setUsername(rs.getString(7));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	
	
	public Iterator<News> selectUser(int a,int b) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.writer,DATE_FORMAT(a.date,'%Y-%m-%d'),a.type,a.content,b.name from tc_news as a , tc_user as b where a.writer="+user+" and a.writer=b.id limit "+a+", "+b;
		//System.out.println(sql);
		ArrayList<News> list=new ArrayList<News>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				News n=new News();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setUser(rs.getInt(3));
				n.setDate(rs.getString(4));
				n.setType(rs.getShort(5));
				n.setContent(rs.getString(6));
				n.setUsername(rs.getString(7));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	
	@Override
	public News selectId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.writer,DATE_FORMAT(a.date,'%Y-%m-%d'),a.type,a.content,b.name from tc_news as a , tc_user as b where a.writer=b.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		News n=new News();
		try {
			if(rs.next())
			{
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setUser(rs.getInt(3));
				n.setDate(rs.getString(4));
				n.setType(rs.getShort(5));
				n.setContent(rs.getString(6));
				n.setUsername(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM `tc_news` where user="+user;
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
	public int getCountAll() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM `tc_news`";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date 要设置的 date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return user
	 */
	public int getUser() {
		return user;
	}

	/**
	 * @param user 要设置的 user
	 */
	public void setUser(int user) {
		this.user = user;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username 要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type 要设置的 type
	 */
	public void setType(int type) {
		this.type = type;
	}

	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		News n=new News();
		n.setContent("hello1");
		n.setId(1);
		n.setUser(1);
		n.setTitle("world");
		n.setType(0);
		n.update();
	}


}
