package dao.impl;

import java.util.List;

import pojo.Msg;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;

import dao.IMsgDao;

public class MsgDaoImpl extends GenericHibernateDao<Msg,Integer> implements IMsgDao{
	private MsgDaoImpl(){
		super(Msg.class);
	}

	public void add(Msg msg) {
		// TODO Auto-generated method stub
		this.save(msg);
	}

	public Pagination<Msg> page(int pageno, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Msg as a order by id desc";
		return this.findByPage(pageno, pageSize,hql);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		this.remove(id);
	}

	public Msg msg(int id) {
		// TODO Auto-generated method stub
		return this.findById(id);
	}

	public List<Msg> allList() {
		// TODO Auto-generated method stub
		return this.findAll();
	}

	public void reply(Msg msg) {
		// TODO Auto-generated method stub
		this.update(msg);
	}
}
