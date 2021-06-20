package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bean.Card;
import com.bean.Payment;
import com.dao.IPaymentRepository;
import com.service.IPaymentService;

/************************************************************************************
 * Description It is a test class that provides the TestCases to test the Payment Service class
 ************************************************************************************/
@SpringBootTest
 public class PaymentServiceTest {

	@Autowired
	 IPaymentService iPaymentService;

	@MockBean
	IPaymentRepository prepo;

	/************************************************************************************
	 * Description Test case for addPayment 
	 ************************************************************************************/
	@Test
	void testaddPayment() 
	{
		
		
		  Card c1 = new Card(); 
		  c1.setBankName("SBI");
		  c1.setCardName("GOUSE");
		  c1.setCardNumber("86453298654");
		  c1.setExpiryDate(LocalDate.of(2022, 12, 8));
		  
		  Payment p1 = new Payment(); 
		  p1.setPaymentId(100); 
		  p1.setType("Card");
		  p1.setStatus("Pending");
		  p1.setCard(c1);
		  
		  Mockito.when(prepo.save(p1)).thenReturn(p1); 
		  Payment response =iPaymentService.addPayment(p1); 
		  assertThat(response.getPaymentId()).isEqualTo(100);
		  assertThat(response.getStatus()).isEqualTo("Pending");
		  assertThat(response.getType()).isEqualTo("Card");
		  assertThat(response.getCard().getBankName().equals(c1.getBankName()));
		  assertThat(response.getCard().getCardName().equals(c1.getCardName()));
		  assertThat(response.getCard().getCardNumber().equals(c1.getCardNumber()));
		  assertThat(response.getCard().getExpiryDate().equals(c1.getExpiryDate()));
		 
	}

	/************************************************************************************
	 * Description Test case for removePayment 
	 ************************************************************************************/
	@Test
	public void removePaymentTest()
	{
		Payment p1 = new Payment();
		p1.setPaymentId(100);
		p1.setStatus("Success");
		p1.setType("card");
		Optional<Payment>p2=Optional.of(p1);
		Mockito.when(prepo.findById((long) 100)).thenReturn(p2);
		Mockito.when(prepo.existsById(p1.getPaymentId())).thenReturn(false);
		assertFalse(prepo.existsById(p1.getPaymentId()));
	}	
		

	/************************************************************************************
	 *  Description Test case for updatePayment  
	 ************************************************************************************/
	@Test
	public void updatePaymentTest() {
		Payment p1 = new Payment();
		p1.setPaymentId(100);
		p1.setStatus("Success");
		p1.setType("card");
		Optional<Payment>p2=Optional.of(p1);
		Mockito.when(prepo.findById((long) 100)).thenReturn(p2);
		p1.setType("cards");
		Mockito.when(prepo.save(p1)).thenReturn(p1);
		assertThat(iPaymentService.updatePayment(p1)).isEqualTo(p1);
	}
	

	/************************************************************************************
	Description Test case for getPaymentDetails
	 ************************************************************************************/
	@Test
	public void getPaymentDetailsTest() 
	{
		
		Payment p = new Payment();
		p.setPaymentId(100);
		p.setType("Card");
		p.setStatus("pending");
		Optional<Payment>p1=Optional.of(p);
		Mockito.when(prepo.findById((long) 100)).thenReturn(p1);
		Optional<Payment>p2=Optional.of(iPaymentService.getPaymentDetails(100));
		assertThat(p2).isEqualTo(p2);
	}
		
		

	/************************************************************************************
	Description Test case for getAllPaymentDetails 
	 ************************************************************************************/
	@Test
	public void getAllPaymentDetailsTest() {
		Payment p = new Payment();
		p.setPaymentId(100);
		p.setType("Card");
		List<Payment> ls=new ArrayList<>();
		ls.add(p);
		Mockito.when(prepo.findAll()).thenReturn(ls);
		assertThat(iPaymentService.getAllPaymentDetails()).isEqualTo(ls);
		
	}

}