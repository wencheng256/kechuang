package action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import mo.Project;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProjectAction extends ActionSupport implements ModelDriven<Project>{

	private Project fare=new Project();
	
	@Override
	public Project getModel() {
		// TODO 自动生成的方法存根
		return fare;
	}

	/**
	 * @return Project
	 */
	public Project getProject() {
		return fare;
	}

	/**
	 * @param Project 要设置的 Project
	 */
	public void setProject(Project fare) {
		this.fare = fare;
	}
	
	public String add()
	{
		//System.out.println(Project.getUsername()+Project.getPassword());
		if(fare.insert())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	public String check()
	{
		//System.out.println(Project.getUsername()+Project.getPassword());
		if(fare.check())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	@SkipValidation  
	public String delete()
	{
		//System.out.println("1");
		if(fare.delete())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	public String update()
	{
		//System.out.println(Project.getUsername()+Project.getPassword());
		if(fare.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
