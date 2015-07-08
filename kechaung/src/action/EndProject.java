package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import mo.Account;
import mo.Project;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EndProject extends ActionSupport{
	
	private Project proj;
	private String config;
	
	@Override
	public String execute()
	{
		if(!config.equals("submit"))
		{
			return ERROR;
		}
		try{
			if(!proj.endProject())
			{
				return ERROR;
			}
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

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}
	
	public String getConfig() {
		return config;
	}

	public void setConfig(String proj) {
		this.config = proj;
	}


}
