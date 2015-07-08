package action;

import java.util.Map;

import mo.Account;
import mo.Project;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Register extends ActionSupport implements ModelDriven<Project>{

	private Project proj=new Project();
	private String username;
	private String password;
	private String iwill;
	@Override
	public Project getModel() {
		// TODO Auto-generated method stub
		return proj;
	}
	public Project getProj() {
		return proj;
	}
	public void setProj(Project proj) {
		this.proj = proj;
	}
	
	@Override
	public String execute()
	{
		if(proj.insert())
		{
			proj=proj.selectName(proj.getName());
			proj.addDetial();
			Account ac1=proj.getAccount();
			ac1.setUsername(username);
			ac1.setPassword(password);
			if(!ac1.insert())
			{
				return ERROR;
			}
			if(!proj.getApplication().insert())
			{
				return ERROR;
			}
			if(!proj.getFinalreport().insert())
			{
				return ERROR;
			}
			if(!proj.getMiddlereport().insert())
			{
				return ERROR;
			}
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("project", proj);
			return SUCCESS;
		}else
		{
			return ERROR;
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void validate()
	{
		if(proj.selectName(proj.getName()).getId()!=0)
		{
			addFieldError("name", "该项目名称已经存在");
		}
		Account act=new Account();
		if(act.getByName(username).getId()!=0)
		{
			addFieldError("name", "该用户名已经存在");
		}
		if(proj.getByNum(proj.getProj_permitid()).getId()!=0)
		{
			addFieldError("name", "该项目编码已经存在");
		}
	}
	/**
	 * @return iwill
	 */
	public String getIwill() {
		return iwill;
	}
	/**
	 * @param iwill 要设置的 iwill
	 */
	public void setIwill(String iwill) {
		this.iwill = iwill;
	}

}
