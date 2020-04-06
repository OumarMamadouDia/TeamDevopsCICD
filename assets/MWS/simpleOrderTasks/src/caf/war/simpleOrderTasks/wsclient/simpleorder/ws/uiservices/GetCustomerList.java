package caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

/**
 * Web Service Client bean generated for 
 * caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.getCustomerList.
 */
@ManagedBean(name = "GetCustomerList")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(beanType = BeanType.DEFAULT)
public class GetCustomerList extends com.webmethods.caf.faces.data.ws.wss.WSSContentProvider {

	private static final long serialVersionUID = 1245866757424241664L;
	
	/**
	 * Constructor
	 */
	public GetCustomerList() {
		super(caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.class,  // port type proxy class
			"getCustomerList", // method to invoke
			new String[] { "getCustomerList", } // method parameter names
		);
		
		// init wsclient
		initParams();
		
		
		// parameters bean
		parameters = new Parameters();
			
		// initial result
		result = null;
	}
	
	
	/**
	 * Method parameters bean
	 */
	public class Parameters implements Serializable {

		private static final long serialVersionUID = 464759865114482688L;
		
		public Parameters() {
		}
	
	  
		private caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetCustomerListE getCustomerList  = new  caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetCustomerListE() ;

		public caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetCustomerListE getGetCustomerList() {
			return getCustomerList;
		}

		public void setGetCustomerList(caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetCustomerListE getCustomerList) {
			this.getCustomerList = getCustomerList;
		}
		
	}
	
	/**
	 * Return method invocation parameters bean
	 */
	public Parameters getParameters() {
		return (Parameters)parameters;
	}	
	


	
	/**
	 * Return method invocation result bean
	 */
	public caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetCustomerListResponseE getResult() {
		return (caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetCustomerListResponseE)result;
	}
	
	
}