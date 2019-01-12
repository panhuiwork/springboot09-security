package com.geral.springboot09.security.service.entity;

import java.util.HashMap;
import java.util.Map;

public class DataUser {

	public static Map<String,User> usermap=new HashMap<String, User>();
	static 
	{
		if(usermap.size()==0) 
		{
			usermap.put("panpan1", new User(1,"panpan1","123456","VIP1"));
			usermap.put("panpan2", new User(2,"panpan2","123456","VIP2"));
			usermap.put("panpan3", new User(3,"panpan3","123456","VIP3"));
		}
	}
	public static User getUser(String username) 
	{
		if(usermap.containsKey(username))return usermap.get(username);
		return null;
	}
}
