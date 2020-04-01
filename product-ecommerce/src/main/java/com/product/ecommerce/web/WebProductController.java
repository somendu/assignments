package com.product.ecommerce.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebProductController {
	@Autowired
	protected WebCustomerService customerService;

	@Autowired
	protected WebAdminService adminService;

	protected Logger logger = Logger.getLogger(WebProductController.class
			.getName());

	public WebProductController(WebCustomerService customerService, WebAdminService adminService) {
		this.customerService = customerService;
		this.adminService = adminService;
	}

	@RequestMapping("/add")
	public String doAdd(@RequestParam(defaultValue="0") String addend1,
			@RequestParam(defaultValue="0") String addend2,
			Model model) {

		String sum = customerService.add(addend1, addend2);

		logger.info("Sum: " + sum);
		model.addAttribute("json", sum);

		return "sum";
	}

	@RequestMapping("/subtract")
	public String doSubtract(@RequestParam(defaultValue="0") String minuend,
			@RequestParam(defaultValue="0") String subtrahend,
			Model model) {

		String difference = adminService.subtract(minuend, subtrahend);

		logger.info("Difference: " + difference);
		model.addAttribute("json", difference);

		return "difference";
	}
}
