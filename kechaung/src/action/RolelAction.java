package action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import mo.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RolelAction extends ActionSupport implements ModelDriven<Role>{

	private Role fare=new Role();
	
	@Override
	public Role getModel() {
		// TODO 自动生成的方法存根
		return fare;
	}

	/**
	 * @return Role
	 */
	public Role getRole() {
		return fare;
	}

	/**
	 * @param Role 要设置的 Role
	 */
	public void setRole(Role fare) {
		this.fare = fare;
	}
	
	public String add()
	{
		//System.out.println(Role.getUsername()+Role.getPassword());
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
		//System.out.println(Role.getUsername()+Role.getPassword());
		if(fare.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
