package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import mo.Message;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction extends ActionSupport implements ModelDriven<Message>{

	private Message message=new Message();
	private String url;
	
	@Override
	public Message getModel() {
		// TODO 自动生成的方法存根
		return message;
	}

	/**
	 * @return account
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * @param account 要设置的 account
	 */
	public void setMessage(Message message) {
		this.message = message;
	}
	
	@Override
	public String execute()
	{
		//System.out.println(message.getContent());
		if(message.insert())
		{	
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("url",url);
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url 要设置的 url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
