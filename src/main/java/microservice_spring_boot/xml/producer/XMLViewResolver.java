/*****************************************************************
 * Copyright (C) Enterprise Holdings Inc (EHI). 
 * Creation Date - Feb 24, 2015 
 * Project Name - EHI Autovera Integration 
 * Module Name - delegate 
 * Created By - Cognizant Technology Solutions 
 * FOR INTERNAL USE ONLY. NOT A CONTRIBUTION.
 * 
 * This software source code contains valuable, confidential, trade secret
 * information owned by Enterprise Rent-A-Car Company and is protected by
 * copyright laws and international copyright treaties, as well as other
 * intellectual property laws and treaties.
 * 
 * ACCESS TO AND USE OF THIS SOURCE CODE IS RESTRICTED TO AUTHORIZED PERSONS WHO
 * HAVE ENTERED INTO CONFIDENTIALITY AGREEMENTS WITH ENTERPRISE RENT-A-CAR
 * COMPANY.
 * 
 * This source code may not be licensed, disclosed or used except as authorized
 * in writing by a duly authorized officer of Enterprise Rent-A-Car Company.
 ******************************************************************/
package microservice_spring_boot.xml.producer;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.thoughtworks.xstream.XStream;

@SuppressWarnings("deprecation")
public class XMLViewResolver extends MappingJackson2JsonView {

	private static final Logger LOGGER = LoggerFactory.getLogger(XMLViewResolver.class);

	private String contentType;
	private Set<String> renderedAttributes;

	public XMLViewResolver() {
		setContentType(contentType);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		Object value = filterModel(model);
		XStream xstream = new XStream();
		xstream.alias(value.getClass().getSimpleName(), value.getClass());
		String xmlStr = xstream.toXML(value);
		try {
			response.getWriter().write(xmlStr);
		} catch (IOException e) {
			LOGGER.error("Exception caught :",e.getMessage());
		}
	}

	@Override
	protected Object filterModel(Map<String, Object> model) {
		Object result = new Object();
		Set<String> mRenderedAttributes = !CollectionUtils.isEmpty(this.renderedAttributes) ? this.renderedAttributes : model.keySet();
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (!(entry.getValue() instanceof BindingResult) && mRenderedAttributes.contains(entry.getKey())) {
				result = entry.getValue();
			}
		}
		return result;
	}
}
