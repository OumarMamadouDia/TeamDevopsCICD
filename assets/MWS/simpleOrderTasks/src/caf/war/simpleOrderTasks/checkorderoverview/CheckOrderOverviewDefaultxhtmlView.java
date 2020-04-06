/**
 * 
 */
package caf.war.simpleOrderTasks.checkorderoverview;

/**
 * @author sagadmin
 *
 */

import com.webmethods.caf.faces.data.task.TaskDisplayProvider;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

@ManagedBean(name = "CheckOrderOverviewDefaultxhtmlView")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(displayName = "CheckOrderOverview/default", beanType = BeanType.PAGE)
public class CheckOrderOverviewDefaultxhtmlView extends com.webmethods.caf.faces.bean.BasePageBean {


	private static final long serialVersionUID = 1L;
	private static final String[][] INITIALIZE_PROPERTY_BINDINGS = new String[][] {
		{"#{activePreferencesBean.currentTab}", "TaskData"},
	};

	// binding the Task Display Provider to the current taskID (passed to the Portlet Bean via the URL)
	private TaskDisplayProvider taskDisplayProvider = null;
	private static final String[][] TASKDISPLAYPROVIDER_PROPERTY_BINDINGS = new String[][] { {
			"#{TaskDisplayProvider.taskID}", "#{CheckOrderOverview.taskID}" }, };
	private transient caf.war.simpleOrderTasks.checkorderoverview.CheckOrderOverview checkOrderOverview = null;
	private caf.war.simpleOrderTasks.taskclient.CheckOrder checkOrder = null;
	private static final String[][] CHECKORDER_PROPERTY_BINDINGS = new String[][] {
		{"#{CheckOrder.taskID}", "#{CheckOrderOverview.taskID}"},
	};

	/**
	 * Initialize page
	 */
	public String initialize() {
		try {
		    resolveDataBinding(INITIALIZE_PROPERTY_BINDINGS, null, "initialize", true, false);
		} catch (Exception e) {
			error(e);
			log(e);
		}
		return null;	
	}

	/*
	 * Get the Task Display Provider for the current taskID
	 */
	public TaskDisplayProvider getTaskDisplayProvider() {
		if (taskDisplayProvider == null) {
			taskDisplayProvider = (TaskDisplayProvider) resolveExpression("#{TaskDisplayProvider}");
		}
		resolveDataBinding(TASKDISPLAYPROVIDER_PROPERTY_BINDINGS,
				taskDisplayProvider, "taskDisplayProvider", false, false);
		return taskDisplayProvider;
	}

	public caf.war.simpleOrderTasks.checkorderoverview.CheckOrderOverview getCheckOrderOverview()  {
		if (checkOrderOverview == null) {
		    checkOrderOverview = (caf.war.simpleOrderTasks.checkorderoverview.CheckOrderOverview)resolveExpression("#{CheckOrderOverview}");
		}
		return checkOrderOverview;
	}

	public caf.war.simpleOrderTasks.taskclient.CheckOrder getCheckOrder()  {
		if (checkOrder == null) {
		    checkOrder = (caf.war.simpleOrderTasks.taskclient.CheckOrder)resolveExpression("#{CheckOrder}");
		}
	
	    resolveDataBinding(CHECKORDER_PROPERTY_BINDINGS, checkOrder, "checkOrder", false, false);
		return checkOrder;
	}

}