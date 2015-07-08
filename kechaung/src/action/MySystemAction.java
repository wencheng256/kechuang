package action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import mo.MySystem;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MySystemAction extends ActionSupport implements ModelDriven<MySystem>{

	private MySystem fare=new MySystem();
	
	@Override
	public MySystem getModel() {
		// TODO 自动生成的方法存根
		return fare;
	}

	/**
	 * @return MySystem
	 */
	public MySystem getMySystem() {
		return fare;
	}

	/**
	 * @param MySystem 要设置的 MySystem
	 */
	public void setMySystem(MySystem fare) {
		this.fare = fare;
	}
	
	public String add()
	{
		//System.out.println(MySystem.getUsername()+MySystem.getPassword());
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
		//System.out.println(MySystem.getUsername()+MySystem.getPassword());
		if(fare.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
