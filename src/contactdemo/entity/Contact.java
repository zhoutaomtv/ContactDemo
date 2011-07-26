package contactdemo.entity;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Contact {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String firstName;

	@Persistent
	private String lastName;

	@Persistent
	private String sex;

	@Persistent
	private short age;

	@Persistent
	private Text notes;

	@Persistent
	private List<Phone> phone;

	@Persistent
	private List<Address> address;

	@Persistent
	private List<IM> im;

	public Contact() {
		// empty
	}

	public Contact(String firstName, String lastName, String sex, short age,
			Text notes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
		this.notes = notes;
	}

	public Contact(String firstName, String lastName, String sex, short age,
			Text notes, List<Phone> phone, List<Address> address, List<IM> im) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
		this.notes = notes;
		this.phone = phone;
		this.address = address;
		this.im = im;
	}

	public Long getId() {
		return id;
	}

	public Text getNotes() {
		return notes;
	}

	public void setNotes(Text notes) {
		this.notes = notes;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<IM> getIm() {
		return im;
	}

	public void setIm(List<IM> im) {
		this.im = im;
	}

}
