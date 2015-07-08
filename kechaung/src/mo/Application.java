package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class Application implements Sqlable {
	
	private int id;
	private int is_public=0;						//0私有 1公开
	private String situation="";					//研究现状
	private String innovation="";				//需要解决的关键性问题和创新点
	private String feasibility="";					//项目研究可行性分析
	private String reference="";					//参考文献
	private String research_context="";		//研究内容
	private String research_method="";		//研究方法
	private String schedule="";					//研究时间表
	private String achievement_modus="";	//预期研究成果和展现形势
	private String equipment="";				//装备设备
	private String come_from="";				//项目来源
	private String summary="";					//项目概要
	private String base="";							//研究基础

	private Mysql mysql;
	
	public Application()
	{
		mysql=Mysql.getInstance();
	}
	public Application(int is_public, String situation,String innovation,String feasibility,String reference,String research_context,String research_method,String schedule,String come_from,String summary,String base)
	{
		this();
		this.is_public=is_public;
		this.situation=situation;
		this.innovation=innovation;
		this.feasibility=feasibility;
		this.reference=reference;
		this.research_context=research_context;
		this.research_method=research_method;
		this.schedule=schedule;
		this.come_from=come_from;
		this.summary=summary;
		this.base=base;
	}
	public Application(int id,int is_public, String situation,String innovation,String feasibility,String reference,String research_context,String research_method,String schedule,String come_from,String summary,String base,String equipment,String achievement_modus)
	{
		this();
		this.is_public=is_public;
		this.situation=situation;
		this.innovation=innovation;
		this.feasibility=feasibility;
		this.reference=reference;
		this.research_context=research_context;
		this.research_method=research_method;
		this.schedule=schedule;
		this.come_from=come_from;
		this.summary=summary;
		this.base=base;
		this.id=id;
		this.equipment=equipment;
		this.achievement_modus=achievement_modus;
	}
	
	public Application(int id) {
		// TODO 自动生成的构造函数存根
		this();
		this.id=id;
	}
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_project_application(project_id,is_public,situation,innovation,feasibility,reference,research_context,research_method,schedule,achievement_modus,equipment,come_from,summary,base) VALUES (%d,%d,'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
		String sql=String.format(format,id,is_public,situation,innovation,feasibility,reference,research_context,research_method,schedule,achievement_modus,equipment,come_from,summary,base);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_project_application SET is_public=%d,situation='%s',innovation='%s',feasibility='%s',reference='%s',research_context='%s',research_method='%s',schedule='%s',achievement_modus='%s',equipment='%s',come_from='%s',summary='%s',base='%s' where project_id=%d";
		String sql=String.format(format,is_public,situation,innovation,feasibility,reference,research_context,research_method,schedule,achievement_modus,equipment,come_from,summary,base,id);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		String sql="DELETE * FROM tc_project_application where id="+id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<Application> selectAll() {
		// TODO Auto-generated method stub
		String sql="SELECT project_id,is_public,situation,innovation,feasibility,reference,research_context,research_method,schedule,achievement_modus,equipment,come_from,summary,base from tc_project_application";
		ResultSet rs=mysql.query(sql);
		ArrayList<Application> list=new ArrayList<Application>();
		try {
			while(rs.next())
			{
				Application app=new Application();
				app.setId(rs.getInt(1));
				app.setIs_public(rs.getInt(2));
				app.setSituation(rs.getString(3));
				app.setInnovation(rs.getString(4));
				app.setFeasibility(rs.getString(5));
				app.setReference(rs.getString(6));
				app.setResearch_context(rs.getString(7));
				app.setResearch_method(rs.getString(8));
				app.setSchedule(rs.getString(9));
				app.setAchievement_modus(rs.getString(10));
				app.setEquipment(rs.getString(11));
				app.setCome_from(rs.getString(12));
				app.setSummary(rs.getString(13));
				app.setBase(rs.getString(14));
				
				list.add(app);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.iterator();
	}

	@Override
	public Application selectId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT project_id,is_public,situation,innovation,feasibility,reference,research_context,research_method,schedule,achievement_modus,equipment,come_from,summary,base from tc_project_application where project_id="+id;
		ResultSet rs=mysql.query(sql);
		Application app=new Application();
		try {
			if(rs.next())
			{
				app.setId(rs.getInt(1));
				app.setIs_public(rs.getInt(2));
				app.setSituation(rs.getString(3));
				app.setInnovation(rs.getString(4));
				app.setFeasibility(rs.getString(5));
				app.setReference(rs.getString(6));
				app.setResearch_context(rs.getString(7));
				app.setResearch_method(rs.getString(8));
				app.setSchedule(rs.getString(9));
				app.setAchievement_modus(rs.getString(10));
				app.setEquipment(rs.getString(11));
				app.setCome_from(rs.getString(12));
				app.setSummary(rs.getString(13));
				app.setBase(rs.getString(14));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return app;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIs_public() {
		return is_public;
	}

	public void setIs_public(int is_public) {
		this.is_public = is_public;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getInnovation() {
		return innovation;
	}

	public void setInnovation(String innovation) {
		this.innovation = innovation;
	}

	public String getFeasibility() {
		return feasibility;
	}

	public void setFeasibility(String feasibility) {
		this.feasibility = feasibility;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getResearch_context() {
		return research_context;
	}

	public void setResearch_context(String research_context) {
		this.research_context = research_context;
	}

	public String getResearch_method() {
		return research_method;
	}

	public void setResearch_method(String research_method) {
		this.research_method = research_method;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getAchievement_modus() {
		return achievement_modus;
	}

	public void setAchievement_modus(String achievement_modus) {
		this.achievement_modus = achievement_modus;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getCome_from() {
		return come_from;
	}

	public void setCome_from(String come_from) {
		this.come_from = come_from;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Application stu=new Application(1);
		System.out.println(stu.insert());
	}

}
