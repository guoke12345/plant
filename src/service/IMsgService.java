package service;

import java.util.List;

import pojo.Msg;

import com.framework.core.page.Pagination;

public interface IMsgService {
	/**
	 * 添加
	 */
	public void add(Msg msg);

	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Msg> page(int pageno, int pageSize);
	
	/**
	 * 删除
	 */
	public void delete(int id);
	/**
	 * 根据ID查找   对象
	 */
	public Msg msg(int id);
	/**
	 * 查找所有列表
	 */
	public List<Msg> allList();
	
	/*
	 * 回复留言
	 */
	public void reply(Msg msg);
}
