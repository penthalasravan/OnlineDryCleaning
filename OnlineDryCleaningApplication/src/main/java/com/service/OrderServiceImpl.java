package com.service;



import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Order;
import com.dao.IOrderRepository;
import com.exception.EmptyEntityListException;
import com.exception.EntityCreationException;
import com.exception.EntityDeletionException;
import com.exception.EntityUpdationException;

/****************************
* Description  It is a order service implementation class that defines the methods mentioned in its interface.
  
****************************/
@Service

public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;
	
	/****************************
	* Method:                          	addOrder
    *Description:                      	To add the order details
    *@param payment:                       order's reference variable.
	 * @returns order                  	- Adds order data else throws Entity Creation Exception 
	 * @throws  Entity Creation Exception  	- It is raised when we cannot create order details
	 ****************************/
	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			Order order1 = orderRepository.save(order);
			return order1;

		} catch (Exception e) {
			throw new EntityCreationException("Failed to Create Order.");
		}

	}
	
	/****************************
	 * Method:                          	removeOrder
     *Description:                      	To remove the Order details
     *@param Order:                         Order reference variable.
	 * @returns order                 	- Removes order data else throws Entity Deletion Exception 
	 * @throws  Entity Deletion Exception  	- It is raised when we cannot remove order details
     ****************************/

	@Override
	public Order removeOrder(long id) {

		Optional<Order> optionalOrder = orderRepository.findById(id);
		Order order = null;
		if (optionalOrder.isPresent()) {
			order = optionalOrder.get();
			orderRepository.deleteById(id);
			return order;
		} else {
			throw new EntityDeletionException("Order With Id " + id + " does not Exist.");
		}

	}
	
	/****************************
	 * Method:                          	updateOrder
     *Description:                      	To update the order details
     *@param order :                       Order's reference variable.
	 * @returns order                  	- Updates order data else throws Entity Updation Exception 
	 * @throws  Entity Updation Exception   - It is raised when we cannot update order details
     ****************************/
	@Override
	public Order updateOrder(Order order) {
		Optional<Order> optionalOrder = null;
		Order order2 = null;

		optionalOrder = orderRepository.findById(order.getOrderId());
		if (optionalOrder.isPresent()) {
			order2 = orderRepository.save(order);
			return order2;
		} else {
			throw new EntityUpdationException("order With Id " + order.getOrderId() + " does Not Exist.");
		}
	}
	
	/****************************
	 * Method:                          getOrderDetails
     *Description:                      To display the payment by Id (Primary key)
     *@param id:                        id of the user.
	 * @returns Order              	- if order with Id presents it returns order else throws EntityNotFoundException
	 * @throws EntityNotFoundException 	-  It is raised due to invalid  orderId 
     
	 ****************************/

	@Override
	public Order getOrderDetails(long id) {
		Optional<Order> optionalorder = null;
		Order order = null;

		optionalorder = orderRepository.findById(id);
		if (optionalorder.isPresent()) {
			order = optionalorder.get();
			return order;
		} else {
			throw new EntityUpdationException("Order With Id " + id + " does Not Exist.");
		}
	}
	
	/****************************
	 * Method:                          getAllOrderDetails
     *Description:                      To display all the orders
	 * @returns List<Order>           - It returns all the orders present in database
	 * @throws EntityNotFoundException 	-  It is raised when no valid order details are found
    	 ****************************/

	@Override
	public List<Order> getAllOrders() {
		List<Order> allOrderers = new ArrayList<Order>();

		allOrderers = orderRepository.findAll();
		if (!allOrderers.isEmpty()) {
			return allOrderers;
		} else {
			throw new EmptyEntityListException("No Orders Found.");
		}
	}

}
