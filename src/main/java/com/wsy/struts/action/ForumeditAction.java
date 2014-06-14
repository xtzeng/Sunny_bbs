/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wsy.struts.action;

import java.util.List;

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

import com.wsy.struts.bean.ForumBean;
import com.wsy.struts.bean.LoginBean;
import com.wsy.struts.form.ForumeditForm;

/** 
 * MyEclipse Struts
 * Creation date: 11-13-2007
 * 
 * XDoclet definition:
 * @struts.action path="/forumedit" name="forumeditForm" input="/forumedit.jsp" scope="request" validate="true"
 */
public class ForumeditAction extends Action {
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
		ForumeditForm forumeditForm = (ForumeditForm) form;// TODO Auto-generated method stub
		ActionErrors message=new ActionErrors();
		DataSource datasource = getDataSource(request,"dataSources");//取struts配置的数据源
		HttpSession session=request.getSession();
		String forumid=(String)session.getAttribute("idforum");
		String userid=(String)session.getAttribute("idlogin");
		String forumname=forumeditForm.getForumname();
		String manager=forumeditForm.getManager();
		//System.out.println(id);
		//System.out.println(forumname);
		//System.out.println(manager);
		ForumBean forum=new ForumBean();
		int i=forum.UpdateRecord(forumname, manager, datasource);
		LoginBean login=new LoginBean();
		int j=login.UpdateRecord(userid, manager, "bz", datasource);
		if(i==1&&j==1){
			message.add(ActionErrors.GLOBAL_MESSAGE,new ActionError("success.edit"));
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(message);
			saveErrors(request,actionErrors);
			List listforum=(List)forum.getRecord(datasource);
			session.setAttribute("listforum", listforum);
		}
		return mapping.getInputForward();
	}
}