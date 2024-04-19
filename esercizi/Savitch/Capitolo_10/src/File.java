/**
* Next define class for File, derive from Document
* For brevity, short one-line methods are defined here in the
* header.
*/
public class File extends Documento
{
	private String pathname;

	/**
	* Constructors.
	*/
	public File()
	{
		super();
		pathname = "";
	}

	public File(String body, String pathname)
	{
		super(body);
		this.pathname = pathname;
	}

	// ======================
	// Various accessor and mutator methods
	// ======================
	public void setPathname(String s)
	{
		pathname = s;
	}

	public String getPathname()
	{
		return pathname;
	}

	/**
	* Returns as a string the contents of the text fields concatenated
	* together.  Uses super.toString to get the parent's text.
	*/
   	public String toString()
	{
		return "Pathname " + pathname + " Body " + super.toString();
	}
} // File