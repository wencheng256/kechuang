package action;

import mo.FinalReport;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FinalreportAction extends ActionSupport implements ModelDriven<FinalReport>{

	private FinalReport application=new FinalReport();
	@Override
	public FinalReport getModel() {
		// TODO Auto-generated method stub
		return application;
	}
	public FinalReport getFinalReport() {
		return application;
	}
	public void setFinalReport(FinalReport application) {
		this.application = application;
	}
	
	public String execute()
	{
		if(application.update())
			return SUCCESS;
		return ERROR;
	}

}
