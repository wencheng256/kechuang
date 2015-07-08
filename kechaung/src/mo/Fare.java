package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class Fare implements Sqlable{
	private int id;
	private String reason;
	private double amount;
	private int project;
	private String perstring;
	
	private Mysql mysql;
	private int num; 
	
	private String projectstring;

	public Fare()
	{
		mysql=Mysql.getInstance();
	}
	public Fare(String reason,double amount,int project)
	{
		this();
		this.reason=reason;
		this.amount=amount;
		this.project=project;
	}
	
	public Fare(int id,String reason,double amount,int project)
	{
		this(reason,amount,project);
		this.id=id;
	}
	
	
	public Fare(int id) {
		// TODO 自动生成的构造函数存根
		this();
		this.project=id;
	}
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_project_fare(reason,amount,project) values('%s',%f,%d)";
		String sql=String.format(format, reason,amount,project);
		return mysql.execute(sql);
	}
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_project_fare SET reason='%s',amount=%f,project=%d";
		String sql=String.format(format, reason,amount,project,id);
		return mysql.execute(sql);
	}
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE  FROM tc_project_fare where id="+id;
		return mysql.execute(sql);
	}
	@Override
	public Iterator<Fare> selectAll() {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.reason,a.amount,a.project,b.name,b.proj_permitid from tc_project_fare as a,tc_project as b where a.project=b.id order by b.proj_permitid";
		ResultSet rs=mysql.query(sql);
		ArrayList<Fare> list=new ArrayList<Fare>();
		try {
			while(rs.next())
			{
				Fare f1=new Fare();
				f1.setId(rs.getInt(1));
				f1.setReason(rs.getString(2));
				f1.setAmount(rs.getDouble(3));
				f1.setProject(rs.getInt(4));
				f1.setProjectstring(rs.getString(5));
				f1.setPerstring(rs.getString(6));
				
				list.add(f1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num=list.size();
		return list.iterator();
	}
	public Iterator<Fare> selectProj(int proj) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.reason,a.amount,a.project,b.name from tc_project_fare as a,tc_project as b where a.project=b.id and a.project="+project;
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		ArrayList<Fare> list=new ArrayList<Fare>();
		try {
			while(rs.next())
			{
				Fare f1=new Fare();
				f1.setId(rs.getInt(1));
				f1.setReason(rs.getString(2));
				f1.setAmount(rs.getDouble(3));
				f1.setProject(rs.getInt(4));
				f1.setProjectstring(rs.getString(5));
				
				list.add(f1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num=list.size();
		return list.iterator();
	}
	@Override
	public Fare selectId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.reason,a.amount,a.project b.name from tc_project_fare as a,tc_project as b where a.project=b.id AND id="+id;
		ResultSet rs=mysql.query(sql);
		Fare f1=new Fare();
		try {
			if(rs.next())
			{
				f1.setId(rs.getInt(1));
				f1.setReason(rs.getString(2));
				f1.setAmount(rs.getDouble(3));
				f1.setProject(rs.getInt(4));
				f1.setProjectstring(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f1;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM `tc_project_fare`";
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
	
	
	public double getProjectFare()
	{
		String sql="SELECT sum(amount) FROM `tc_project_fare` where project="+project;
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
	public double getFare()
	{
		String sql="SELECT sum(amount) FROM `tc_project_fare` ";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}
	public String getProjectstring() {
		return projectstring;
	}
	public void setProjectstring(String projectstring) {
		this.projectstring = projectstring;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPerstring() {
		return perstring;
	}
	public void setPerstring(String perstring) {
		this.perstring = perstring;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Fare stu=new Fare(1,"购买设备2",1000,1);
		System.out.println(stu.selectProj(1).next().getProjectstring());
	}
}
