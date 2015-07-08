package action;

import mo.Project;
import mo.ProjectJournal;
import mo.RoleAction;
import mo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class Change extends ActionSupport{

	private int id;

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
	
	public String student()
	{
		Student stu=new Student();
		stu=stu.selectId(id);
		if(stu.getIs_cap()==0)
		{
			stu.setIs_cap(1);
		}else
		{
			stu.setIs_cap(0);
		}
		stu.update();

		return SUCCESS;
	}
	public String journal()
	{
		ProjectJournal j=new ProjectJournal();
		j=j.selectId(id);
		if(j.getIs_public()==0)
		{
			j.setIs_public((short)1);
		}else
		{
			j.setIs_public((short)0);
		}
		j.update();

		return SUCCESS;
	}
	public String journal1()
	{
		ProjectJournal j=new ProjectJournal();
		j=j.selectId(id);
		if(j.getStatus()==1)
		{
			j.setStatus((short)2);
		}else
		{
			j.setStatus((short)1);
		}
		j.update();

		return SUCCESS;
	}
	public String project()
	{
		Project j=new Project();
		j=j.selectId(id);
		if(j.getImportant()==0)
		{
			j.setImportant((short)1);
		}else
		{
			j.setImportant((short)0);
		}
		j.update();

		return SUCCESS;
	}
	public String roleaction()
	{
		RoleAction j=new RoleAction();
		j=j.selectId(id);
		if(j.getEnable()==0)
		{
			j.setEnable(1);
		}else
		{
			j.setEnable(0);
		}
		j.update();

		return SUCCESS;
	}
	
	
}
