package action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import mo.Fare;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FareAction extends ActionSupport implements ModelDriven<Fare>{

	private Fare fare=new Fare();
	
	@Override
	public Fare getModel() {
		// TODO 自动生成的方法存根
		return fare;
	}

	/**
	 * @return Fare
	 */
	public Fare getFare() {
		return fare;
	}

	/**
	 * @param Fare 要设置的 Fare
	 */
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	
	public String add()
	{
		//System.out.println(Fare.getUsername()+Fare.getPassword());
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
		//System.out.println(Fare.getUsername()+Fare.getPassword());
		if(fare.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
