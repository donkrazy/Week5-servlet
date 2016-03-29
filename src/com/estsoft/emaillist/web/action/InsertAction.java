package com.estsoft.emaillist.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.db.MySQLWebDBConnection;
import com.estsoft.emaillist.dao.EmailListDao;
import com.estsoft.emaillist.vo.EmailListVo;
import com.estsoft.web.WebUtil;
import com.estsoft.web.action.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter( "fn" );
		String lastName = request.getParameter( "ln" );
		String email = request.getParameter( "email" );
		
		EmailListVo vo = new EmailListVo();
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		
		EmailListDao dao = new EmailListDao( new MySQLWebDBConnection() );
		dao.insert(vo);
		
		WebUtil.redirect( request, response, "/emaillist2/el" );
	}

}
