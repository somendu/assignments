package com.sql.util.rest.sql;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.util.rest.sql.model.StringListBody;
import com.sql.util.rest.sql.service.SqlUtilService;

/**
 * 
 * Customer Controller class
 * 
 * @author Somendu
 * @since Apr 2, 2020
 */
@RestController
@RequestMapping("/api")
public class SqlController {

	protected Logger logger = Logger.getLogger(SqlController.class.getName());

	@Autowired
	private SqlUtilService orderService;

	@GetMapping("/passingString")
	public List<String> placeOrder(@RequestBody StringListBody stringList) {

		// The map consist of productid and count for the product
		List<String> parameterList = stringList.getStringList();

		List<String> orderPlaced = orderService.createInsertScripts(parameterList);

		return orderPlaced;
	}
}
