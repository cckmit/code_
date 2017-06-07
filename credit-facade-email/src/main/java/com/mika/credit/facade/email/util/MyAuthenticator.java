package com.mika.credit.facade.email.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.io.Serializable;

public class MyAuthenticator extends Authenticator implements Serializable {
	String userName = null;
	String password = null;

	public MyAuthenticator() {
	}

	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
