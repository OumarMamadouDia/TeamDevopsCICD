package caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

/**
 * Web Service Client bean generated for 
 * caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.getProductList.
 */
@ManagedBean(name = "GetProductList")
@SessionScoped
@ExpireWithPageFlow
@DTManagedBean(beanType = BeanType.DEFAULT)
public class GetProductList extends com.webmethods.caf.faces.data.ws.wss.WSSContentProvider {

	private static final long serialVersionUID = 3790205430925323264L;
	
	/**
	 * Constructor
	 */
	public GetProductList() {
		super(caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.class,  // port type proxy class
			"getProductList", // method to invoke
			new String[] { "getProductList", } // method parameter names
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

		private static final long serialVersionUID = 1555474521274329088L;
		
		public Parameters() {
		}
	
	  
		private caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetProductListE getProductList  = new  caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetProductListE() ;

		public caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetProductListE getGetProductList() {
			return getProductList;
		}

		public void setGetProductList(caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetProductListE getProductList) {
			this.getProductList = getProductList;
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
	public caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetProductListResponseE getResult() {
		return (caf.war.simpleOrderTasks.wsclient.simpleorder.ws.uiservices.SimpleOrderWsUiServicesStub.GetProductListResponseE)result;
	}
	
	
}