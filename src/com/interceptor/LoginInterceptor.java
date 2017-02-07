package com.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import pojo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = -452631678329497541L;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
    ActionContext context = actionInvocation.getInvocationContext();
    HttpServletRequest request = ServletActionContext.getRequest();
    String path = request.getRequestURI();
    if(path.indexOf("questionAction")!=-1 && (User)context.getSession().get("experUser")!=null){
    	 return actionInvocation.invoke();
    }else{
    	User user = (User)context.getSession().get("adminUser");
            if(user ==  null){
                return "loginDirect";
            }else{
                return actionInvocation.invoke();
            }
        }
    }
}
