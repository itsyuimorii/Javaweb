package com.yuimorii.servlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public static void main(String[] args) {

    }
    public HelloServlet() {
        System.out.println("1 Constructor method");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init");
        //1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet:" + servletConfig.getServletName());
        //2、获取初始化参数init-param
        System.out.println("The value of the initialization parameter username is：" + servletConfig.getInitParameter("username"));
        System.out.println("The value of the initialization parameter url is;" + servletConfig.getInitParameter("url"));
        //3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === Hello Servlet 被访问了");
        // 類型轉換 （因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }

    }  /**
     * 做get请求的操作
     */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }
    /**
     * 做post请求的操作
     */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 . destroy销毁方法");

    }
}
