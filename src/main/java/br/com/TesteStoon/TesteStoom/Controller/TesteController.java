package br.com.TesteStoon.TesteStoom.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesteController {

		@RequestMapping("/")
	    @ResponseBody
	    public String init() {
	        return "Init";
	    }

	}

