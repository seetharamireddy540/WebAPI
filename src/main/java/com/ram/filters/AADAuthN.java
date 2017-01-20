package com.ram.filters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AADAuthN
 */
@WebFilter("/login")
public class AADAuthN implements Filter {

	/**
	 * Default constructor.
	 */
	public AADAuthN() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setStatus(302);
		httpResponse.sendRedirect(getRedirectUrl());
		return;

	}

	private static String getRedirectUrl() throws UnsupportedEncodingException {

		StringBuilder redirectUrl = new StringBuilder();
		//OAUth2
//		redirectUrl.append("https://login.microsoftonline.com/542e52ae-1078-46e7-87d2-15622a28f967/oauth2/authorize?")
//				.append("response_type=code&scope=patient/*.read&response_mode=form_post&redirect_uri=")
//				.append(URLEncoder.encode("http://localhost:8080/Project1/postAuth", "UTF-8"))
//				.append("&client_id=86480a3c-2736-4983-ad11-15f2ce4430c7")
//				.append("&resource=https://dev-gehccloud.com/fhirapiserver&state=123&prompt=consent");

		//OpenID Connect
		redirectUrl.append("https://login.microsoftonline.com/542e52ae-1078-46e7-87d2-15622a28f967/oauth2/authorize?")
		.append("response_type=id_token code&scope=openid patient/*.read&response_mode=form_post&redirect_uri=")
		.append(URLEncoder.encode("http://localhost:8080/Project1/postAuth", "UTF-8"))
		.append("&client_id=86480a3c-2736-4983-ad11-15f2ce4430c7")
		.append("&resource=https://dev-gehccloud.com/fhirapiserver&state=123&prompt=consent")
		.append("&&nonce=7362CAEA-9CA5-4B43-9BA3-34D7C303EBA7");
		return redirectUrl.toString();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
