package caf.war.simpleOrderTasks.taskclient;

 

import com.webmethods.portal.service.task.ITaskData;
import com.webmethods.caf.faces.data.ContentProviderException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;
 
/**
 * Task Client bean for 'enter Order' task.
 */ 
@ManagedBean(name = "EnterOrder")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(beanType = BeanType.DEFAULT)
public class EnterOrder extends com.webmethods.caf.faces.data.task.impl.TaskContentProviderExtended {

	private static final long serialVersionUID = 8320696593236234240L;
	
	/**
	 * Globally unique task type id
	 */
	private static final String TASK_TYPE_ID = "3CFF5382-0B3F-985F-0E08-CCE2B0FE5382";

	/**
	 * Default constructor
	 */
	public EnterOrder() {
		super();
		setTaskTypeID(TASK_TYPE_ID);
	}
	
	/**
	 * Task Data Object
	 */
	public static class TaskData extends com.webmethods.caf.faces.data.task.impl.TaskData {

		private static final long serialVersionUID = 65036707468167168L;
		 
			
		public static String[][] FIELD_NAMES = new String[][] {{"simpleOrder", "simpleOrder"},
		};


		private caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder simpleOrder = null;


		public static final String[] INPUTS = new String[] {"simpleOrder", };


		public static final String[] OUTPUTS = new String[] {"simpleOrder", };
 
		public TaskData() {
		}

		public caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder getSimpleOrder()  {
			if (simpleOrder == null) {
				simpleOrder = new caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder();
			}
			return simpleOrder;
		}

		public void setSimpleOrder(caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_simpleOrder simpleOrder)  {
			this.simpleOrder = simpleOrder;
		}
		
		
		
	}
	
	/**
	 * Return current task data object
	 * @return current task data
	 */
	public TaskData getTaskData() {
		return (TaskData)getValue(PROPERTY_KEY_TASKDATA);
	}

	/**
	 * Creates new task data object
	 * @return newly created task data object
	 */	
	protected ITaskData newTaskData() throws ContentProviderException {
		return new TaskData();
	}

}