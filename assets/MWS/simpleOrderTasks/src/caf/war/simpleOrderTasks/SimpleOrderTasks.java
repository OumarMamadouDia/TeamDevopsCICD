/**
 * 
 */
package caf.war.simpleOrderTasks;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

/**
 * @author sagadmin
 *
 */
@ManagedBean(name = "SimpleOrderTasks")
@ApplicationScoped
@DTManagedBean(displayName = "simpleOrderTasks", beanType = BeanType.APPLICATION)
public class SimpleOrderTasks extends com.webmethods.caf.faces.bean.BaseApplicationBean 
{
	public SimpleOrderTasks()
	{
		super();
		setCategoryName( "CafApplication" );
		setSubCategoryName( "simpleOrderTasks" );
	}
}