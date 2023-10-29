package egovframework.stylerit.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class GradeInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        boolean pass = true;

        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null || !session.getAttribute("login").equals("designer") || !session.getAttribute("D_AUTR_CD").equals("ADMIN")) {
            String alertMessage = "접근 권한이 없습니다. ";
            String redirectURL = "/";
            String script = "<script>alert('%s');location.href='%s';</script>";
            String fullScript = String.format(script, alertMessage, redirectURL);

            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println(fullScript);

            pass = false;
        }

        return pass;
    }
	
}
