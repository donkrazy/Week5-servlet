package com.estsoft.emaillist.dao.test;

import java.util.List;

import com.estsoft.db.MySQLWebDBConnection;
import com.estsoft.emaillist.dao.EmailListDao;
import com.estsoft.emaillist.vo.EmailListVo;

public class EmailListDaoTest {

	public static void main(String[] args) {
		insertTest();
		getListTest();
	}

	public static void insertTest(){
		EmailListVo vo = new EmailListVo();
		vo.setFirstName( "둘" );
		vo.setLastName( "리" );
		vo.setEmail( "dooly@gmail.com" );
		
		EmailListDao dao = new EmailListDao( new MySQLWebDBConnection() );
		dao.insert(vo);
	}	
	
	public static void getListTest(){
		EmailListDao dao = new EmailListDao( new MySQLWebDBConnection() );
		List<EmailListVo> list = dao.getList();
		for( EmailListVo vo : list ) {
			System.out.println( vo );
		}
	}
}
