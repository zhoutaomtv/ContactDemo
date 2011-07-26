package contactdemo.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import contactdemo.common.PMF;
import contactdemo.entity.Contact;

public class ContactDaoImpl implements IContactDao {
	
	private static final Logger logger = Logger.getLogger(ContactDaoImpl.class.getName());
	private PersistenceManager pm = PMF.getInstance().getPersistenceManager();

	@Override
	public void saveOrUpdate(Contact c) {
		// TODO Auto-generated method stub
		try {
			pm.makePersistent(c);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Save or update object error.", e);
		} finally {
			pm.close();
		}
	}

	@Override
	public void delete(Contact c) {
		// TODO Auto-generated method stub
		try {
			pm.deletePersistent(c);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Delete object error.", e);
		} finally {
			pm.close();
		}
	}

	@Override
	public java.util.List<Contact> List() {
		// TODO Auto-generated method stub
		List<Contact> lst = null;
		Query query = pm.newQuery(Contact.class);
		lst = (List<Contact>) query.execute();
		return lst;
	}

	@Override
	public java.util.List<Contact> ListBy(String key, String value, int size) {
		// TODO Auto-generated method stub
		Query query = pm.newQuery(Contact.class);
		query.setFilter("keyCol == keyValue");
		query.setOrdering("age desc");		
		query.declareParameters("String keyCol");
		query.declareParameters("String keyValue");
		return (java.util.List<Contact>) query.execute(key, value);
	}

	@Override
	public Contact load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
