package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class ProjectJournal implements Sqlable {

	private int id;
	private int project;
	private String time;					//自动生成
	private String  title;
	private short is_public;			//1为公开 0 为不公开 默认 0
	private short status=1;
	private int editor;
	private String content;
	private String editorname;
	private String button;
	private int sort;
	private String sortstring;
	
	private String projnum;
	private String projname;
	
	private Mysql mysql;
	
	private String[] statusmap={"草稿","审核中","审核通过","回收站","审核未通过"};
	private String  statusstring;
	private String[] buttonmap={"primary","info","success","warning","danger"};
	
	public ProjectJournal()
	{
		mysql=Mysql.getInstance();
	}
	
	public ProjectJournal(String title,int project,short is_public,short status,int editor,String content)
	{
		this();
		this.title=title;
		this.project=project;
		this.is_public=is_public;
		this.status=status;
		this.editor=editor;
	}
	public ProjectJournal(int id,String title,int project,short is_public,short status,int editor,String content)
	{
		 this(title,project,is_public,status,editor,content);
		 this.id=id;
	}
	
	
	public ProjectJournal(int id) {
		// TODO 自动生成的构造函数存根
		this();
		this.project=id;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		String format="INSERT INTO tc_project_journal(title,project,time,is_public,editor,content,status,sort) values('%s',%d,now(),%d,%d,'%s',%d,%d)";
		String sql=String.format(format, title,project,is_public,editor,content,status,sort);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		String format="UPDATE tc_project_journal SET title='%s',project=%d,time=now(),is_public=%d,editor=%d,content='%s',status='%d',sort='%d' where id=%d";
		String sql=String.format(format, title,project,is_public,editor,content,status,sort,id);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		if(this.status!=3)
		{
			status=3;
			return this.update();
		}else
		{
			String sql="DELETE FROM tc_project_journal where id="+id;
			return mysql.execute(sql);
		}
	}

	public Iterator<ProjectJournal> selectAll(int a,int b) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d where a.sort=d.id and a.project=c.id and a.editor=b.id limit "+a+","+b;
		//System.out.println(sql);
		ArrayList<ProjectJournal> list=new ArrayList<ProjectJournal>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				ProjectJournal proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setProjnum(rs.getString(10));
				proj.setProjname(rs.getString(11));
				proj.setSort(rs.getInt(12));
				proj.setSortstring(rs.getString(13));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	public Iterator<ProjectJournal> selectAllschool(int a,int b,int school) {
		// TODO Auto-generated method stub
		String sql;
		if(school==0){
		sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name  from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d where a.sort=d.id and a.project=c.id and a.editor=b.id order by c.proj_permitid,a.sort limit "+a+","+b;
		}else
		{
		sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name  from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d where c.school="+school+" and a.sort=d.id  and a.project=c.id and a.editor=b.id order by c.proj_permitid,a.sort limit "+a+","+b;
		}
		//System.out.println(sql);
		ArrayList<ProjectJournal> list=new ArrayList<ProjectJournal>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				ProjectJournal proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setProjnum(rs.getString(10));
				proj.setProjname(rs.getString(11));
				proj.setSort(rs.getInt(12));
				proj.setSortstring(rs.getString(13));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	public Iterator<ProjectJournal> selectunAll(int a,int b) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name  from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d where a.sort=d.id and a.status=1 and a.project=c.id and a.editor=b.id limit "+a+","+b;
		//System.out.println(sql);
		ArrayList<ProjectJournal> list=new ArrayList<ProjectJournal>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				ProjectJournal proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setProjnum(rs.getString(10));
				proj.setProjname(rs.getString(11));
				proj.setSort(rs.getInt(12));
				proj.setSortstring(rs.getString(13));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	public Iterator<ProjectJournal> selectunAllschool(int a,int b,int school) {
		// TODO Auto-generated method stub
		String sql;
		if(school==0){
		sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name  from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d where a.sort=d.id and a.status=1 and a.project=c.id and a.editor=b.id order by c.proj_permitid,a.sort limit "+a+","+b;
		}else
		{
		sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name  from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d where c.school="+school+" and a.sort=d.id and a.status=1 and a.project=c.id and a.editor=b.id order by c.proj_permitid,a.sort limit "+a+","+b;
		}
		//System.out.println(sql);
		ArrayList<ProjectJournal> list=new ArrayList<ProjectJournal>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				ProjectJournal proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setProjnum(rs.getString(10));
				proj.setProjname(rs.getString(11));
				proj.setSort(rs.getInt(12));
				proj.setSortstring(rs.getString(13));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	public ProjectJournal selectNextId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name  from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d  where  a.sort=d.id and a.status=1 and a.project=c.id and a.editor=b.id and a.id>"+id;
		ResultSet rs=mysql.query(sql);
		ProjectJournal proj=new ProjectJournal();
		try {
			if(rs.next())
			{
				proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setProjnum(rs.getString(10));
				proj.setProjname(rs.getString(11));
				proj.setSort(rs.getInt(12));
				proj.setSortstring(rs.getString(13));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				return proj;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public ProjectJournal selectPrevId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,c.proj_permitid,c.name,a.sort,d.name from tc_project_journal as a ,tc_student as b ,tc_project as c,tc_journal_sort as d where  a.sort=d.id and a.status=1 and a.project=c.id and a.editor=b.id and a.id<"+id+" order by id desc";
		ResultSet rs=mysql.query(sql);
		ProjectJournal proj=new ProjectJournal();
		try {
			if(rs.next())
			{
				proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				return proj;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	
	
	public Iterator<ProjectJournal> selectProj(int a,int b) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,a.sort,d.name from tc_project_journal as a , tc_student as b ,tc_journal_sort as d where  a.sort=d.id and a.editor=b.id and a.project="+project+" order by a.`status` desc limit "+a+", "+b;
		//System.out.println(sql);
		ArrayList<ProjectJournal> list=new ArrayList<ProjectJournal>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				ProjectJournal proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setSort(rs.getInt(10));
				proj.setSortstring(rs.getString(11));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	public Iterator<ProjectJournal> selectProj3() {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name` from tc_project_journal as a , tc_student as b where a.editor=b.id and a.project="+project+" limit 3";
		//System.out.println(sql);
		ArrayList<ProjectJournal> list=new ArrayList<ProjectJournal>();
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				ProjectJournal proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}
	
	public Iterator<ProjectJournal> selectProjpublic(int a,int b) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.`status`,b.`name`,a.sort,d.name from tc_project_journal as a , tc_student as b,tc_journal_sort as d where a.sort=d.id and a.editor=b.id and is_public=1 and status=2 and a.project="+project+" order by a.`status` desc limit "+a+", "+b;;
		ArrayList<ProjectJournal> list=new ArrayList<ProjectJournal>();
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				ProjectJournal proj=new ProjectJournal();
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setSort(rs.getInt(10));
				proj.setSortstring(rs.getString(11));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
				
				list.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.iterator();
	}

	@Override
	public ProjectJournal selectId(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT a.id,a.title,a.project,DATE_FORMAT(a.time,'%Y-%m-%d'),a.is_public,a.editor,a.content,a.status,b.name,a.sort,d.name from tc_project_journal as a , tc_student as b,tc_journal_sort as d where a.sort=d.id and a.editor=b.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		ProjectJournal proj=new ProjectJournal();
		try {
			if(rs.next())
			{
				proj.setId(rs.getInt(1));
				proj.setTitle(rs.getString(2));
				proj.setProject(rs.getShort(3));
				proj.setTime(rs.getString(4));
				proj.setIs_public(rs.getShort(5));
				proj.setEditor(rs.getInt(6));
				proj.setContent(rs.getString(7));
				proj.setStatus(rs.getShort(8));
				proj.setButton(buttonmap[proj.getStatus()]);
				proj.setEditorname(rs.getString(9));
				proj.setSort(rs.getInt(10));
				proj.setSortstring(rs.getString(11));
				
				proj.setStatusstring(statusmap[proj.getStatus()]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return proj;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql="SELECT count(*) FROM `tc_project_journal` where project="+project;
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

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getIs_public() {
		return is_public;
	}

	public void setIs_public(short is_public) {
		this.is_public = is_public;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public int getEditor() {
		return editor;
	}

	public void setEditor(int editor) {
		this.editor = editor;
	}

	public String getStatusstring() {
		return statusstring;
	}

	public void setStatusstring(String statusstring) {
		this.statusstring = statusstring;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @return button
	 */
	public String getButton() {
		return button;
	}

	/**
	 * @param button 要设置的 button
	 */
	public void setButton(String button) {
		this.button = button;
	}

	/**
	 * @return editorname
	 */
	public String getEditorname() {
		return editorname;
	}

	/**
	 * @param editorname 要设置的 editorname
	 */
	public void setEditorname(String editorname) {
		this.editorname = editorname;
	}
	
	public static void main(String[] args) {
		new ProjectJournal(2,"我的第二篇日志",Short.parseShort("2"),Short.parseShort("1"),Short.parseShort("1"),5,"内容是");
	}

	@Override
	public Iterator selectAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	/**
	 * @return projnum
	 */
	public String getProjnum() {
		return projnum;
	}

	/**
	 * @param projnum 要设置的 projnum
	 */
	public void setProjnum(String projnum) {
		this.projnum = projnum;
	}

	/**
	 * @return projname
	 */
	public String getProjname() {
		return projname;
	}

	/**
	 * @param projname 要设置的 projname
	 */
	public void setProjname(String projname) {
		this.projname = projname;
	}

	/**
	 * @return sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * @param sort 要设置的 sort
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}

	/**
	 * @return sortstring
	 */
	public String getSortstring() {
		return sortstring;
	}

	/**
	 * @param sortstring 要设置的 sortstring
	 */
	public void setSortstring(String sortstring) {
		this.sortstring = sortstring;
	}


}
