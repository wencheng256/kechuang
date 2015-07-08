package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import mo.Director;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DirectorAction extends ActionSupport implements ModelDriven<Director>{

	private Director director=new Director();
	
	@Override
	public Director getModel() {
		// TODO 自动生成的方法存根
		return director;
	}

	/**
	 * @return Director
	 */
	public Director getDirector() {
		return director;
	}

	/**
	 * @param Director 要设置的 Director
	 */
	public void setDirector(Director director) {
		this.director = director;
	}
	
	public String add()
	{
		//System.out.println(Director.getUsername()+Director.getPassword());
		if(director.insert())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	@SkipValidation  
	public String delete()
	{
		//System.out.println("1");
		if(director.delete())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	public String update()
	{
		//System.out.println(Director.getUsername()+Director.getPassword());
		if(director.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
