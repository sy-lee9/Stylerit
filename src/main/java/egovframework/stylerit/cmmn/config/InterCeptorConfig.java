package egovframework.stylerit.cmmn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import egovframework.stylerit.cmmn.interceptor.GradeInterceptor;
import egovframework.stylerit.cmmn.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
public class InterCeptorConfig implements WebMvcConfigurer {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired LoginInterceptor loginInterceptor; //로그인 확인
	@Autowired GradeInterceptor gradeInterceptor; //권한 확인
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(loginInterceptor) 
		.addPathPatterns("/usr/**");
		
		registry.addInterceptor(gradeInterceptor) 
		.addPathPatterns("/adm/**");
		
	}	
	
}
