package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import mo.News;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewsAction extends ActionSupport implements ModelDriven<News>{

	private News journal=new News();
	
	@Override
	public News getModel() {
		// TODO 自动生成的方法存根
		return journal;
	}

	/**
	 * @return News
	 */
	public News getNews() {
		return journal;
	}

	/**
	 * @param News 要设置的 News
	 */
	public void setNews(News journal) {
		this.journal = journal;
	}
	
	public String add()
	{
		//System.out.println(News.getUsername()+News.getPassword());
		if(journal.insert())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	@SkipValidation  
	public String delete()
	{
		journal=journal.selectId(journal.getId());
		//System.out.println(journal.getStatus());
		if(journal.delete())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	public String update()
	{
		//System.out.println(News.getUsername()+News.getPassword());
		if(journal.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
