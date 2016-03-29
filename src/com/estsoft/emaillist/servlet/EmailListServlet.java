package com.estsoft.emaillist.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.emaillist.web.action.EmailListActionFactory;
import com.estsoft.emaillist.web.action.FormAction;
import com.estsoft.emaillist.web.action.IndexAction;
import com.estsoft.emaillist.web.action.InsertAction;
import com.estsoft.web.action.Action;
import com.estsoft.web.action.ActionFactory;

@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request, response );	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식의 한글(UTF-8) 데이터 처리
		request.setCharacterEncoding( "UTF-8" );
		
		// 요청분석
		String actionName = request.getParameter( "a" );
		ActionFactory actionFactory = new EmailListActionFactory();
		Action action = actionFactory.getAction( actionName );
		
		// 액션 실행
		action.execute(request, response);
	}
}