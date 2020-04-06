package caf.war.simpleOrderTasks.taskclient.is.document;

 import java.io.Serializable;

/**
 * IS document wrapper
 */
public  class SimpleOrder_doc_product extends java.lang.Object implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// IS Document type used to generate this class
	public static final String DOCUMENT_TYPE = "simpleOrder.doc:product";
	private java.lang.String id;
	private java.lang.String name;
	public static String[][] FIELD_NAMES = new String[][] {{"id", "id"},{"name", "name"},{"price", "price"},
	};
	private java.lang.String price;

	// Used by Designer to access the source document.
	 @SuppressWarnings("unused")
	

	
	public SimpleOrder_doc_product() {
	}

	public java.lang.String getId()  {
		
		return id;
	}

	public void setId(java.lang.String id)  {
		this.id = id;
	}

	public java.lang.String getName()  {
		
		return name;
	}

	public void setName(java.lang.String name)  {
		this.name = name;
	}

	public java.lang.String getPrice()  {
		
		return price;
	}

	public void setPrice(java.lang.String price)  {
		this.price = price;
	}
	
	

}