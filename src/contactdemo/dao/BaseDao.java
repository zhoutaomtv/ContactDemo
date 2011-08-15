package contactdemo.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import contactdemo.common.PMF;
import contactdemo.entity.Contact;

public abstract class BaseDao<T> implements IBaseDao<T> {

	private static final Logger logger = Logger.getLogger(ContactDaoImpl.class.getName());
	private PersistenceManager pm = PMF.getInstance().getPersistenceManager();
	
	@Override
	public void saveOrUpdate(T t) throws Exception {
		try {
			pm.makePersistent(t);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Save or update object error.", e);
		} finally {
			pm.close();
		}
	}

	@Override
	public void delete(T t) throws Exception {
		try {
			pm.deletePersistent(t);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Delete object error.", e);
		} finally {
			pm.close();
		}
	}

	@Override
	public T load(T t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<T> List() throws Exception {
		List<T> lst = null;
		Query query = pm.newQuery(Contact.class);
		lst = (List<T>) query.execute();
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<T> ListBy(String key, String value, int size)
			throws Exception {
		Query query = pm.newQuery(Contact.class);
		query.setFilter("keyCol == keyValue");
		query.setOrdering("age desc");		
		query.declareParameters("String keyCol");
		query.declareParameters("String keyValue");
		return (List<T>) query.execute(key, value);
	}

}
