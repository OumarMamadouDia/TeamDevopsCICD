/**
 * 
 */
package caf.war.simpleOrderTasks.enterorderview;

/**
 * @author sagadmin
 *
 */

import com.webmethods.caf.faces.data.dir.PrincipalModel;
import com.webmethods.caf.faces.data.dir.PrincipalModelList;
import com.webmethods.caf.faces.data.task.impl.TaskContentProvider;
import com.webmethods.caf.faces.data.task.impl.TaskVotingServiceFactory;
import com.webmethods.caf.wsclient.AuthCredentials;
import com.webmethods.portal.mech.task.voting.details.pojo.TaskVoteEntry;

import caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_product;
import caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.GetCustomerList;
import caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.GetProductList;
import caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.Customer;
import caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetCustomerListE;
import caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.Product;

import com.softwareag.caf.shared.task.core.model.TaskVotingTable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

@ManagedBean(name = "EnterOrderViewDefaultxhtmlView")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(displayName = "EnterOrderView/default", beanType = BeanType.PAGE)
public class EnterOrderViewDefaultxhtmlView extends com.webmethods.caf.faces.bean.task.BaseTaskDetailsPageBean {

 
	/**
	 * Determines if a de-serialized file is compatible with this class.
	 *
	 * Maintainers must change this value if and only if the new version
	 * of this class is not compatible with old versions. See Sun docs
	 * for <a href=http://java.sun.com/j2se/1.5.0/docs/guide/serialization/spec/version.html> 
	 * details. </a>
	 */
	private static final long serialVersionUID = 1L;
	private com.webmethods.caf.faces.data.task.TaskDisplayProvider taskDisplayProvider = null;
	private static final String[][] TASKDISPLAYPROVIDER_PROPERTY_BINDINGS = new String[][] {
		{"#{TaskDisplayProvider.taskID}", "#{EnterOrderView.taskID}"},
	};
	
	/**
	 * Has permission to view voting details
	 */
	public boolean getHasVotingDetailsPermission() {
		return getEnterOrder().getCanUserViewTaskVotingStatistics();
	}
	
	public List<TaskVoteEntry> getListOfVotingTableEntries() {
		List<TaskVoteEntry> listOfVotingTableEntries = null;
		try {
			listOfVotingTableEntries = TaskVotingServiceFactory.getVotingService().getTaskVotesDetails(Integer.valueOf(getEnterOrder().getTaskID()));
		} catch (Exception e) {
            this.error(e);
            this.log(e);
        }
		
		return listOfVotingTableEntries;
	}
	
	/**
	 * Get task voting strategy
	 */
	public String getTaskVotingStrategy() {
        final TaskVotingTable table = TaskVotingServiceFactory.getVotingService().parseVotingTable(getEnterOrder().getTaskInfo().getTaskVotingTable());
        return table.getStrategy();
    }
    
    /**
	 * Get task voting threshold
	 */
    public String getTaskVotingThreshold() {
        final TaskVotingTable table = TaskVotingServiceFactory.getVotingService().parseVotingTable(getEnterOrder().getTaskInfo().getTaskVotingTable());
        return table.getValue();
    }
    
	/**
	 * Get count of all users assigned to the task
	 */
	 public int getTotalUserAssignedCount() {
        int totalUserAssignedCount = 0;
        try {
            totalUserAssignedCount = TaskVotingServiceFactory.getVotingService().getTotalUserAssignedCount(Integer.valueOf(getEnterOrder().getTaskID()));
        }
        catch (Exception e) {
            this.error(e);
            this.log(e);
        }
        return totalUserAssignedCount;
    }
    
	 /**
	 * Get all task votes by status
	 */
    public Map<String, Integer> getTaskVotingCount() {
        Map<String, Integer> map = null;
        try {
            map = (Map<String, Integer>)TaskVotingServiceFactory.getVotingService().getTaskVotesCountByStatus(Integer.valueOf(getEnterOrder().getTaskID()));
        }
        catch (Exception e) {
            this.error(e);
            this.log(e);
        }
        return map;
    }
    
	public com.webmethods.caf.faces.data.task.TaskDisplayProvider getTaskDisplayProvider()  {
		if (taskDisplayProvider == null) {
		    taskDisplayProvider = (com.webmethods.caf.faces.data.task.TaskDisplayProvider)resolveExpression("#{TaskDisplayProvider}");
		}
	    resolveDataBinding(TASKDISPLAYPROVIDER_PROPERTY_BINDINGS, taskDisplayProvider, "taskDisplayProvider", false, false);
		return taskDisplayProvider;
	}

	/**
	 * Cancel button action handler
	 */
	public String cancelView() {
		try {
			// just redirect to return (finish) url
			String url = getEnterOrderView().getFinishUrl();
			if (url != null && url.length() > 0) {
				getFacesContext().getExternalContext().redirect(url);
			}
		} catch (Exception e) {
			error(e);
			log(e);
		}
		return null;
	}
	
	public String doRejectOrder() {
		getEnterOrder().getTaskData().getSimpleOrder().getProcessControl().setCanceled("true");
		completeTask();
		return null;
	}

	public String doCompleteOrder() {
		if ( "".equals(getEnterOrder().getTaskData().getSimpleOrder().getOrder().getCustomer().getId())) {
			getEnterOrder().getTaskData().getSimpleOrder().getProcessControl().setNewCustomer("true");
		} else {
			getEnterOrder().getTaskData().getSimpleOrder().getProcessControl().setNewCustomer("false");			
		}
		completeTask();
		return null;
	}
	
	/**
	 * Complete button action handler
	 */
	public String completeTask() {
		try {
			if( !getEnterOrder().isUpdateable() ){
				String errMsg = "You must accept a task before updating it";	//view.task.pagebean.task.accept.msg
				error(errMsg);
				return null; 
			}
			// do the work
			getEnterOrder().voteComplete();
		
			// then redirect to finish url
			String url = getEnterOrderView().getFinishUrl(); 
			if (url != null && url.length() > 0) {
				getFacesContext().getExternalContext().redirect(url);
			}
		} catch (Exception e) {
			error(e);
			log(e);
		}
		return null;
	}	

	/**
	 * Submit button action handler
	 */
	public String submitTask() {
		try {
			if( !getEnterOrder().isUpdateable() ){
				String errMsg = "You must accept a task before updating it";	//view.task.pagebean.task.accept.msg
				error(errMsg);
				return null; 
			}


			// do the work
			getEnterOrder().applyChanges();
		} catch (Exception e) {
			error(e);
			log(e);
		}
		return null;
	}

	private PrincipalModelList selectedPrincipalList;

	public PrincipalModelList getPrincipalList() {
		return selectedPrincipalList;
	}
	
	public void setPrincipalList(PrincipalModelList value) {
		this.selectedPrincipalList = value;
	}
	
	/**
	 * Action Event Handler for the control with id='dialogPrincipalAssignTo'
	 */
	public String assignToPrincipals() {
		try {

			// get the current assigned principals for this task
			TaskContentProvider tp = getEnterOrder();

			List<String> currentPrincipalList = new ArrayList<String>();
			String[] currentPrincipalIDs = tp.getTaskInfo().getAssignedToList();
			if (currentPrincipalIDs != null && currentPrincipalIDs.length > 0) {
				for (int ix = 0; ix < currentPrincipalIDs.length; ix++) {
					String principalID = currentPrincipalIDs[ix];
					currentPrincipalList.add( principalID );
				}
			}
			
			// get the selected principals from the picker
			if (selectedPrincipalList != null && selectedPrincipalList.size() > 0) {
				// loop and add the selected principals to the existing list
				for (int ix = 0; ix < selectedPrincipalList.size(); ix++) {
					PrincipalModel principalModel = (PrincipalModel) selectedPrincipalList.get(ix);
					String principalID = principalModel.getPrincipalID(); 
					if( !currentPrincipalList.contains( principalID)) {
						currentPrincipalList.add( principalID );
					}
				}
			}
				
			currentPrincipalIDs = currentPrincipalList.toArray( currentPrincipalIDs);
			tp.getTaskInfo().setAssignedToList(currentPrincipalIDs);
			tp.applyChangesNoAccept();
				
			// then redirect to finish url
			//String url = getRonTask36TaskView().getFinishUrl(); 
			//if (url != null && url.length() > 0) {
			//	getFacesContext().getExternalContext().redirect(url);
			//}				
		} catch (Exception e) {
			error(e);
			log(e);
		}		
		return null;
	}
	
	private static final String[][] INITIALIZE_PROPERTY_BINDINGS = new String[][] {
		{"#{EnterOrder.reset}", null}
	};
	private transient caf.war.simpleOrderTasks.enterorderview.EnterOrderView enterOrderView = null;
	private caf.war.simpleOrderTasks.taskclient.EnterOrder enterOrder = null;
	private static final String[][] ENTERORDER_PROPERTY_BINDINGS = new String[][] {
		{"#{EnterOrder.taskID}", "#{EnterOrderView.taskID}"},
		{"#{EnterOrder.autoAccept}", "false"},
		{"#{EnterOrder.adhocRouting}", "false"},
	};

	/**
	 * Initialize page 
	 */
	
	private GetCustomerList customerList = null;
	private transient com.webmethods.caf.faces.data.object.SelectableListTableContentProvider customerProvider = null;
	private static final String[][] CUSTOMERPROVIDER_PROPERTY_BINDINGS = new String[][] {
		{"#{CustomerProvider.rowType}", "caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub$Customer"},
		{"#{CustomerProvider.rowVariable}", "customer"},
		{"#{CustomerProvider.rowIdBinding}", "#{customer.id}"},
		{"#{CustomerProvider.array}", "#{EnterOrderViewDefaultxhtmlView.customerList.result.getCustomerListResponse.customerListUI.customer}"},
	};
	private java.lang.String custLastname;
	private java.lang.String custFirstname;
	public GetCustomerList getCustomerList() {
		if (customerList == null) {
			customerList = new GetCustomerList();
			AuthCredentials ac = new AuthCredentials("Administrator", "manage");
			customerList.setAuthCredentials(ac);
		}
		return customerList;
	}
	
	private GetProductList productList = null;
	private transient com.webmethods.caf.faces.data.object.SelectableListTableContentProvider productProvider = null;
	private static final String[][] PRODUCTPROVIDER_PROPERTY_BINDINGS = new String[][] {
		{"#{ProductProvider.rowType}", "caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub$Product"},
		{"#{ProductProvider.rowVariable}", "product"},
		{"#{ProductProvider.rowIdBinding}", "#{product.id}"},
		{"#{ProductProvider.array}", "#{EnterOrderViewDefaultxhtmlView.productList.result.getProductListResponse.productListUI.product}"},
	};
	private transient com.webmethods.caf.faces.data.object.SelectableListTableContentProvider selProductsProvider = null;
	private static final String[][] SELPRODUCTSPROVIDER_PROPERTY_BINDINGS = new String[][] {
		{"#{selProductsProvider.rowType}", "caf.war.simpleOrderTasks.taskclient.is.document.SimpleOrder_doc_product"},
		{"#{selProductsProvider.rowVariable}", "product"},
		{"#{selProductsProvider.rowIdBinding}", "#{product.id}"},
		{"#{selProductsProvider.array}", "#{EnterOrderViewDefaultxhtmlView.enterOrder.taskData.simpleOrder.order.products}"},
		{"#{selProductsProvider.onDeleteRow}", "#{EnterOrderViewDefaultxhtmlView.submitTask}"},
	};
	public GetProductList getProductList() {
		if (productList == null) {
			productList = new GetProductList();
			AuthCredentials ac = new AuthCredentials("Administrator", "manage");
			productList.setAuthCredentials(ac);			
		}
		return productList;
	}
	
	public String doLoadCustomer() {
		getCustomerList().refresh();		
		return null;
	}

	public String doLoadProducts() {
		getProductList().refresh();		
		return null;
	}

	public String doRemoveProduct() {
		SimpleOrder_doc_product prod = (SimpleOrder_doc_product)getSelProductsProvider().getCurrentRow();
		String iD = prod.getId();
		List <SimpleOrder_doc_product> prodSource = Arrays.asList(getEnterOrder().getTaskData().getSimpleOrder().getOrder().getProducts());
		List <SimpleOrder_doc_product> prodTarget = new ArrayList<SimpleOrder_doc_product>();
		for (SimpleOrder_doc_product p : prodSource) {
			if (!iD.equals(p.getId())) {
				prodTarget.add(p);
			}
		}
		SimpleOrder_doc_product[] newAr = new SimpleOrder_doc_product[prodTarget.size()];
		newAr = prodTarget.toArray(newAr);
		getEnterOrder().getTaskData().getSimpleOrder().getOrder().setProducts(newAr);
		submitTask();	
		return null;
	}
	
	public String doSelectCustomer() {
		if (!getCustomerProvider().getSelectedRows().isEmpty()) {
			Customer cust = (Customer)getCustomerProvider().getSelectedRows().get(0);
			getEnterOrder().getTaskData().getSimpleOrder().getOrder().getCustomer().setId(cust.getId());
			getEnterOrder().getTaskData().getSimpleOrder().getOrder().getCustomer().setLastname(cust.getLastname());
			getEnterOrder().getTaskData().getSimpleOrder().getOrder().getCustomer().setFirstname(cust.getFirstname());
			submitTask();
		}
		return null;
	}

	public String doSelectProducts() {
		if (!getProductProvider().getSelectedRows().isEmpty()) {
			List<SimpleOrder_doc_product> productsSource = null;
			if (getEnterOrder().getTaskData().getSimpleOrder().getOrder().getProducts() != null) {
				productsSource = Arrays.asList(getEnterOrder().getTaskData().getSimpleOrder().getOrder().getProducts());				
			} else {
				productsSource = new ArrayList<SimpleOrder_doc_product>();
			}
			List<SimpleOrder_doc_product> productsTarget = new ArrayList<SimpleOrder_doc_product>();
			for (SimpleOrder_doc_product prd : productsSource) {
				productsTarget.add(prd);
			}
			for (Object obj : getProductProvider().getSelectedRows()) {
				Product prod = (Product) obj;	
				SimpleOrder_doc_product prodTarget = new SimpleOrder_doc_product();
				prodTarget.setName(prod.getName());
				prodTarget.setId(prod.getId());
				prodTarget.setPrice(prod.getPrice());
				productsTarget.add(prodTarget);
			}
			SimpleOrder_doc_product[] newAr = new SimpleOrder_doc_product[productsTarget.size()];
			newAr = productsTarget.toArray(newAr);
			getEnterOrder().getTaskData().getSimpleOrder().getOrder().setProducts(newAr);
			submitTask();
		}
		return null;
	}
	
	public String doInitNewCustomer() {
		setCustFirstname("");
		setCustLastname("");
		return null;
	}
	
	public String doSaveNewCustomer() {
		getEnterOrder().getTaskData().getSimpleOrder().getOrder().getCustomer().setId("");
		getEnterOrder().getTaskData().getSimpleOrder().getOrder().getCustomer().setLastname(getCustLastname());
		getEnterOrder().getTaskData().getSimpleOrder().getOrder().getCustomer().setFirstname(getCustFirstname());		
		submitTask();		
		return null;
	}
	
	public String initialize() {
		try {
		    resolveDataBinding(INITIALIZE_PROPERTY_BINDINGS, null, "initialize", true, false);
		} catch (Exception e) {
			error(e);
			log(e);
		}
		return null;	
	}
	
	@Override
	protected void beforeRenderResponse() {
		super.beforeRenderResponse();
		try {
			getEnterOrder().refresh();
		} catch( Exception ex ) {
			error(ex);
			log(ex);
		}
		
	}

	public caf.war.simpleOrderTasks.enterorderview.EnterOrderView getEnterOrderView()  {
		if (enterOrderView == null) {
		    enterOrderView = (caf.war.simpleOrderTasks.enterorderview.EnterOrderView)resolveExpression("#{EnterOrderView}");
		}
		return enterOrderView;
	}

	public caf.war.simpleOrderTasks.taskclient.EnterOrder getEnterOrder()  {
		if (enterOrder == null) {
		    enterOrder = (caf.war.simpleOrderTasks.taskclient.EnterOrder)resolveExpression("#{EnterOrder}");
		}
	
	    resolveDataBinding(ENTERORDER_PROPERTY_BINDINGS, enterOrder, "enterOrder", false, false);
		return enterOrder;
	}

	public com.webmethods.caf.faces.data.object.SelectableListTableContentProvider getCustomerProvider()  {
		if (customerProvider == null) {
		    customerProvider = (com.webmethods.caf.faces.data.object.SelectableListTableContentProvider)resolveExpression("#{CustomerProvider}");
		}
	
	    resolveDataBinding(CUSTOMERPROVIDER_PROPERTY_BINDINGS, customerProvider, "customerProvider", false, false);
		return customerProvider;
	}

	public java.lang.String getCustLastname()  {
		
		return custLastname;
	}

	public void setCustLastname(java.lang.String custLastname)  {
		this.custLastname = custLastname;
	}

	public java.lang.String getCustFirstname()  {
		
		return custFirstname;
	}

	public void setCustFirstname(java.lang.String custFirstname)  {
		this.custFirstname = custFirstname;
	}

	public com.webmethods.caf.faces.data.object.SelectableListTableContentProvider getProductProvider()  {
		if (productProvider == null) {
		    productProvider = (com.webmethods.caf.faces.data.object.SelectableListTableContentProvider)resolveExpression("#{ProductProvider}");
		}
	
	    resolveDataBinding(PRODUCTPROVIDER_PROPERTY_BINDINGS, productProvider, "productProvider", false, false);
		return productProvider;
	}

	public com.webmethods.caf.faces.data.object.SelectableListTableContentProvider getSelProductsProvider()  {
		if (selProductsProvider == null) {
		    selProductsProvider = (com.webmethods.caf.faces.data.object.SelectableListTableContentProvider)resolveExpression("#{SelProductsProvider}");
		}
	
	    resolveDataBinding(SELPRODUCTSPROVIDER_PROPERTY_BINDINGS, selProductsProvider, "selProductsProvider", false, false);
		return selProductsProvider;
	}

	public java.lang.Double getTotal()  {
		if (getEnterOrder().getTaskData().getSimpleOrder().getOrder().getProducts() == null) {
			return 0.0;
		}
		
		Double result = 0.0;
		for  (int i=0;i<getEnterOrder().getTaskData().getSimpleOrder().getOrder().getProducts().length;i++) {
			if (getEnterOrder().getTaskData().getSimpleOrder().getOrder().getProducts()[i] != null) {
				String price = getEnterOrder().getTaskData().getSimpleOrder().getOrder().getProducts()[i] .getPrice();
				result = result +new Double(price);
			}
		}
		return result;
	}
}
