package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.Mysql;

public class MiddleReport implements Sqlable{
	
	private int project_id;
	private String create_time;
	private String achievement="";
	private String unfinished="";
	private String plan="";
	private String problems="";
	private String expectations="";
	private String thoughts="";
	private String expenses="";
	private int is_public=0; 
	private int is_submit=0;
	
	private Mysql mysql;
	
	public MiddleReport()
	{
		mysql=Mysql.getInstance();
	}
	public MiddleReport(int proj)
	{
		this();
		this.project_id=proj;
	}
	

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_project_mid_report(project_id,create_time,achievement,unfinished,plan,problems,expectations,thoughts,expenses,is_public,is_submit) values(%d,now(),'%s','%s','%s','%s','%s','%s','%s',%d,%d)";
		String sql=String.format(format,project_id,achievement,unfinished,plan,problems,expectations,thoughts,expenses,is_public,is_submit);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_project_mid_report set create_time=now(),achievement='%s',unfinished='%s',plan='%s',problems='%s',expectations='%s',thoughts='%s',expenses='%s',is_public=%d,is_submit=%d where project_id=%d";
		String sql=String.format(format,achievement,unfinished,plan,problems,expectations,thoughts,expenses,is_public,is_submit,project_id);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE tc_project_mid_report where project_id="+project_id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<MiddleReport> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiddleReport selectId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public MiddleReport selectProject_id()
	{
		String sql="SELECT project_id,Date_Format(create_time,'YY-mm-dd'),achievement,unfinished,plan,problems,expectations,thoughts,expenses,is_public,is_submit from  tc_project_mid_report where project_id= "+project_id;
		ResultSet rs=mysql.query(sql);
		MiddleReport fin=new MiddleReport();
		try {
			if(rs.next())
			{
				fin.setProject_id(rs.getInt(1));
				fin.setCreate_time(rs.getString(2));
				fin.setAchievement(rs.getString(3));
				fin.setUnfinished(rs.getString(4));
				fin.setPlan(rs.getString(5));
				fin.setProblems(rs.getString(6));
				fin.setExpectations(rs.getString(7));
				fin.setThoughts(rs.getString(8));
				fin.setExpenses(rs.getString(9));
				fin.setIs_public(rs.getInt(10));
				fin.setIs_submit(rs.getInt(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fin;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}


	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public String getExpenses() {
		return expenses;
	}

	public void setExpenses(String expense) {
		this.expenses = expense;
	}

	public int getIs_public() {
		return is_public;
	}

	public void setIs_public(int is_public) {
		this.is_public = is_public;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MiddleReport fin=new MiddleReport();
		fin.setProject_id(1);
		fin.insert();
	}
	/**
	 * @return is_submit
	 */
	public int getIs_submit() {
		return is_submit;
	}
	/**
	 * @param is_submit 要设置的 is_submit
	 */
	public void setIs_submit(int is_submit) {
		this.is_submit = is_submit;
	}
	/**
	 * @return unfinished
	 */
	public String getUnfinished() {
		return unfinished;
	}
	/**
	 * @param unfinished 要设置的 unfinished
	 */
	public void setUnfinished(String unfinished) {
		this.unfinished = unfinished;
	}
	/**
	 * @return plan
	 */
	public String getPlan() {
		return plan;
	}
	/**
	 * @param plan 要设置的 plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}
	/**
	 * @return problems
	 */
	public String getProblems() {
		return problems;
	}
	/**
	 * @param problems 要设置的 problems
	 */
	public void setProblems(String problems) {
		this.problems = problems;
	}
	/**
	 * @return expectations
	 */
	public String getExpectations() {
		return expectations;
	}
	/**
	 * @param expectations 要设置的 expectations
	 */
	public void setExpectations(String expectations) {
		this.expectations = expectations;
	}

}
