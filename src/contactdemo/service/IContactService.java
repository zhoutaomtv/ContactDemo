package contactdemo.service;

import java.util.List;

import contactdemo.entity.Contact;

public interface IContactService {

	public void saveOrUpdate(Contact c);

	public void delete(Contact c);

	public List<Contact> list();

	public List<Contact> listBy(String key, String value, int size);
}
