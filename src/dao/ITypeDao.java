package dao;

import java.util.List;

import pojo.Type;

public interface ITypeDao {
	/*
	 * 根据类型名查找
	 */
	public List<Type> findByTypename(String typename);
	
	/*
	 * 根据id查找
	 */
	public Type findTypeById(int id);
	/*
	 * 根君type查找
	 */
	public Type findByType(int type);
}
