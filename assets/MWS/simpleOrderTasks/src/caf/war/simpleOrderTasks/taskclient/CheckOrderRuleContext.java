package caf.war.simpleOrderTasks.taskclient;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.webmethods.caf.faces.annotations.DTManagedBean;
import com.webmethods.caf.faces.annotations.BeanType;

@ManagedBean(name = "CheckOrderRuleContext")
@SessionScoped
@DTManagedBean(displayName = "check Order Rule Context", beanType = BeanType.DEFAULT)
public class CheckOrderRuleContext  extends  com.webmethods.caf.faces.data.task.impl.BaseTaskRuleContext {
}