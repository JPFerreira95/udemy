package com.udemy.microservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	// hello world
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// hello world bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	// hello world bean with path variable
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanPathVar(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	// hello world with i18n
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {

		// en = Good Morning
		// nl = Goede Morgen
		// fr = Bonjour
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

	// hello world with i18n
	@GetMapping("/hello-world-internationalized2")
	public String helloWorldInternationalized2() {

		// en = Good Morning
		// nl = Goede Morgen
		// fr = Bonjour
		return messageSource.getMessage("good.morning.message", null, "Default Message", LocaleContextHolder.getLocale());
	}

}
