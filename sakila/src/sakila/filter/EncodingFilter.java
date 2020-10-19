package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // 모든 요청을 가로챈다
public class EncodingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EncodingFilter 실행 : request UTF-8 인코딩");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}
	public EncodingFilter() {}
	public void destroy() {}
	public void init(FilterConfig fConfig) throws ServletException {}
}