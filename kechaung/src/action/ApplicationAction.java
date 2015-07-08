package action;

import mo.Application;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ApplicationAction extends ActionSupport implements ModelDriven<Application>{

	private Application application=new Application();
	@Override
	public Application getModel() {
		// TODO Auto-generated method stub
		return application;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public String execute()
	{
		if(application.update())
			return SUCCESS;
		return ERROR;
	}

}
