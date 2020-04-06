package caf.war.simpleOrderTasks.taskclient.is.document;

 import java.io.Serializable;

/**
 * IS document wrapper
 */
public  class SimpleOrder_doc_customer extends java.lang.Object implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// IS Document type used to generate this class
	public static final String DOCUMENT_TYPE = "simpleOrder.doc:customer";
	private java.lang.String id;
	private java.lang.String firstname;
	public static String[][] FIELD_NAMES = new String[][] {{"id", "id"},{"firstname", "firstname"},{"lastname", "lastname"},
	};
	private java.lang.String lastname;

	// Used by Designer to access the source document.
	 @SuppressWarnings("unused")
	

	
	public SimpleOrder_doc_customer() {
	}

	public java.lang.String getId()  {
		
		return id;
	}

	public void setId(java.lang.String id)  {
		this.id = id;
	}

	public java.lang.String getFirstname()  {
		
		return firstname;
	}

	public void setFirstname(java.lang.String firstname)  {
		this.firstname = firstname;
	}

	public java.lang.String getLastname()  {
		
		return lastname;
	}

	public void setLastname(java.lang.String lastname)  {
		this.lastname = lastname;
	}
	
	

}