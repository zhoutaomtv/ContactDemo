/**
 * 
 */
package contactdemo.dao;

import java.util.List;

import contactdemo.entity.Contact;

/**
 * @author toddy
 * 
 */
public interface IContactDao {

	public void saveOrUpdate(Contact c);

	public void delete(Contact c);
	
	public Contact load(Long id);

	public List<Contact> List();

	public List<Contact> ListBy(String key, String value, int size);
}
