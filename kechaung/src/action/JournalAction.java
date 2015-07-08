package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import mo.ProjectJournal;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JournalAction extends ActionSupport implements ModelDriven<ProjectJournal>{

	private ProjectJournal journal=new ProjectJournal();
	
	@Override
	public ProjectJournal getModel() {
		// TODO 自动生成的方法存根
		return journal;
	}

	/**
	 * @return ProjectJournal
	 */
	public ProjectJournal getProjectJournal() {
		return journal;
	}

	/**
	 * @param ProjectJournal 要设置的 ProjectJournal
	 */
	public void setProjectJournal(ProjectJournal journal) {
		this.journal = journal;
	}
	
	public String add()
	{
		//System.out.println(ProjectJournal.getUsername()+ProjectJournal.getPassword());
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
		//System.out.println(ProjectJournal.getUsername()+ProjectJournal.getPassword());
		if(journal.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
