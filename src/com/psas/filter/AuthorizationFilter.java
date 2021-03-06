package com.psas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			if (reqURI.indexOf("/index.xhtml") >= 0  
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource"))
			{
				chain.doFilter(request, response);
			}
		
			
			else if(reqURI.indexOf("/login.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			else if(reqURI.indexOf("/Modifyriskbank.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			
			else if(reqURI.indexOf("/ModifyBankcauses.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			
			
			
			else if(reqURI.indexOf("/Riskbank.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			else if(reqURI.indexOf("/register.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
		
			else if(reqURI.indexOf("/Rolemaster.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			
			
			else if(reqURI.indexOf("/Bankactions.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			
			else if(reqURI.indexOf("/Bankcauses.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			else if(reqURI.indexOf("/Bankcontrols.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			
			else if(reqURI.indexOf("/Bankobjectives.xhtml") >=0 
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
			}
			
			
			
			else
			{
				resp.sendRedirect(reqt.getContextPath() + "/faces/index.xhtml");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}