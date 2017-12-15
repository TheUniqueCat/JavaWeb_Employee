

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
@WebFilter(urlPatterns = {"*.jsp"}, initParams = {@WebInitParam(name = "allIndex", value = "allIndex.jsp"),
		@WebInitParam(name = "login", value = "login.jsp"),
		@WebInitParam(name = "register", value = "register.jsp")})
public class SessionCheckFilter implements Filter {

    private FilterConfig config;

	/**
     * Default constructor. 
     */
    public SessionCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String allIndex = config.getInitParameter("allIndex");
		String login = config.getInitParameter("login");
		String register = config.getInitParameter("register");
		HttpSession session = ((HttpServletRequest) request).getSession();
		String requestPath = ((HttpServletRequest) request).getServletPath();
		
		if(session.getAttribute("email")!= null || requestPath.endsWith(allIndex)
				||requestPath.endsWith(login) || requestPath.endsWith(register)){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher(allIndex).forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
