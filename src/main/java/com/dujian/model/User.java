package com.dujian.model;


import com.dujian.base.model.BaseUser;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User().dao();

	public List<User> findUsersByAge(Integer age){
		if (age != null)
		return dao.find("select * from user where age>"+age);
		return dao.find("select * from user");
	}
}
