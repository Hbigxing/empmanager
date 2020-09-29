package com.tjetc.empmanager.filter;

import javax.jws.WebParam;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*@WebFilter(filterName = "characterFilter",urlPatterns = "/*",initParams = {
        @WebParam(name = "character",)
})*/
public class CharacterFilter implements Filter {
    private String character;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法");
        this.character= filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器的方法");
        servletRequest.setCharacterEncoding(this.character);
        servletResponse.setCharacterEncoding(this.character);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public boolean getAddress(HttpServletRequest request){
        String path=request.getContextPath();
        String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        System.out.println(url);
        String referer=request.getHeader("referer");
        System.out.println(referer);
        return referer!=null&&referer.startsWith(url);
    }

    @Override
    public void destroy() {
        System.out.println("这是过滤器的销毁方法");
    }
}
