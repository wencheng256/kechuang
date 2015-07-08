package action;

import java.util.Map;

import mo.Account;
import mo.Project;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChangePass extends ActionSupport{
	
	private String name;
	private String username;
	private String cp;
	private String num;
	private String newp;

	@Override
	public String execute()
	{
		Project pro=new Project();
		pro=pro.selectName(name);
		Account ac1=new Account();
		ac1=ac1.getByProject(pro.getId());
		ac1.setPassword(newp);
		if(ac1.update())
		{
			return SUCCESS;
		}else
		{
			return ERROR;
		}
	}

	
	@Override
	public void validate()
	{
		if(!cp.equals(newp))
		{
			addFieldError("cp", "确认密码和新密码不相同");
		}
		Project pro=new Project();
		pro.setName(name);
		pro.setProj_permitid(num);
		if(!pro.getIf())
		{
			addFieldError("num", "项目名和项目的编号不匹配");
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getNewp() {
		return newp;
	}


	public void setNewp(String newp) {
		this.newp = newp;
	}

}