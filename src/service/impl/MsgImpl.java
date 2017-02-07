package service.impl;

import java.util.List;

import pojo.Msg;

import com.framework.core.page.Pagination;

import service.IMsgService;
import dao.IMsgDao;

public class MsgImpl implements IMsgService {
	private IMsgDao msgDao;

	public IMsgDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(IMsgDao msgDao) {
		this.msgDao = msgDao;
	}

	public void add(Msg msg) {
		// TODO Auto-generated method stub
		msgDao.add(msg);
	}

	public Pagination<Msg> page(int pageno, int pageSize) {
		// TODO Auto-generated method stub
		return msgDao.page(pageno, pageSize);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		msgDao.delete(id);
	}

	/*更具id查找一个Msg
	 * (non-Javadoc)
	 * @see service.IMsgService#msg(int)
	 */
	public Msg msg(int id) {
		// TODO Auto-generated method stub
		return msgDao.msg(id);
	}

	public List<Msg> allList() {
		// TODO Auto-generated method stub
		return msgDao.allList();
	}

	public void reply(Msg msg) {
		// TODO Auto-generated method stub
		msgDao.reply(msg);
	}
}
