package com.sh.firstPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fPageController {
	
	
	@GetMapping("/fPage")
	public String fPage() {
		return "fPage";
	}
}
