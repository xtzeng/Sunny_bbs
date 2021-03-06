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

import com.wsy.struts.bean.ResponseBean;
import com.wsy.struts.bean.TopicListBean;
import com.wsy.struts.form.TopicDelForm;

/** 
 * MyEclipse Struts
 * Creation date: 11-16-2007
 * 
 * XDoclet definition:
 * @struts.action path="/topicDel" name="topicDelForm" input="/topicdel.jsp" scope="request" validate="true"
 */
public class TopicDelAction extends Action {
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
		TopicDelForm topicDelForm = (TopicDelForm) form;// TODO Auto-generated method stub
		ActionErrors message=new ActionErrors();
		HttpSession session=request.getSession();
		DataSource datasource = getDataSource(request,"dataSources");//取struts配置的数据源
		String id=(String)session.getAttribute("id");
		TopicListBean topic=new TopicListBean();
		ResponseBean responsebean=new ResponseBean();
		int i=topic.DelRecord(id, datasource);
		int j=responsebean.deleResponseRecord(id, datasource);
		System.out.println(j);
		System.out.println(id);
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