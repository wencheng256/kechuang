package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.Mysql;

public class RoleAction implements Sqlable{
	
	private int id;
	private Action action=new Action();
	private Role role=new Role();
	private int act;
	private int ro;
	private String actionstring;
	private int enable;

	private Mysql mysql;
	
	public RoleAction()
	{
		mysql=Mysql.getInstance();
	}
	
	public RoleAction(int id2) {
		// TODO 自动生成的构造函数存根
		this();
		ro=id2;
	}


	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		String format="INSERT INTO tc_role_action(role,action,enable) values(%d,%d,1)";
		String sql=String.format(format, ro,act);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean update() {
		// TODO 自动生成的方法存根
		String format="UPDATE tc_role_action SET role=%d,action=%d,enable=%d where id=%d"; 
		String sql=String.format(format, ro,act,enable,id);
		//System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		String format="DELETE FROM tc_role_action where id="+id;
		return mysql.execute(format);
	}

	@Override
	public Iterator<RoleAction> selectAll() {
		// TODO 自动生成的方法存根
		ArrayList<RoleAction> list=new ArrayList<RoleAction>();
		String sql="SELECT id,role,enable action from tc_role_action";
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				RoleAction rat=new RoleAction();
				rat.setId(rs.getInt(1));
				rat.setRo(rs.getInt(2));
				rat.setAct(rs.getInt(4));
				rat.setEnable(rs.getInt(3));
				rat.decoration();
				list.add(rat);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list.iterator();
	}

	@Override
	public RoleAction selectId(int id) {
		// TODO 自动生成的方法存根
		RoleAction rat=new RoleAction();
		String sql="SELECT id,role,action,enable from tc_role_action where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				rat.setId(rs.getInt(1));
				rat.setRo(rs.getInt(2));
				rat.setAct(rs.getInt(3));
				rat.setEnable(rs.getInt(4));
				rat.decoration();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rat;
	}
	
	public ArrayList<RoleAction> selectRole() {
		// TODO 自动生成的方法存根
		ArrayList<RoleAction> list=new ArrayList<RoleAction>();
		String sql="SELECT a.id,a.role,a.action,b.name,a.enable from tc_role_action as a,tc_action as b where a.enable=1 and a.action=b.id and role="+ro;
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				RoleAction rat=new RoleAction();
				rat.setId(rs.getInt(1));
				rat.setRo(rs.getInt(2));
				rat.setAct(rs.getInt(3));
				rat.setActionstring(rs.getString(4));
				rat.setEnable(rs.getInt(5));
				list.add(rat);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<RoleAction> selectRole1() {
		// TODO 自动生成的方法存根
		ArrayList<RoleAction> list=new ArrayList<RoleAction>();
		String sql="SELECT a.id,a.role,a.action,b.name,a.enable from tc_role_action as a,tc_action as b where a.action=b.id and role="+ro;
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		try {
			while(rs.next())
			{
				RoleAction rat=new RoleAction();
				rat.setId(rs.getInt(1));
				rat.setRo(rs.getInt(2));
				rat.setAct(rs.getInt(3));
				rat.setActionstring(rs.getString(4));
				rat.setEnable(rs.getInt(5));
				list.add(rat);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	
	public void decoration()
	{
		role=role.selectId(ro);
		action=action.selectId(act);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return 0;
	}

	/**
	 * @return action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * @param action 要设置的 action
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * @return role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role 要设置的 role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return act
	 */
	public int getAct() {
		return act;
	}

	/**
	 * @param act 要设置的 act
	 */
	public void setAct(int act) {
		this.act = act;
	}

	/**
	 * @return ro
	 */
	public int getRo() {
		return ro;
	}

	/**
	 * @param ro 要设置的 ro
	 */
	public void setRo(int ro) {
		this.ro = ro;
	}


	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id 要设置的 id
	 */
	public void setEnable(int id) {
		this.enable = id;
	}
	
	public int getEnable() {
		return enable;
	}


	/**
	 * @param id 要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		RoleAction ac=new RoleAction();
		System.out.println(ac.selectId(1).getAction().getName());
	}

	/**
	 * @return actionstring
	 */
	public String getActionstring() {
		return actionstring;
	}

	/**
	 * @param actionstring 要设置的 actionstring
	 */
	public void setActionstring(String actionstring) {
		this.actionstring = actionstring;
	}

}
