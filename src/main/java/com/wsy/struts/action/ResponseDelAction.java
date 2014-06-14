/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wsy.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.wsy.struts.bean.RegisterBean;
import com.wsy.struts.form.ResponseDelForm;

/** 
 * MyEclipse Struts
 * Creation date: 11-17-2007
 * 
 * XDoclet definition:
 * @struts.action path="/responseDel" name="responseDelForm" input="/responsetopicdel.jsp" scope="request" validate="true"
 */
public class ResponseDelAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseDelForm responseDelForm = (ResponseDelForm) form;// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		DataSource datasource = getDataSource(request,"dataSources");//取struts配置的数据源
		ActionErrors message=new ActionErrors();
		String id=(String)session.getAttribute("id");
		RegisterBean r=new RegisterBean();
		int i=r.deleResponseRecord(id, datasource);
		if(i==1){
			message.add(ActionErrors.GLOBAL_MESSAGE,new ActionError("success.del"));
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(message);
			saveErrors(request,actionErrors);
			request.setAttribute("sucess", "ok");
		}
		return mapping.getInputForward();
	}
}