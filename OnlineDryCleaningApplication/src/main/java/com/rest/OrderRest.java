package com.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Order;
import com.service.IOrderService;

/****************************
 *          Description      It is a Controller class that provides the Restful End points and controls 
                             data flow.  

 ****************************/

@RestController
@RequestMapping("/order")
public class OrderRest {
	@Autowired
	private IOrderService iOrderService;
	
	/*********************************************************************************************
	* Method                : addOrder
	*Description            : To add the Order details to the Database
	* @param Order          - Order details to be added to the Database
	* @param RequestBody    - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound HttpRequest body
	                           onto a Java object.
	* @returns Order        - returns Order
	********************************************************************************************/

	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		Order order2 = null;
		order2 = this.iOrderService.addOrder(order);
		return order2;
	}
	
	/*****************************
	* Method                : getOrder
	* Description           : To fetch the Order details from the Database
	* @param Order          -  Order details to be fetched to the Database
	* @param PathVariable   - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound
	                          HttpRequest body onto a Java object.
	* @returns Order        - returns Order
	 *****************************/

	@GetMapping("/get/{id}")
	public Order getOrderDetails(@PathVariable("id") long id) {
		Order order = this.iOrderService.getOrderDetails(id);
		return order;
	}
	
	/*****************************
	* Method             :   removeOrder
	* Description        :   To delete the Order details from the Database
	* @param Order       -   Order details to be delete from Database
	* @param RequestBody -    It maps the HttpRequest body to a transfer or domain object,
	                           enabling automatic deserialization of the inbound HttpRequest 
	                           body onto a Java object.
	* @returns Order     -    returns Order

	 *****************************/


	@DeleteMapping("/delete/{id}")
	public Order removeOrder(@PathVariable("id") long id) {
		Order order = this.iOrderService.removeOrder(id);
		return order;
	}
	
	/*****************************
	* Method      :       getallOrders
	* Description :       To fetchAll the Oder details from the Database
	* @param Order -      Order details to be fetched to the Database
	* @param RequestBody -  It maps the HttpRequest body to a transfer or domain object,
	                        enabling automatic deserialization of the inbound HttpRequest body
	                        onto a Java object.
	* @returns Statement-   returns Order
	 *****************************/

	@GetMapping("/all")
	public List<Order> getAllOrders() {
		List<Order> orders = this.iOrderService.getAllOrders();
		return orders;
	}
	
	/*****************************
	* Method     :        updateOrder
	*Description :        To update the Payment details stored in the Database
	* @param Order    -   Order details to be updated to the Database
	* @param RequestBody -  It maps the HttpRequest body to a transfer or domain object,
	                        enabling automatic deserialization of the inbound HttpRequest body
	                        onto a Java object.
	* @returns Order -    returns Order
	 *****************************/

	@PutMapping("/update")
	public Order updateOrder(@RequestBody Order order) {
		Order order2 = this.iOrderService.updateOrder(order);
		return order2;
	}

}
