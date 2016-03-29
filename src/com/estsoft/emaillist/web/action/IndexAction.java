package com.estsoft.emaillist.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.db.MySQLWebDBConnection;
import com.estsoft.emaillist.dao.EmailListDao;
import com.estsoft.emaillist.vo.EmailListVo;
import com.estsoft.web.WebUtil;
import com.estsoft.web.action.Action;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// default action ( list, index )
		EmailListDao dao = new EmailListDao( new MySQLWebDBConnection() );
		List<EmailListVo> list = dao.getList();
		
		// 포워딩전에 JSP로 보낼 데이터를 request범위(scope)에 저장한다.
		request.setAttribute( "list", list );
		
		// forwarding (request 확장, request dispatcher )
		WebUtil.forward(request, response, "/WEB-INF/views/index.jsp" );
	}

}
