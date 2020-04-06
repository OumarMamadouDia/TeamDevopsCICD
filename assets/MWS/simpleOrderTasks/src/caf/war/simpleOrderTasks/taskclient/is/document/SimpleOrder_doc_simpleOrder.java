package caf.war.simpleOrderTasks.taskclient.is.document;

 import java.io.Serializable;

/**
 * IS document wrapper
 */
public  class SimpleOrder_doc_simpleOrder extends java.lang.Object implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// IS Document type used to generate this class
	public static final String DOCUMENT_TYPE = "simpleOrder.doc:simpleOrder";

	// Used by Designer to access the source document.
	 @SuppressWarnings("unused")
	private static final String DOCUMENT_SRC = "http://localhost:5555";
	private caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_order order = null;
	public static String[][] FIELD_NAMES = new String[][] {{"order", "order"},{"processControl", "processControl"},
	};
	private caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder.ProcessControl processControl = null;

	
	public SimpleOrder_doc_simpleOrder() {
	}


	public caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_order getOrder()  {
		if (order == null) {
			order = new caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_order();
		}
		return order;
	}


	public void setOrder(caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_order order)  {
		this.order = order;
	}


	/**
	 * IS document wrapper
	 */
	public static class ProcessControl extends java.lang.Object implements Serializable {
	
		
		private static final long serialVersionUID = 1L;
		private java.lang.String checked;
		private java.lang.String canceled;
		public static String[][] FIELD_NAMES = new String[][] {{"checked", "checked"},{"canceled", "canceled"},{"newCustomer", "newCustomer"},
		};
		private java.lang.String newCustomer;
		
	
		// Used by Designer to access the source document.
		 @SuppressWarnings("unused")
		
	
		
		public ProcessControl() {
		}


		public java.lang.String getChecked()  {
			
			return checked;
		}


		public void setChecked(java.lang.String checked)  {
			this.checked = checked;
		}


		public java.lang.String getCanceled()  {
			
			return canceled;
		}


		public void setCanceled(java.lang.String canceled)  {
			this.canceled = canceled;
		}


		public java.lang.String getNewCustomer()  {
			
			return newCustomer;
		}


		public void setNewCustomer(java.lang.String newCustomer)  {
			this.newCustomer = newCustomer;
		}
		
		
	
	}


	public caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder.ProcessControl getProcessControl()  {
		if (processControl == null) {
			processControl = new caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder.ProcessControl();
		}
		return processControl;
	}


	public void setProcessControl(caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder.ProcessControl processControl)  {
		this.processControl = processControl;
	}
	
	

}