package action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import mo.RoleAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Role1Action extends ActionSupport implements ModelDriven<RoleAction>{

	private RoleAction fare=new RoleAction();
	
	@Override
	public RoleAction getModel() {
		// TODO 自动生成的方法存根
		return fare;
	}

	/**
	 * @return RoleAction
	 */
	public RoleAction getRoleAction() {
		return fare;
	}

	/**
	 * @param RoleAction 要设置的 RoleAction
	 */
	public void setRoleAction(RoleAction fare) {
		this.fare = fare;
	}
	
	public String add()
	{
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
		//System.out.println(RoleAction.getUsername()+RoleAction.getPassword());
		if(fare.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
