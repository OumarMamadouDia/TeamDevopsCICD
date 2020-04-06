package caf.war.simpleOrderTasks.taskclient.is.document;

 import java.io.Serializable;

/**
 * IS document wrapper
 */
public  class SimpleOrder_doc_order extends java.lang.Object implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// IS Document type used to generate this class
	public static final String DOCUMENT_TYPE = "simpleOrder.doc:order";
	private java.lang.String orderId;
	private java.lang.String orderdate;
	private java.lang.String checkDate;
	private java.lang.String checkedBySales;
	private caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_customer customer = null;
	private caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_product[] products = null;
	public static String[][] FIELD_NAMES = new String[][] {{"orderId", "orderId"},{"orderdate", "orderdate"},{"checkDate", "checkDate"},{"checkedBySales", "checkedBySales"},{"customer", "customer"},{"products", "products"},{"totalPrice", "totalPrice"},
	};
	private java.lang.String totalPrice;

	// Used by Designer to access the source document.
	 @SuppressWarnings("unused")
	

	
	public SimpleOrder_doc_order() {
	}

	public java.lang.String getOrderId()  {
		
		return orderId;
	}

	public void setOrderId(java.lang.String orderId)  {
		this.orderId = orderId;
	}

	public java.lang.String getOrderdate()  {
		
		return orderdate;
	}

	public void setOrderdate(java.lang.String orderdate)  {
		this.orderdate = orderdate;
	}

	public java.lang.String getCheckDate()  {
		
		return checkDate;
	}

	public void setCheckDate(java.lang.String checkDate)  {
		this.checkDate = checkDate;
	}

	public java.lang.String getCheckedBySales()  {
		
		return checkedBySales;
	}

	public void setCheckedBySales(java.lang.String checkedBySales)  {
		this.checkedBySales = checkedBySales;
	}

	public caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_customer getCustomer()  {
		if (customer == null) {
			customer = new caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_customer();
		}
		return customer;
	}

	public void setCustomer(caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_customer customer)  {
		this.customer = customer;
	}

	public caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_product[] getProducts()  {
		if (products == null) {
			//TODO: create/set default value here
		}
		return products;
	}

	public void setProducts(caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_product[] products)  {
		this.products = products;
	}

	public java.lang.String getTotalPrice()  {
		
		return totalPrice;
	}

	public void setTotalPrice(java.lang.String totalPrice)  {
		this.totalPrice = totalPrice;
	}
	
	

}