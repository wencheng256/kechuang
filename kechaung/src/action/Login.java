package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import mo.Account;
import mo.Project;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Login extends ActionSupport implements ModelDriven<Account>{

	private Account account=new Account();
	
	@Override
	public Account getModel() {
		// TODO 自动生成的方法存根
		System.out.println("111");
		return account;
	}

	/**
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account 要设置的 account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String execute()
	{
		//System.out.println(account.getUsername()+account.getPassword());
		if(account.verify())
		{
			ActionContext context=ActionContext.getContext();
			Map<String, Object> session=context.getSession();
			Project proj=new Project();
			proj=proj.selectId(account.getProject());
			proj.addDetial();
			session.put("project",proj);
			return SUCCESS;
		}
		return ERROR;
	}
	

}
