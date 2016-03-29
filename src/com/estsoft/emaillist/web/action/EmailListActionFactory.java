package com.estsoft.emaillist.web.action;

import com.estsoft.web.action.Action;
import com.estsoft.web.action.ActionFactory;

public class EmailListActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if( "insert".equals( actionName ) ) {
			action = new InsertAction();
		} else if( "form".equals( actionName ) ) {
			action = new FormAction();
		} else {
			action = new IndexAction();
		}
		return action;
	}

}
