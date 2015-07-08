package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import com.Mysql;

public class Message implements Sqlable{
	
	private int id;
	private String content;
	private int sender;
	private	int receiver;
	private String time;
	private String senderstring;
	
	private Mysql mysql;
	
	public Message()
	{
		mysql=Mysql.getInstance();
	}
	public Message(int receiver)
	{
		this();
		this.receiver=receiver;
	}

	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		String format="INSERT INTO tc_message(content,sender,receiver,time) VALUES('%s',%d,%d,now())";
		String sql=String.format(format, content,sender,receiver);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO 自动生成的方法存根
		String format="UPDATE tc_message SET content='%s',sender='%d',receiver='%d' WHERE id=%d";
		String sql=String.format(format, content,sender,receiver,id);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		String sql="DELETE * FROM tc_message WHERE id="+id;
		return mysql.execute(sql);
	}

	@Override
	public Iterator<Message> selectAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Message selectId(int id) {
		// TODO 自动生成的方法存根
		return null;
	}
	public Iterator<Message> selectProject() {
		// TODO 自动生成的方法存根
		String sql="SELECT a.id,a.content,a.sender,a.receiver,DATE_FORMAT(a.time, '%Y-%m-%d'),b.name from tc_message as a,tc_project as b where a.sender=b.id and a.receiver="+receiver+" ORDER BY id desc";
		ResultSet rs=mysql.query(sql);
		LinkedList<Message> list=new LinkedList<Message>();
		try {
			while(rs.next())
			{
				Message me=new Message();
				me.setId(rs.getInt(1));
				me.setContent(rs.getString(2));
				me.setSender(rs.getInt(3));
				me.setReceiver(rs.getInt(4));
				me.setTime(rs.getString(5));
				me.setSenderstring(rs.getString(6));
				
				list.add(me);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.iterator();
	}


	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		String sql="SELECT COUNT(*) FROM tc_message where receiver="+receiver;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Message me=new Message(1);
		me.setContent("hello");
		me.setId(1);
		me.setReceiver(1);
		me.setSender(1);
		System.out.println(me.selectProject().next().getTime());
	}
	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time 要设置的 time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return senderstring
	 */
	public String getSenderstring() {
		return senderstring;
	}
	/**
	 * @param senderstring 要设置的 senderstring
	 */
	public void setSenderstring(String senderstring) {
		this.senderstring = senderstring;
	}


}
