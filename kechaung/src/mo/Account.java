package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.Mysql;

public class Account implements Sqlable {
	
	private int id;
	private String username;
	private String password;
	private int project;
	
	private Mysql mysql;
	
	public Account()
	{
		mysql=Mysql.getInstance();
	}
	public Account(String username,String password,int project)
	{
		this();
		this.username=username;
		this.password=password;
		this.project=project;
	}
	public Account(int id,String username,String password,int project)
	{
		this(username,password,project);
		this.id=id;
	}
	public Account(int id)
	{
		this();
		this.project=id;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_account(username,password,project) values('%s',md5('%s'),%d)";
		String sql=String.format(format, username,password,project);
		
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_account SET username='%s',password=md5('%s') ,project=%d where id=%d";
		String sql=String.format(format, username,password,project,id);
		System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE * FROM tc_account where id="+id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sqlable selectId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Account getByProject(int proj)
	{
		String sql="SELECT id,username,password,project from tc_account where project="+proj;
		Account acc=new Account();
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				acc.setId(rs.getInt(1));
				acc.setUsername(rs.getString(2));
				acc.setPassword(rs.getString(3));
				acc.setProject(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	public Account getByName(String name)
	{
		String sql="SELECT id,username,password from tc_account where username='"+name+"'";
		Account acc=new Account();
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				acc.setId(rs.getInt(1));
				acc.setUsername(rs.getString(2));
				acc.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
	public boolean verify()
	{
			String format="SELECT * FROM tc_account where username='%s' AND password=md5('%s')";
			String sql=String.format(format,username,password);
			ResultSet rs=mysql.query(sql);
			//System.out.println(sql);
			try {
				if(rs.next())
				{
					this.project=rs.getInt(4);
					return true;
				}
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Account stu=new Account(1,"wencheng","582582",1);
		System.out.println(stu.insert());
	}


}
