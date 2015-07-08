package action;

import java.util.Map;

import mo.Project;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Proj extends ActionSupport{
	
	private int progress;
	private int status;
	private int id;
	
	public String execute()
	{
		Project proj=new Project();
		proj=proj.selectId(id);
		proj.setStatus((short)status);
		proj.setProgress(progress);
		if(!proj.update())
			return ERROR;
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

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
