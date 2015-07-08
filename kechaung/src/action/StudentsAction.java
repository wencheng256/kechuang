package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import mo.Student;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends ActionSupport implements ModelDriven<Student>{

	private Student student=new Student();
	
	@Override
	public Student getModel() {
		// TODO 自动生成的方法存根
		return student;
	}

	/**
	 * @return Student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param Student 要设置的 Student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String add()
	{
		//System.out.println(Student.getUsername()+Student.getPassword());
		if(student.insert())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	@SkipValidation  
	public String delete()
	{
		//System.out.println(Student.getId());
		if(student.delete())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	public String update()
	{
		//System.out.println(Student.getUsername()+Student.getPassword());
		if(student.update())
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
