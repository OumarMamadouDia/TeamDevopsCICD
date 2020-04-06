package caf.war.simpleOrderTasks.taskclient;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

@ManagedBean(name = "EnterOrderRuleContext")
@SessionScoped
@DTManagedBean(displayName = "enter Order Rule Context", beanType = BeanType.DEFAULT)
public class EnterOrderRuleContext  extends  com.webmethods.caf.faces.data.task.impl.BaseTaskRuleContext {
}