package action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import mo.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionAction extends ActionSupport implements ModelDriven<Action>{

	private Action fare=new Action();
	
	@Override
	public Action getModel() {
		// TODO 自动生成的方法存根
		return fare;
	}

	/**
	 * @return Action
	 */
	public Action getAction() {
		return fare;
	}

	/**
	 * @param Action 要设置的 Action
	 */
	public void setAction(Action fare) {
		this.fare = fare;
	}
	
	public String add()
	{
		//System.out.println(Action.getUsername()+Action.getPassword());
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
		//System.out.println(Action.getUsername()+Action.getPassword());
		if(fare.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
