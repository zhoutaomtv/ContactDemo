package contactdemo.control;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactdemo.entity.Contact;
import contactdemo.service.ContactServiceImpl;
import contactdemo.service.IContactService;

public class ListContact extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		
		int size = 5;
		//int size = Integer.valueOf(req.getParameter("size"));
		IContactService contactService = new ContactServiceImpl();
		List<Contact> contacts;
		if (value == null) {
			contacts = contactService.list();
		} else {
			contacts = contactService.listBy(key, value, size);
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<Contact> iter = contacts.iterator();
		sb.append("<table>");
		while (iter.hasNext()) {
			Contact c = iter.next();
			sb.append("<tr>");
			sb.append("<td>" + c.getFirstName() + "</td>");
			sb.append("<td>" + c.getLastName() + "</td>");
			sb.append("<td>" + c.getAge() + "</td>");
			sb.append("<td>" + c.getNotes() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		
		res.getWriter().println(sb.toString());
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		doPost(req, res);
	}
}
