package caf.war.simpleOrderTasks.taskclient;

 

import com.webmethods.portal.service.task.ITaskData;
import com.webmethods.caf.faces.data.ContentProviderException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;
 
/**
 * Task Client bean for 'check Order' task.
 */ 
@ManagedBean(name = "CheckOrder")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(beanType = BeanType.DEFAULT)
public class CheckOrder extends com.webmethods.caf.faces.data.task.impl.TaskContentProviderExtended {

	private static final long serialVersionUID = 4480488137983806464L;
	
	/**
	 * Globally unique task type id
	 */
	private static final String TASK_TYPE_ID = "32F29809-D958-A997-7236-DB984E355689";

	/**
	 * Default constructor
	 */
	public CheckOrder() {
		super();
		setTaskTypeID(TASK_TYPE_ID);
	}
	
	/**
	 * Task Data Object
	 */
	public static class TaskData extends com.webmethods.caf.faces.data.task.impl.TaskData {

		private static final long serialVersionUID = 4893630816969967616L;
		 
			
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