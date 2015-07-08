package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class Project implements Sqlable {

	private int id;							//非录入需要
	private int grade;							//录入需要,自动生成
	private short important=0;					//非录入需要
	private String name;						//录入需要
	private short classes;						//录入需要
	private String proj_permitid;				//录入需要
	private int school;						//录入需要
	private String applytime;					//录入需要，自动生成
	private int progress;						//非录入需要
	private short rank;						//非录入需要
	private short status;						//非录入需要
	private String finish_time;					//非录入需要
	private int warning;						//非录入需要
	private int end;
	private int is_ranked;
	
	private Account account;
	private Application application;
	private Director director;
	private Student student;
	private ProjectJournal journal;
	private Fare fare;
	private Message message;
	private FinalReport finalreport;
	private MiddleReport middlereport;
	
	private String[] classmap={"未识别类型","A","B","C","D"};
	private String[] statusmap={"未识别状态","终止","停滞","迟缓","顺利","超前"};
	
	private String classstring;
	private String statusstring;
	
	private String schoolstring;
	private Mysql mysql;
	
	public Project()
	{
		mysql=Mysql.getInstance();
	}
	
	public Project(String name,short classes,int school,String proj_permitid)
	{
		this();
		this.name=name;
		this.classes=classes;
		this.school=school;
		this.proj_permitid=proj_permitid;
	}
	
	public Project(int id,String name,short classes,int school,String proj_permitid)
	{
		this(name,classes,school,proj_permitid);
		this.id=id;
	}
	
	
	
	public Project(int project) {
		// TODO 自动生成的构造函数存根
		this();
		this.id=project;
	}

	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		String format="INSERT INTO tc_project(grade,name,class,proj_permitid,school,apply_time,progress) VALUES( %d,'%s',%d,'%s',%d,now(),0)";
		String sql=String.format(format, grade,name,classes,proj_permitid,school);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO 自动生成的方法存根
		String format="UPDATE tc_project SET end=%d,progress=%d ,status=%d,important=%d where id=%d";
		String sql=String.format(format, end,progress,status,important,id);
		//System.out.println(sql);
		return mysql.execute(sql);
	}
	public boolean check() {
		// TODO 自动生成的方法存根
		String format="UPDATE tc_project SET rank=%d where id=%d";
		String sql=String.format(format,rank,id);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		String sql="DELETE FROM tc_project where id="+id;
		return mysql.execute(sql);
	}


	public Iterator<Project> selectAll(int start,int num) {
		// TODO 自动生成的方法存根
		String sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where a.school=b.id limit "+start+","+num;
		ResultSet rs=mysql.query(sql);
		ArrayList<Project> list=new ArrayList<Project>();
		try {
			while(rs.next())
			{
				Project proj=new Project();
				proj.setId(rs.getInt(1));
				proj.setGrade(rs.getInt(2));
				proj.setImportant(rs.getShort(3));
				proj.setName(rs.getString(4));
				proj.setClasses(rs.getShort(5));
				proj.setProj_permitid(rs.getString(6));
				proj.setSchool(rs.getInt(7));
				proj.setApplytime(rs.getString(8));
				proj.setProgress(rs.getInt(9));
				proj.setRank(rs.getShort(10));
				proj.setStatus(rs.getShort(11));
				proj.setWarning(rs.getInt(12));
				proj.setEnd(rs.getInt(14));
				proj.setIs_ranked(rs.getInt(15));
				proj.setClassstring(classmap[proj.getClasses()]);
				proj.setStatusstring(statusmap[proj.getStatus()]);
				proj.setSchoolstring(rs.getString(13));
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}
	
	
	public Iterator<Project> selectGrade(int start,int num,int school) {
		// TODO 自动生成的方法存根
		String grades=MySystem.getValue("grade");
		String sql;
		if(school==0){
			sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where a.school=b.id and a.grade='"+grades+"' limit "+start+","+num;
		}else
		{
			sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where a.school=b.id and a.school="+school+" and a.grade='"+grades+"' limit "+start+","+num;
		}
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		ArrayList<Project> list=new ArrayList<Project>();
		try {
			while(rs.next())
			{
				Project proj=new Project();
				proj.setId(rs.getInt(1));
				proj.setGrade(rs.getInt(2));
				proj.setImportant(rs.getShort(3));
				proj.setName(rs.getString(4));
				proj.setClasses(rs.getShort(5));
				proj.setProj_permitid(rs.getString(6));
				proj.setSchool(rs.getInt(7));
				proj.setApplytime(rs.getString(8));
				proj.setProgress(rs.getInt(9));
				proj.setRank(rs.getShort(10));
				proj.setStatus(rs.getShort(11));
				proj.setWarning(rs.getInt(12));
				proj.setEnd(rs.getInt(14));
				proj.setIs_ranked(rs.getInt(15));
				proj.setClassstring(classmap[proj.getClasses()]);
				proj.setStatusstring(statusmap[proj.getStatus()]);
				proj.setSchoolstring(rs.getString(13));
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}
	
	public Iterator<Project> selectSchool(int start,int num,int school) {
		// TODO 自动生成的方法存根
		String grades=MySystem.getValue("grade");
		String sql;
		if(school!=0){
		sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where a.school="+school+" and a.school=b.id and a.grade='"+grades+"' limit "+start+","+num;
		}else
		{
		sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where  a.school=b.id and a.grade='"+grades+"' limit "+start+","+num;
		}
		ResultSet rs=mysql.query(sql);
		//System.out.println(sql);
		ArrayList<Project> list=new ArrayList<Project>();
		try {
			while(rs.next())
			{
				Project proj=new Project();
				proj.setId(rs.getInt(1));
				proj.setGrade(rs.getInt(2));
				proj.setImportant(rs.getShort(3));
				proj.setName(rs.getString(4));
				proj.setClasses(rs.getShort(5));
				proj.setProj_permitid(rs.getString(6));
				proj.setSchool(rs.getInt(7));
				proj.setApplytime(rs.getString(8));
				proj.setProgress(rs.getInt(9));
				proj.setRank(rs.getShort(10));
				proj.setStatus(rs.getShort(11));
				proj.setWarning(rs.getInt(12));
				proj.setEnd(rs.getInt(14));
				proj.setIs_ranked(rs.getInt(15));
				proj.setClassstring(classmap[proj.getClasses()]);
				proj.setStatusstring(statusmap[proj.getStatus()]);
				proj.setSchoolstring(rs.getString(13));
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}

	@Override
	public Project selectId(int id) {
		// TODO 自动生成的方法存根
		String sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where a.school=b.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		Project proj=new Project();
		try {
			if(rs.next())
			{
				proj.setId(rs.getInt(1));
				proj.setGrade(rs.getInt(2));
				proj.setImportant(rs.getShort(3));
				proj.setName(rs.getString(4));
				proj.setClasses(rs.getShort(5));
				proj.setProj_permitid(rs.getString(6));
				proj.setSchool(rs.getInt(7));
				proj.setApplytime(rs.getString(8));
				proj.setProgress(rs.getInt(9));
				proj.setRank(rs.getShort(10));
				proj.setStatus(rs.getShort(11));
				proj.setWarning(rs.getInt(12));
				proj.setSchoolstring(rs.getString(13));
				proj.setEnd(rs.getInt(14));
				proj.setIs_ranked(rs.getInt(15));
				proj.setClassstring(classmap[proj.getClasses()]);
				proj.setStatusstring(statusmap[proj.getStatus()]);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return proj;
	}
	public boolean getIf() {
		// TODO 自动生成的方法存根
		String sql="SELECT * FROM tc_project where name='"+name+"' and proj_permitid='"+proj_permitid+"'";
		System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	

	public Project selectName(String name) {
		// TODO 自动生成的方法存根
		String sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where a.school=b.id and a.name='"+name+"'";
		ResultSet rs=mysql.query(sql);
		Project proj=new Project();
		try {
			if(rs.next())
			{
				proj.setId(rs.getInt(1));
				proj.setGrade(rs.getInt(2));
				proj.setImportant(rs.getShort(3));
				proj.setName(rs.getString(4));
				proj.setClasses(rs.getShort(5));
				proj.setProj_permitid(rs.getString(6));
				proj.setSchool(rs.getInt(7));
				proj.setApplytime(rs.getString(8));
				proj.setProgress(rs.getInt(9));
				proj.setRank(rs.getShort(10));
				proj.setStatus(rs.getShort(11));
				proj.setWarning(rs.getInt(12));
				proj.setSchoolstring(rs.getString(13));
				proj.setEnd(rs.getInt(14));
				proj.setIs_ranked(rs.getInt(15));
				proj.setClassstring(classmap[proj.getClasses()]);
				proj.setStatusstring(statusmap[proj.getStatus()]);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return proj;
	}
	public Project getByNum(String name) {
		// TODO 自动生成的方法存根
		String sql="SELECT a.id,a.grade,a.important,a.name,a.class, a.proj_permitid,a.school,a.apply_time,a.progress,a.rank,a.status,a.warnning,b.name,a.end,a.is_ranked FROM tc_project as a,tc_school as b where a.school=b.id and a.proj_permitid='"+proj_permitid+"'";
		ResultSet rs=mysql.query(sql);
		Project proj=new Project();
		try {
			if(rs.next())
			{
				proj.setId(rs.getInt(1));
				proj.setGrade(rs.getInt(2));
				proj.setImportant(rs.getShort(3));
				proj.setName(rs.getString(4));
				proj.setClasses(rs.getShort(5));
				proj.setProj_permitid(rs.getString(6));
				proj.setSchool(rs.getInt(7));
				proj.setApplytime(rs.getString(8));
				proj.setProgress(rs.getInt(9));
				proj.setRank(rs.getShort(10));
				proj.setStatus(rs.getShort(11));
				proj.setWarning(rs.getInt(12));
				proj.setSchoolstring(rs.getString(13));
				proj.setEnd(rs.getInt(14));
				proj.setIs_ranked(rs.getInt(15));
				proj.setClassstring(classmap[proj.getClasses()]);
				proj.setStatusstring(statusmap[proj.getStatus()]);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return proj;
	}
	
	
	public boolean endProject()
	{
		Project pt=this.selectId(id);
		pt.setEnd(1);
		return pt.update();
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
	 * @return grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade 要设置的 grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @return important
	 */
	public short getImportant() {
		return important;
	}

	/**
	 * @param important 要设置的 important
	 */
	public void setImportant(short important) {
		this.important = important;
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

	/**
	 * @return classes
	 */
	public short getClasses() {
		return classes;
	}

	/**
	 * @param classes 要设置的 classes
	 */
	public void setClasses(short classes) {
		this.classes = classes;
	}

	/**
	 * @return proj_permitid
	 */
	public String getProj_permitid() {
		return proj_permitid;
	}

	/**
	 * @param proj_permitid 要设置的 proj_permitid
	 */
	public void setProj_permitid(String proj_permitid) {
		this.proj_permitid = proj_permitid;
	}

	/**
	 * @return school
	 */
	public int getSchool() {
		return school;
	}

	/**
	 * @param school 要设置的 school
	 */
	public void setSchool(int school) {
		this.school = school;
	}

	/**
	 * @return applytime
	 */
	public String getApplytime() {
		return applytime;
	}

	/**
	 * @param applytime 要设置的 applytime
	 */
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}

	/**
	 * @return progress
	 */
	public int getProgress() {
		return progress;
	}

	/**
	 * @param progress 要设置的 progress
	 */
	public void setProgress(int progress) {
		this.progress = progress;
	}

	/**
	 * @return rank
	 */
	public short getRank() {
		return rank;
	}

	/**
	 * @param rank 要设置的 rank
	 */
	public void setRank(short rank) {
		this.rank = rank;
	}

	/**
	 * @return status
	 */
	public short getStatus() {
		return status;
	}

	/**
	 * @param status 要设置的 status
	 */
	public void setStatus(short status) {
		this.status = status;
	}

	/**
	 * @return finish_time
	 */
	public String getFinish_time() {
		return finish_time;
	}

	/**
	 * @param finish_time 要设置的 finish_time
	 */
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}

	/**
	 * @return warning
	 */
	public int getWarning() {
		return warning;
	}

	/**
	 * @param warning 要设置的 warning
	 */
	public void setWarning(int warning) {
		this.warning = warning;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		String sql="SELECT count(*) from tc_project";
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @return classstring
	 */
	public String getClassstring() {
		return classstring;
	}

	/**
	 * @param classstring 要设置的 classstring
	 */
	public void setClassstring(String classstring) {
		this.classstring = classstring;
	}

	/**
	 * @return statusstring
	 */
	public String getStatusstring() {
		return statusstring;
	}

	/**
	 * @param statusstring 要设置的 statusstring
	 */
	public void setStatusstring(String statusstring) {
		this.statusstring = statusstring;
	}
	
	public boolean truncate()
	{
		String sql="TRUNCATE table tc_project";
		return mysql.execute(sql);
	}

	/**
	 * @return schoolstring
	 */
	public String getSchoolstring() {
		return schoolstring;
	}

	/**
	 * @param schoolstring 要设置的 schoolstring
	 */
	public void setSchoolstring(String schoolstring) {
		this.schoolstring = schoolstring;
	}
	
	public void addDetial()
	{
		setAccount(new Account(id));
		setApplication(new Application(id));
		setDirector(new Director(id));
		setStudent(new Student(id));
		setJournal(new ProjectJournal(id));
		setFare(new Fare(id));
		setMessage(new Message(id));
		setFinalreport(new FinalReport(id));
		setMiddlereport(new MiddleReport(id));
	}

	/**
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account 要设置的 account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application 要设置的 application
	 */
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return director
	 */
	public Director getDirector() {
		return director;
	}

	/**
	 * @param director2 要设置的 director
	 */
	public void setDirector(Director director2) {
		this.director = director2;
	}

	/**
	 * @return student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student 要设置的 student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return journal
	 */
	public ProjectJournal getJournal() {
		return journal;
	}

	/**
	 * @param projectJournal 要设置的 journal
	 */
	public void setJournal(ProjectJournal projectJournal) {
		this.journal = projectJournal;
	}
	
	/**
	 * @return fare
	 */
	public Fare getFare() {
		return fare;
	}

	/**
	 * @param fare 要设置的 fare
	 */
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Project proj=new Project(1,"好项目3",Short.valueOf("1"),Short.valueOf("1"),"201200800503");
		System.out.println(proj.selectSchool(0, 10, 1));
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * @return end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end 要设置的 end
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	public FinalReport getFinalreport() {
		return finalreport;
	}

	public void setFinalreport(FinalReport finalreport) {
		this.finalreport = finalreport;
	}

	@Override
	public Iterator selectAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	/**
	 * @return is_ranked
	 */
	public int getIs_ranked() {
		return is_ranked;
	}

	/**
	 * @param is_ranked 要设置的 is_ranked
	 */
	public void setIs_ranked(int is_ranked) {
		this.is_ranked = is_ranked;
	}

	/**
	 * @return middlereport
	 */
	public MiddleReport getMiddlereport() {
		return middlereport;
	}

	/**
	 * @param middlereport 要设置的 middlereport
	 */
	public void setMiddlereport(MiddleReport middlereport) {
		this.middlereport = middlereport;
	}



}
