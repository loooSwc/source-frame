package com.sframe.common.util;

import com.sframe.common.ConstantClazz;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder, WebRequest arg1) {
		SimpleDateFormat df = new SimpleDateFormat(
				ConstantClazz.MVC_DATE_FORMAT);
		binder
				.registerCustomEditor(Date.class, new CustomDateEditor(df,
						false));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

}
