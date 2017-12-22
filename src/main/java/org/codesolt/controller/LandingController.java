package org.codesolt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class LandingController {
	
	 @RequestMapping(method = RequestMethod.GET)
     public ModelAndView  swaggerUi() {
         return new ModelAndView("redirect:" + "/swagger-ui.html");
     }	
}
