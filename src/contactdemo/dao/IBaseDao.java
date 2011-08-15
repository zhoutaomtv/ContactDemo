/**
 * 
 */
package contactdemo.dao;

import java.util.List;

/**
 * @author toddy
 * @param <T>
 * 
 */
public interface IBaseDao<T> {

	public void saveOrUpdate(T t) throws Exception;

	public void delete(T t) throws Exception;
	
	public T load(T t) throws Exception;

	public List<T> List() throws Exception;

	public List<T> ListBy(String key, String value, int size) throws Exception;
}
