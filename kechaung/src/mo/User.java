package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import com.Mysql;

public class User implements Sqlable{
	
	private int id;
	private String name;
	private String username;
	private String password;
	private String superpass;
	private int school;
	private int role;
	
	
	private int pronum;
	private int stunum;
	private double feenum;
	private int proapp;
	private int promid;
	private int proend;
	private int proendnum;
	private int projou;
	private int proranked;
	private int unjou;
	private int unrank;
	
	private String schoolstring;
	private String rolestring;
	private News news;
	
	private RoleAction roleaction;
	
	private Mysql mysql;
	
	public User()
	{
		mysql=Mysql.getInstance();
	}
	public User(int id)
	{
		this.id=id;
		mysql=Mysql.getInstance();
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_user(`name`,password,superpass,username,school,role) values('%s',md5('%s'),md5('%s'),'%s',%d,%d)";
		String sql=String.format(format, name,password,superpass,username,school,role);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_user set name='%s',password=md5('%s'),superpass=md5('%s'),username='%s',school=%d ,role=%d where id=%d ";
		String sql=String.format(format, name,password,superpass,username,school,role,id);
//		System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE from tc_user where id="+id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<User> selectAll() {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.name,a.password,a.superpass,a.school,b.name,c.name,a.username FROM tc_user as a,tc_role as b,tc_school as c where a.role=b.id and a.school=c.id";
		ResultSet rs=mysql.query(sql);
		LinkedList<User> list=new LinkedList<User>();
		try {
			while(rs.next())
			{
				User us=new User();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setPassword(rs.getString(3));
				us.setSuperpass(rs.getString(4));
				us.setSchool(rs.getInt(5));
				us.setSchoolstring(rs.getString(6));
				us.setRolestring(rs.getString(7));
				us.setUsername(rs.getString(8));
				us.setNews(new News(this.getId()));
				list.add(us);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.iterator();
	}

	@Override
	public User selectId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.name,a.password,a.superpass,a.school,b.name,c.name,a.username,a.role FROM tc_user as a,tc_role as b,tc_school as c where a.role=b.id and a.school=c.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		User us=new User();
		try {
			if(rs.next())
			{
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setPassword(rs.getString(3));
				us.setSuperpass(rs.getString(4));
				us.setSchool(rs.getInt(5));
				us.setSchoolstring(rs.getString(6));
				us.setRolestring(rs.getString(7));
				us.setUsername(rs.getString(8));
				us.setNews(new News(this.getId()));
				us.setRole(rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}
	
	public boolean verify()
	{
			String format="SELECT a.id,a.name,a.password,a.superpass,a.school,b.name,c.name,a.username,a.role FROM tc_user as a,tc_role as b,tc_school as c where a.role=b.id and a.school=c.id and  a.username='%s' AND a.password=md5('%s')";
			String sql=String.format(format,username,password);
			ResultSet rs=mysql.query(sql);
			//System.out.println(sql);
			try {
				if(rs.next())
				{
					this.setId(rs.getInt(1));
					this.setName(rs.getString(2));
					this.setPassword(rs.getString(3));
					this.setSuperpass(rs.getString(4));
					this.setSchool(rs.getInt(5));
					this.setSchoolstring(rs.getString(6));
					this.setRolestring(rs.getString(7));
					this.setUsername(rs.getString(8));
					this.setNews(new News(this.getId()));
					this.setRole(rs.getInt(9));
					return true;
				}
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
	public void getdigi()
	{
//		private int pronum;
//		private int stunum;
//		private int feenum;
//		private int proapp;
//		private int promid;
//		private int proend;
//		private int proendnum;
//		private int projou;
//		private int proranked;
		String sql1="SELECT count(id) from tc_project";
		setPronum(getcou(sql1));
		String sql2="SELECT count(id) from tc_student";
		setStunum(getcou(sql2));
		String sql3="SELECT sum(amount) from tc_project_fare";
		setFeenum(getcoud(sql3));
		String sql4="SELECT count(project_id) from tc_project_application ";
		setProapp(getcou(sql4));
		String sql5="SELECT count(project_id) from tc_project_mid_report where is_submit=1";
		setPromid(getcou(sql5));
		String sql6="SELECT count(project) from tc_project_final_report where is_submit=1";
		setPromid(getcou(sql6));
		String sql7="SELECT count(project) from tc_project_final_report where is_submit=1";
		setProend(getcou(sql7));
		String sql8="SELECT count(id) from tc_project where end=1";
		setProendnum(getcou(sql8));
		String sql9="SELECT count(id) from tc_project_journal";
		setProjou(getcou(sql9));
		String sql10="SELECT count(id) from tc_project where rank!=0";
		setProranked(getcou(sql10));
		String sql11="SELECT count(id) from tc_project where rank=0";
		setUnrank(getcou(sql11));
		String sql12="SELECT count(id) from tc_project_journal where status=1";
		setUnjou(getcou(sql12));
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
	private double getcoud(String sql)
	{
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperpass() {
		return superpass;
	}

	public void setSuperpass(String superpass) {
		this.superpass = superpass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSchool() {
		return school;
	}

	public void setSchool(int school) {
		this.school = school;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getSchoolstring() {
		return schoolstring;
	}

	public void setSchoolstring(String schoolstring) {
		this.schoolstring = schoolstring;
	}

	public String getRolestring() {
		return rolestring;
	}

	public void setRolestring(String rolrstring) {
		this.rolestring = rolrstring;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		User us=new User();
		us.setId(1);
		us.setName("总管理员");
		us.setPassword("999900");
		us.setRole(1);
		us.setSchool(1);
		us.setUsername("wencheng");
		us.setSuperpass("582582");
		us.insert();
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
	 * @return news
	 */
	public News getNews() {
		return news;
	}

	/**
	 * @param news 要设置的 news
	 */
	public void setNews(News news) {
		this.news = news;
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
	 * @return feenum
	 */
	public double getFeenum() {
		return feenum;
	}
	/**
	 * @param feenum 要设置的 feenum
	 */
	public void setFeenum(double feenum) {
		this.feenum = feenum;
	}
	/**
	 * @return proapp
	 */
	public int getProapp() {
		return proapp;
	}
	/**
	 * @param proapp 要设置的 proapp
	 */
	public void setProapp(int proapp) {
		this.proapp = proapp;
	}
	/**
	 * @return promid
	 */
	public int getPromid() {
		return promid;
	}
	/**
	 * @param promid 要设置的 promid
	 */
	public void setPromid(int promid) {
		this.promid = promid;
	}
	/**
	 * @return proend
	 */
	public int getProend() {
		return proend;
	}
	/**
	 * @param proend 要设置的 proend
	 */
	public void setProend(int proend) {
		this.proend = proend;
	}
	/**
	 * @return proendnum
	 */
	public int getProendnum() {
		return proendnum;
	}
	/**
	 * @param proendnum 要设置的 proendnum
	 */
	public void setProendnum(int proendnum) {
		this.proendnum = proendnum;
	}
	/**
	 * @return projou
	 */
	public int getProjou() {
		return projou;
	}
	/**
	 * @param projou 要设置的 projou
	 */
	public void setProjou(int projou) {
		this.projou = projou;
	}
	/**
	 * @return proranked
	 */
	public int getProranked() {
		return proranked;
	}
	/**
	 * @param proranked 要设置的 proranked
	 */
	public void setProranked(int proranked) {
		this.proranked = proranked;
	}
	/**
	 * @return unjou
	 */
	public int getUnjou() {
		return unjou;
	}
	/**
	 * @param unjou 要设置的 unjou
	 */
	public void setUnjou(int unjou) {
		this.unjou = unjou;
	}
	/**
	 * @return unrank
	 */
	public int getUnrank() {
		return unrank;
	}
	/**
	 * @param unrank 要设置的 unrank
	 */
	public void setUnrank(int unrank) {
		this.unrank = unrank;
	}

}
