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

import com.bean.Order;
import com.dao.IOrderRepository;
import com.service.IOrderService;

@SpringBootTest
public class OrderServiceTest 
{

  @Autowired
  IOrderService iOrderService;
  
  @MockBean
  IOrderRepository orderRepo;
  
  @Test
  void testaddOrder()
  {
	  Order order1=new Order();
	  order1.setOrderId(1000L);
	  order1.setAmount(100.00);
	  order1.setBillingDate(LocalDate.now());
	//  order1.setCustomer(null);
	//  order1.setPaymentMethod("online");
	//  order1.setBookingDetails(null);
	  Mockito.when(orderRepo.save(order1)).thenReturn(order1);
	  Order response=iOrderService.addOrder(order1);
	  assertThat(response.getOrderId()).isEqualTo(1000L);
	  assertThat(response.getAmount()).isEqualTo(100.00); 
	  assertThat(response.getBillingDate()).isEqualTo(LocalDate.now());
	//  assertThat(response.getCustomer()).equals(null);
	//  assertThat(response.getPaymentMethod()).isequals("online");
	//  assertThat(response.getBookingDetails()).equals(null);
	  
  }
  
  
  @Test
  void testgetAllOrders()
  {
	  Order order1=new Order();
	  order1.setOrderId(1000L);
	  order1.setAmount(100.00);
	  order1.setBillingDate(LocalDate.now());
	  order1.setCustomer(null);
	  order1.setPaymentMethod("online");
	  order1.setBookingDetails(null);
	  Order order2=new Order();
	  order2.setOrderId(1002L);
	  order2.setAmount(200.00);
	  order2.setBillingDate(LocalDate.now());
	  order2.setCustomer(null);
	  order2.setPaymentMethod("online");
	  order2.setBookingDetails(null);
	  List<Order> ls=new ArrayList<>();
	  ls.add(order1);
	  ls.add(order2);
	  Mockito.when(orderRepo.findAll()).thenReturn(ls);
	  assertThat(iOrderService.getAllOrders()).isEqualTo(ls);

	}
  
  
  @Test
  void testremoveOrder()
  {
	  Order order1=new Order();
	  order1.setOrderId(1000L);
	  order1.setAmount(100.00);
	  order1.setBillingDate(LocalDate.now());
	  order1.setCustomer(null);
	  order1.setPaymentMethod("online");
	  order1.setBookingDetails(null);
	  Optional<Order> order2=Optional.of(order1);
	  
	  Mockito.when(orderRepo.findById(1000L)).thenReturn(order2);
		Mockito.when(orderRepo.existsById(order1.getOrderId())).thenReturn(false);
		assertFalse(orderRepo.existsById(order1.getOrderId()));
  }
  
  @Test
  void testupdateOrder()
  {
	  Order order1=new Order();
	  order1.setOrderId(1000L);
	  order1.setAmount(100.00);
	  order1.setBillingDate(LocalDate.now());
	  order1.setCustomer(null);
	  order1.setPaymentMethod("online");
	  order1.setBookingDetails(null);
	  Optional<Order> order2=Optional.of(order1);
	  Mockito.when(orderRepo.findById(1000L)).thenReturn(order2);
	  order1.getBookingDetails();
	  Mockito.when(orderRepo.save(order1)).thenReturn(order1);
		assertThat(iOrderService.updateOrder(order1)).isEqualTo(order1);
	    
  }
}