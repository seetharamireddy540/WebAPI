package com.ram.filters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

/**
 * Servlet Filter implementation class AADAuthN
 */
@WebFilter("/token")
public class TokenFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TokenFilter() {
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

		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
       
		HttpSession session = httpRequest.getSession();
		String code = httpRequest.getParameter("code");
		session.setAttribute("code", code);
		session.setAttribute("redirectUlr", URLEncoder.encode("http://localhost:8080/Project1/postAuth", "UTF-8"));
		session.setAttribute("client_id", "bbf04023-5fd7-4b87-8616-19df807bbd87");

		
	
		RequestDispatcher rd = httpRequest.getRequestDispatcher("/WEB-INF/token.jsp"); 
		rd.forward(request, response);
		return;
	
	}

	 private static String getRedirectUrl(String code)
	            throws UnsupportedEncodingException {
		 
		 StringBuilder redirectUrl = new StringBuilder();
		 redirectUrl.append("https://login.microsoftonline.com/542e52ae-1078-46e7-87d2-15622a28f967/oauth2/token?")
		 .append("grant_type=authorization_code")
		 .append("&code=" + code)
		 .append("&scope=patient/*.read&response_mode=form_post&redirect_uri=")
		 .append(URLEncoder.encode("http://localhost:8080/Project1/postAuth", "UTF-8"))
		 .append("&client_id=bbf04023-5fd7-4b87-8616-19df807bbd87")
		 .append("&resource=https%3a%2f%2fgraph.windows.net&state=123");
		 return redirectUrl.toString();
	    }
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
