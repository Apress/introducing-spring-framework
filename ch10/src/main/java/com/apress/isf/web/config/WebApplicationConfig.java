/**
 * 
 */
package com.apress.isf.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Felipe Gutierrez
 *
 */
public class WebApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/mydocuments/*" };
    }

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
}
