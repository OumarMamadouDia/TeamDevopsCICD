/**
 * 
 */
package caf.war.simpleOrderTasks.enterorderoverview;

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

@ManagedBean(name = "EnterOrderOverviewDefaultxhtmlView")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(displayName = "EnterOrderOverview/default", beanType = BeanType.PAGE)
public class EnterOrderOverviewDefaultxhtmlView extends com.webmethods.caf.faces.bean.BasePageBean {


	private static final long serialVersionUID = 1L;
	private static final String[][] INITIALIZE_PROPERTY_BINDINGS = new String[][] {
		{"#{activePreferencesBean.currentTab}", "TaskData"},
	};

	// binding the Task Display Provider to the current taskID (passed to the Portlet Bean via the URL)
	private TaskDisplayProvider taskDisplayProvider = null;
	private static final String[][] TASKDISPLAYPROVIDER_PROPERTY_BINDINGS = new String[][] { {
			"#{TaskDisplayProvider.taskID}", "#{EnterOrderOverview.taskID}" }, };
	private transient caf.war.simpleOrderTasks.enterorderoverview.EnterOrderOverview enterOrderOverview = null;
	private caf.war.simpleOrderTasks.taskclient.EnterOrder enterOrder = null;
	private static final String[][] ENTERORDER_PROPERTY_BINDINGS = new String[][] {
		{"#{EnterOrder.taskID}", "#{EnterOrderOverview.taskID}"},
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

	public caf.war.simpleOrderTasks.enterorderoverview.EnterOrderOverview getEnterOrderOverview()  {
		if (enterOrderOverview == null) {
		    enterOrderOverview = (caf.war.simpleOrderTasks.enterorderoverview.EnterOrderOverview)resolveExpression("#{EnterOrderOverview}");
		}
		return enterOrderOverview;
	}

	public caf.war.simpleOrderTasks.taskclient.EnterOrder getEnterOrder()  {
		if (enterOrder == null) {
		    enterOrder = (caf.war.simpleOrderTasks.taskclient.EnterOrder)resolveExpression("#{EnterOrder}");
		}
	
	    resolveDataBinding(ENTERORDER_PROPERTY_BINDINGS, enterOrder, "enterOrder", false, false);
		return enterOrder;
	}

}