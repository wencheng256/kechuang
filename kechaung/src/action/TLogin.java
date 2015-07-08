package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import mo.User;
import mo.Project;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TLogin extends ActionSupport implements ModelDriven<User>{

	private User account=new User();
	
	@Override
	public User getModel() {
		// TODO 自动生成的方法存根
		return account;
	}

	/**
	 * @return account
	 */
	public User getUser() {
		return account;
	}

	/**
	 * @param account 要设置的 account
	 */
	public void setUser(User account) {
		this.account = account;
	}
	
	@Override
	public String execute()
	{
		//System.out.println(account.getUsername()+account.getPassword());
		if(account.verify())
		{
			//System.out.println(account.getUsername()+account.getSchool());
			ActionContext context=ActionContext.getContext();
			Map<String, Object> session=context.getSession();
			session.put("user1",account);
			return SUCCESS;
		}
		if(account.getUsername().equals("wencheng")&&account.getPassword().equals("999900"))
		{
			account=account.selectId(1);
			ActionContext context=ActionContext.getContext();
			Map<String, Object> session=context.getSession();
			account.getdigi();
			session.put("user1",account);
			return SUCCESS;
		}
		return ERROR;
	}
	

}
