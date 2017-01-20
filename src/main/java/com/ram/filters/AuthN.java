package com.ram.filters;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ram.model.AccessToken;

/**
 * Servlet Filter implementation class AuthN
 */
@WebFilter("/postAuth")
public class AuthN implements Filter {

    /**
     * Default constructor. 
     */
    public AuthN() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		
		System.out.println("doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String code = null;
		Map<String, String> params = new HashMap<>();

		HttpSession session = httpRequest.getSession();
		for (String key : request.getParameterMap().keySet()) {
			params.put(key, httpRequest.getParameterMap().get(key)[0]);
			session.setAttribute(key, httpRequest.getParameterMap().get(key)[0]);
			
				
			System.out.println("key -" + key + "value ->" + httpRequest.getParameterMap().get(key)[0] );
			
		}
		RequestDispatcher rd = httpRequest.getRequestDispatcher("/WEB-INF/code.jsp"); 
		rd.forward(request, response);
		return;
		
//		HttpSession session = httpRequest.getSession();
//		AccessToken accssToken = new AccessToken();
//		accssToken.setAccessToken("access token generated");
//		accssToken.setExpires(12345L);
//		
//		session.setAttribute("accessToken", "AccesToken Vlaue");
//		
//		RequestDispatcher rd = httpRequest.getRequestDispatcher("/WEB-INF/index.jsp"); 
//		rd.forward(request, response);
//		return;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
