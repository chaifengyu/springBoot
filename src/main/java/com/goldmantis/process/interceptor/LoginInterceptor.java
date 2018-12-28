package com.goldmantis.process.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.goldmantis.process.services.common.IRedisService;
import com.goldmantis.process.utils.RequestResult;
import com.goldmantis.process.utils.SystemConstant;

public class LoginInterceptor implements HandlerInterceptor {

	private String[] paths = {"project","region"};
	
	@Autowired
	private IRedisService iRedisService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		boolean ischeck = false;
//		for (int i = 0; i < paths.length; i++) {
//			if(	request.getRequestURL().toString().contains(paths[i])) {
//				ischeck = true;
//				break;
//			}
//		}
//		if(ischeck) {
//			String token = request.getHeader("token");
//			boolean cache = iRedisService.exists(SystemConstant.USERREDISKEY + token);
//			if (cache) {
//				return true;
//			} else {
//				PrintWriter out = response.getWriter();
//				out.print(RequestResult.accessdenied("no login").toJson());
//				return false;
//			}
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// System.out.println(">>>MyInterceptor2>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println(">>>MyInterceptor2>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet
		// 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

}
