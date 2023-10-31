package egovframework.stylerit.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired ReloadableResourceBundleMessageSource ms;

	Logger logger = LoggerFactory.getLogger(getClass());
		
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean pass = true;

        HttpSession session = request.getSession();
        
        if (session.getAttribute("login") == null) {        	
        	
            String alertMessage = ms.getMessage("signIn.falseMessage", null, null);
            String redirectURL = ms.getMessage("signIn.falseRedirectURL", null, null);
            String script = ms.getMessage("signIn.script", null, null);
            
            String fullScript = String.format(script, alertMessage, redirectURL);

            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println(fullScript);

            pass = false;
        }

        return pass;
    }
}
