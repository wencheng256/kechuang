package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import mo.Account;
import mo.Project;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateDate extends ActionSupport{
	
	@Override
	public String execute()
	{
		try{
			Map<String,Object> session=ActionContext.getContext().getSession();
			Project pro=(Project) session.get("project");
			pro=pro.selectId(pro.getId());
			pro.addDetial();
			session.put("project",pro);
			return SUCCESS;
		}catch(Exception e)
		{
			return ERROR;
		}
	}
	

}
