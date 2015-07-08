package action;

import mo.MiddleReport;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MiddlereportAction extends ActionSupport implements ModelDriven<MiddleReport>{

	private MiddleReport application=new MiddleReport();
	@Override
	public MiddleReport getModel() {
		// TODO Auto-generated method stub
		return application;
	}
	public MiddleReport getMiddleReport() {
		return application;
	}
	public void setMiddleReport(MiddleReport application) {
		this.application = application;
	}
	
	public String execute()
	{
		if(application.update())
			return SUCCESS;
		return ERROR;
	}

}
