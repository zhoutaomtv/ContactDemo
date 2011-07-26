package contactdemo.control;

import java.io.IOException;

import com.google.appengine.api.datastore.Text;

import contactdemo.entity.Contact;
import contactdemo.service.ContactServiceImpl;
import contactdemo.service.IContactService;

public class SaveOrUpdateContact extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String sex = req.getParameter("sex");
		short age = Short.valueOf(req.getParameter("age"));
		String notes = req.getParameter("notes");
		Contact c = new Contact(firstName, lastName, sex, age, new Text(notes));
		IContactService contactService = new ContactServiceImpl();
		contactService.saveOrUpdate(c);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		doPost(req, res);
	}
}
