package action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import mo.School;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SchoolAction extends ActionSupport implements ModelDriven<School>{

	private School fare=new School();
	
	@Override
	public School getModel() {
		// TODO 自动生成的方法存根
		return fare;
	}

	/**
	 * @return School
	 */
	public School getSchool() {
		return fare;
	}

	/**
	 * @param School 要设置的 School
	 */
	public void setSchool(School fare) {
		this.fare = fare;
	}
	
	public String add()
	{
		//System.out.println(School.getUsername()+School.getPassword());
		if(fare.insert())
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
		//System.out.println(School.getUsername()+School.getPassword());
		if(fare.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
