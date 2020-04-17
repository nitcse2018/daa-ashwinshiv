
/*
Name:Ashwin Shiv
Roll no:181210013
Cse 2nd Year

*/
import java.io.Serializable;

public class EntityResume implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public int age;
	public String qualifications;
	public String hobbies;

	public EntityResume() {

	}

	public String toString() {

		return " Name " + name + " Age " + age + " Qualification " + qualifications + " hobbies " + hobbies;
	}
}
