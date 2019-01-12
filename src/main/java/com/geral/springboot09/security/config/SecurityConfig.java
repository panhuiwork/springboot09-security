package com.geral.springboot09.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.geral.springboot09.security.service.CustAuthenticationProvider;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//定制请求的授权规则
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/level1/**").hasRole("VIP1")
		.antMatchers("/level2/**").hasRole("VIP2")
		.antMatchers("/level3/**").hasRole("VIP3");
		//开启自动配置登录的功能，如果没有登录权限就会来到登录页面
		http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
//		.failureForwardUrl("/errlogin")
		//1. /login来到登录页
		//2.重定向到/login?err表示登录失败
		//3.更多详细规定
		//4.默认/login代表默认登录
		//5.一但定制loginPage，那么loginPage的post请求就是登陆
		//6.自定义登录传递的传参名
		
		//开启自动配置注销功能
		//http.logout();
		
		http.logout().logoutSuccessUrl("/"); //注销后回到首页
		//1.访问/logout 表示注销，退出
		
		//开启记住我
		http.rememberMe().rememberMeParameter("remeber");
		//登录成功后，将cookie发送浏览器保存，以后登录带上这个cookie,只要通过检查就可以免登录
		//如果点击注销也会删除cookie
	}

////	//写在内存中的  认证规则
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1","VIP2").and()
//		.withUser("lisi").password("123456").roles("VIP2","VIP3").and()
//		.withUser("wangwu").password("123456").roles("VIP1","VIP3");
//	}
	
	
	/**
	 * 根据数据库查询来认证
	 */
	@Autowired
	CustAuthenticationProvider customUserService;
	// 认证规则
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService);
	}
	
	
	
}
