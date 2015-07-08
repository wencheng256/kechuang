package action;

import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import mo.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ExitAction extends ActionSupport {

	@Override
	public String execute()
	{
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> session=ac.getSession();
		session.put("user1", null);
		session.put("project", null);
		return SUCCESS;
	}
}
