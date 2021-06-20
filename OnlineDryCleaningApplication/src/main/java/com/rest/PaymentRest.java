package com.rest;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Payment;
import com.service.IPaymentService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

/*********************************************************************************************************************************
 * Description       It is a service class that provides the
 *                   services to add a statement,remove a statement,update a statement and view statement 
 *********************************************************************************************************************************/

@RestController
@RequestMapping("/payment")
public class PaymentRest {

	@Autowired
	private IPaymentService iPaymentService;

	/*********************************************************************************************
	* Method                : addPayment
	*Description            : To add the payment details to the Database
	* @param Payment        - Payment details to be added to the Database
	* @param RequestBody    - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound HttpRequest body
	                           onto a Java object.
	* @returns Payment      - returns Payment
	********************************************************************************************/
	@PostMapping("/add")
	public Payment addPayment( @Valid @RequestBody Payment payment) {
		Payment payment2 = null;
		payment2 = this.iPaymentService.addPayment(payment);
		return payment2;
	}
	/************************************************************************************
	* Method :                 removePayment
	*Description :             To delete the Payment details from the Database
	* @param Payment -         Payment details to be delete from Database
	* @param RequestBody -    It maps the HttpRequest body to a transfer or domain object,
	                           enabling automatic deserialization of the inbound HttpRequest 
	                           body onto a Java object.
	* @returns Payment -       returns Payment

	************************************************************************************/

	
	@DeleteMapping("/remove/{id}")
	public Payment removePayment(@PathVariable("id") long id) {
		Payment payment = this.iPaymentService.removePayment(id);
		return payment;
	}
	
	/************************************************************************************
	* Method :              updatePayment
	*Description :          To update the Payment details stored in the Database
	* @param Payment    -   Payment details to be updated to the Database
	* @param RequestBody -  It maps the HttpRequest body to a transfer or domain object,
	                        enabling automatic deserialization of the inbound HttpRequest body
	                        onto a Java object.
	* @returns Payment -    returns Payment

	*******************************************************************************************************************************************************************************************/

	@PutMapping("/update")
	public Payment updatePayment(@Valid @RequestBody Payment payment) {
		Payment payment2 = this.iPaymentService.updatePayment(payment);
		return payment2;
	}

	/************************************************************************************
	* Method                : getPayment
	*Description            : To fetch the Payment details from the Database
	* @param Payment        - Payment details to be fetched to the Database
	* @param PathVariable   - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound
	                          HttpRequest body onto a Java object.
	* @returns Payment      - returns Payment

	*******************************************************************************************************************************************************************************************/
	@GetMapping("/get/{id}")
	public Payment getPaymentDetails(@PathVariable("id") long id) {
		Payment payment = this.iPaymentService.getPaymentDetails(id);
		return payment;
	}

	/************************************************************************************
	* Method :              getallPayment
	*Description :          To fetchAll the Payment details from the Database
	* @param Payment -      Payment details to be fetched to the Database
	* @param RequestBody -  It maps the HttpRequest body to a transfer or domain object,
	                        enabling automatic deserialization of the inbound HttpRequest body
	                        onto a Java object.
	* @returns Statement-   returns Payment

	*******************************************************************************************************************************************************************************************/
	@GetMapping("/all")
	public List<Payment> getAllPaymentDetails() {
		List<Payment> payments = this.iPaymentService.getAllPaymentDetails();
		return payments;
	}
}

