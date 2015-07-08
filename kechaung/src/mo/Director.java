package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class Director implements Sqlable {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String work;
	private int project;
	private int school;
	private String schoolstring;
	
	private Mysql mysql;
	
	public Director()
	{
		mysql=Mysql.getInstance();
	}
	
	public Director(String name,String email,String phone,String work,int project,int school)
	{
		this();
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.work=work;
		this.project=project;
		this.school=school;
	}
	public Director(int id,String name,String email,String phone,String work,int project,int school)
	{
		this(name,email,phone,work,project,school);
		this.id=id;
	}

	public Director(int id) {
		// TODO 自动生成的构造函数存根
		this();
		this.project=id;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_project_director(name,email,phone,work,project,school)  values ('%s','%s','%s','%s',%d,%d)";
		String sql=String.format(format,name,email,phone,work,project,school);
		//System.out.println(sql);
		return mysql.execute(sql);
		}

	@Override
	public boolean update() {
		String format="UPDATE  tc_project_director set name='%s',email='%s',phone='%s',work='%s',project=%d,school=%d where id=%d";
		String sql=String.format(format,name,email,phone,work,project,school,id);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tc_project_director where id="+id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<Director> selectAll() {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.name,a.email,a.phone,a.work,a.project,a.school,b.name from tc_project_director as a,tc_school as b where a.school=b.id";
		ArrayList<Director> arr=new ArrayList<Director>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Director stu=new Director();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setEmail(rs.getString(3));
				stu.setPhone(rs.getString(4));
				stu.setWork(rs.getString(5));
				stu.setProject(rs.getInt(6));
				stu.setSchool(rs.getInt(7));
				stu.setSchoolstring(rs.getString(8));
				arr.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr.iterator();
	}
	
	public Iterator<Director> selectProject() {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.name,a.email,a.phone,a.work,a.project,a.school,b.name from tc_project_director as a,tc_school as b where a.school=b.id and a.project="+project+" limit 2";
		ArrayList<Director> arr=new ArrayList<Director>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Director stu=new Director();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setEmail(rs.getString(3));
				stu.setPhone(rs.getString(4));
				stu.setWork(rs.getString(5));
				stu.setProject(rs.getInt(6));
				stu.setSchool(rs.getInt(7));
				stu.setSchoolstring(rs.getString(8));
				arr.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr.iterator();
	}

	@Override
	public Director selectId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.name,a.email,a.phone,a.work,a.project,a.school,b.name from tc_project_director as a,tc_school as b where a.school=b.id AND a.id="+id;
		ResultSet rs=mysql.query(sql);
		Director stu=new Director();
		try {
			while(rs.next())
			{
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setEmail(rs.getString(3));
				stu.setPhone(rs.getString(4));
				stu.setWork(rs.getString(5));
				stu.setProject(rs.getInt(6));
				stu.setSchool(rs.getInt(7));
				stu.setSchoolstring(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM `tc_project_director`";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String degree) {
		this.work = degree;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public int getSchool() {
		return school;
	}

	public void setSchool(int school) {
		this.school = school;
	}
	

	public String getSchoolstring() {
		return schoolstring;
	}

	public void setSchoolstring(String schoolstring) {
		this.schoolstring = schoolstring;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Director stu=new Director(1,"韩文程","wencheng256@gmail.comi","18369189867"," 教师", 2,1);
		System.out.println(stu.selectAll().next().getSchoolstring());
	}

	public Iterator<Director> selecrProject() {
		// TODO 自动生成的方法存根
		String sql="SELECT a.id,a.name,a.email,a.phone,a.work,a.project,a.school,b.name from tc_project_director as a,tc_school as b where a.project=b.id and a.project="+project;
		ArrayList<Director> arr=new ArrayList<Director>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Director stu=new Director();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setEmail(rs.getString(3));
				stu.setPhone(rs.getString(4));
				stu.setWork(rs.getString(5));
				stu.setProject(rs.getInt(6));
				stu.setSchool(rs.getInt(7));
				stu.setSchoolstring(rs.getString(8));
				arr.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr.iterator();
	}

}
