package sakila.filter;

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

@WebFilter("/auth/*") // auth로 시작하는 요청을 가로챈다.
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginFilter 실행 : session 검사");
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("loginStaff") == null) {
			System.out.println("로그인 후 접근!");
			((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath() + "/LoginServlet");
			return;
		}
		chain.doFilter(request, response);
	}
    public LoginFilter() {}
	public void destroy() {}
	public void init(FilterConfig fConfig) throws ServletException {}
}