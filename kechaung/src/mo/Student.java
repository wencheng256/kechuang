package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class Student implements Sqlable {
	
	private int id;
	private String num;
	private String name;
	private String email;
	private String phone;
	private short degree;
	private int project;
	private int school;
	private int is_cap;
	
	private String degreestring;
	private String schoolstring;
	
	private String[] degreemap={"本科","硕士"};
	private Mysql mysql;
	
	public Student()
	{
		mysql=Mysql.getInstance();
	}
	
	public Student(String num,String name,String email,String phone,short degree,int project,int school)
	{
		this();
		this.num=num;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.degree=degree;
		this.project=project;
		this.school=school;
	}
	public Student(int id,String num,String name,String email,String phone,short degree,int project,int school)
	{
		this(num,name,email,phone,degree,project,school);
		this.id=id;
	}

	public Student(int id) {
		// TODO 自动生成的构造函数存根
		this();
		this.project=id;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(num==null||name==null||email==null||phone==null||project==0||school==0)
		{
			return false;
		}
		String format="INSERT INTO tc_student(num,name,email,phone,degree,project,school,is_cap)  values ('%s','%s','%s','%s',%d,%d,%d,%d)";
		String sql=String.format(format, num,name,email,phone,degree,project,school,is_cap);
		//System.out.println(sql);
		return mysql.execute(sql);
		}

	@Override
	public boolean update() {
		String format="UPDATE  tc_student set num='%s',name='%s',email='%s',phone='%s',degree=%d,project=%d,school=%d,is_cap=%d where id=%d";
		String sql=String.format(format, num,name,email,phone,degree,project,school,is_cap,id);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tc_student where id="+id;
		//`
		
		System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public Iterator<Student> selectAll() {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.num,a.name,a.email,a.phone,a.degree,a.project,a.school,b.name,a.is_cap from tc_student as a,tc_school as b where a.school=b.id";
		ArrayList<Student> arr=new ArrayList<Student>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Student stu=new Student();
				stu.setId(rs.getInt(1));
				stu.setNum(rs.getString(2));
				stu.setName(rs.getString(3));
				stu.setEmail(rs.getString(4));
				stu.setPhone(rs.getString(5));
				stu.setDegree(rs.getShort(6));
				stu.setProject(rs.getInt(7));
				stu.setSchool(rs.getInt(8));
				stu.setSchoolstring(rs.getString(9));
				stu.setIs_cap(rs.getInt(10));
				stu.setDegreestring(degreemap[stu.getDegree()]);
				arr.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr.iterator();
	}

	@Override
	public Student selectId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.num,a.name,a.email,a.phone,a.degree,a.project,a.school,b.name,a.is_cap from tc_student as a,tc_school as b where a.school=b.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		Student stu=new Student();
		try {
			while(rs.next())
			{
				stu.setId(rs.getInt(1));
				stu.setNum(rs.getString(2));
				stu.setName(rs.getString(3));
				stu.setEmail(rs.getString(4));
				stu.setPhone(rs.getString(5));
				stu.setDegree(rs.getShort(6));
				stu.setProject(rs.getInt(7));
				stu.setSchool(rs.getInt(8));
				stu.setSchoolstring(rs.getString(9));
				stu.setIs_cap(rs.getInt(10));
				stu.setDegreestring(degreemap[stu.getDegree()]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	
	public Iterator<Student> selectProject() {
		// TODO 自动生成的方法存根
		String sql="SELECT a.id,a.num,a.name,a.email,a.phone,a.degree,a.project,a.school,b.name,a.is_cap from tc_student as a,tc_school as b where a.school=b.id AND a.project="+project+" limit 5";
		ArrayList<Student> arr=new ArrayList<Student>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				Student stu=new Student();
				stu.setId(rs.getInt(1));
				stu.setNum(rs.getString(2));
				stu.setName(rs.getString(3));
				stu.setEmail(rs.getString(4));
				stu.setPhone(rs.getString(5));
				stu.setDegree(rs.getShort(6));
				stu.setProject(rs.getInt(7));
				stu.setSchool(rs.getInt(8));
				stu.setSchoolstring(rs.getString(9));
				stu.setIs_cap(rs.getInt(10));
				stu.setDegreestring(degreemap[stu.getDegree()]);
				arr.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr.iterator();
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM `tc_student` where project="+project;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public short getDegree() {
		return degree;
	}

	public void setDegree(short degree) {
		this.degree = degree;
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
	/**
	 * @return degreestring
	 */
	public String getDegreestring() {
		return degreestring;
	}

	/**
	 * @param degreestring 要设置的 degreestring
	 */
	public void setDegreestring(String degreestring) {
		this.degreestring = degreestring;
	}
	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Student stu=new Student(5,"201200800502","韩文程","wencheng256@gmail.comi","18369189872",Short.parseShort("2"),2,1);
		System.out.println(stu.selectId(1).getSchoolstring());
	}

	/**
	 * @return is_cap
	 */
	public int getIs_cap() {
		return is_cap;
	}

	/**
	 * @param is_cap 要设置的 is_cap
	 */
	public void setIs_cap(int is_cap) {
		this.is_cap = is_cap;
	}
	

}
