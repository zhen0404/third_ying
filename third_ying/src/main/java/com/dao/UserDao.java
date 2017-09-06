package com.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.User;

@Component
public class UserDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public User getUserByUserName(String userName) {
//		Session session=getSession();
//		String hql="from User u where u.name='"+userName+"'";
//		List<User> list=session.createQuery(hql).list();
		return  (User) getSession().get(User.class, "from User where uname="+userName);
//		if(list.size()>0){
//			return list.get(0);
//		}
//		return null;
	}

	public Set<String> getRolesByUserName(String userName) {
//		Session session=getSession();
//		String sql="select r.rname from tuser t,roles r where t.rid=r.id "
//				+ " and t.name= '"+userName+"'";
//		List<String> rnameList=session.createSQLQuery(sql).list();
//		Set< String > set=new HashSet<String>(rnameList);
//		return set;
		Set<String> roles=new HashSet();
		String sql = "select rolename from t_user , t_role where t_user.roleid=t_role.rid and username="+userName+"";
		List rlist=getSession().createSQLQuery(sql).list();
		for(int i=0;i<rlist.size();i++){
			roles.add((String) rlist.get(i));
		}
		return roles;
	}

	public Set<String> getPersByUserName(String userName) {
//		Session session=getSession();
//		String sql="select p.pname from tuser t,roles r,permission p where t.rid=r.id and r.id=p.id"
//				+ " and t.name='"+userName+"'";
//		List<String> pnameList= session.createSQLQuery(sql).list();
//		Set< String > set=new HashSet<String>(pnameList);
//		return set;
		Set<String> permission=new HashSet();
		String sql = "select t1.uid uid,t2.rid rid ,t3.pid pid ,t3.pname pname from t_user t1,t_role t2 ,t_permission t3 where t1.roleid=t2.rid and t2.rid=t3.rid and username="+userName+"";
		List plist=getSession().createSQLQuery(sql).list();
		for(int i=0;i<plist.size();i++){
			permission.add((String) plist.get(i));
		}
		return permission;
	}

}
