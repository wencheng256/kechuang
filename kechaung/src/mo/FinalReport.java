package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.Mysql;

public class FinalReport implements Sqlable{
	
	private int project;
	private String create_time;
	private String condition="";
	private String achievement="";
	private String thoughts="";
	private String expenses="";
	private int is_public=0; 
	private int is_submit=0;
	
	private Mysql mysql;
	
	public FinalReport()
	{
		mysql=Mysql.getInstance();
	}
	public FinalReport(int proj)
	{
		this();
		this.project=proj;
	}
	

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_project_final_report(project,create_time,`condition`,achievement,thoughts,expenses,is_public,is_submit) values(%d,now(),'%s','%s','%s','%s',%d,%d)";
		String sql=String.format(format,project,condition,achievement,thoughts,expenses,is_public,is_submit);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_project_final_report set create_time=now(),`condition`='%s',achievement='%s',thoughts='%s',expenses='%s',is_public=%d,is_submit=%d where project=%d";
		String sql=String.format(format,condition,achievement,thoughts,expenses,is_public,is_submit,project);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE tc_project_final_report where project="+project;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<FinalReport> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinalReport selectId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FinalReport selectProject()
	{
		String sql="SELECT project,project,Date_Format(create_time,'YY-mm-dd'),`condition`,achievement,thoughts,expenses,is_public,is_submit from  tc_project_final_report where project= "+project;
		ResultSet rs=mysql.query(sql);
		FinalReport fin=new FinalReport();
		try {
			if(rs.next())
			{
				fin.setProject(rs.getInt(2));
				fin.setCreate_time(rs.getString(3));
				fin.setCondition(rs.getString(4));
				fin.setAchievement(rs.getString(5));
				fin.setThoughts(rs.getString(6));
				fin.setExpenses(rs.getString(7));
				fin.setIs_public(rs.getInt(8));
				fin.setIs_submit(rs.getInt(9));
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

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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
		FinalReport fin=new FinalReport();
		fin.setProject(1);
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

}
