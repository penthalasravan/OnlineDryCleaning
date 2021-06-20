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

import com.bean.Address;
import com.bean.Customer;
import com.dao.ICustomerRepository;
import com.service.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	ICustomerService iCustomerService;
	
	@MockBean
	ICustomerRepository customerRepo;
	
	@Test
	void addCutomerTest() {
		Customer customer1=new Customer();
		Address address=new Address("2-104", "S Street", "VKP", "Guntur", "AP",522020); 
		customer1.setUserId("apothana");
		customer1.setName("Arun");
		customer1.setEmail("arunpothana@gmail.com");
		customer1.setContactNo("9494611327");
		customer1.setDob(LocalDate.now());
		customer1.setAddress(address);
		customer1.setCustomerItems(null);
		customer1.setOrders(null);
		customer1.setAddress(address);
		Mockito.when(customerRepo.save(customer1)).thenReturn(customer1);
		Customer response=iCustomerService.addCustomer(customer1);
		assertThat(response.getUserId().equals("apothana"));
		assertThat(response.getName()).isEqualTo("Arun");
		assertThat(response.getAddress()).isEqualTo(address);
		assertThat(response.getDob().equals(LocalDate.now()));
		assertThat(response.getCustomerItems()).isEqualTo(null);
    	assertThat(response.getOrders()).isEqualTo(null);
		
	}
	@Test
	void getAllBookingstest()
	{
		Customer customer1=new Customer();
		customer1.setUserId("apothana");
		customer1.setName("Arun");
		customer1.setEmail("arunpothana@gmail.com");
		customer1.setContactNo("9494611327");
		customer1.setDob(LocalDate.now());
		Customer customer2=new Customer();
		customer2.setUserId("apothana");
		customer2.setName("Arun");
		customer2.setEmail("arunpothana@gmail.com");
		customer2.setContactNo("9494611327");
		customer2.setDob(LocalDate.now());
		List<Customer> ls=new ArrayList<>();
		ls.add(customer1);
		ls.add(customer2);
		Mockito.when(customerRepo.findAll()).thenReturn(ls);
		assertThat(iCustomerService.getAllCustomers()).isEqualTo(ls);
		
	}
@Test
public void removeCustomerTest() {
	Customer customer1=new Customer();
	customer1.setUserId("apothana");
	customer1.setName("Arun");
	customer1.setEmail("arunpothana@gmail.com");
	customer1.setContactNo("9494611327");	
	customer1.setDob(LocalDate.now());
	Optional<Customer> customer2=Optional.of(customer1);
	
	Mockito.when(customerRepo.findById("apothana")).thenReturn(customer2);
	Mockito.when(customerRepo.existsById(customer1.getUserId())).thenReturn(false);
	assertFalse(customerRepo.existsById(customer1.getUserId()));	
	}
@Test
public void updateCustomerTest() {
	Customer customer1=new Customer();
	customer1.setUserId("apothana");
	customer1.setName("Arun");
	customer1.setEmail("arunpothana@gmail.com");
	customer1.setContactNo("9494611327");	
	customer1.setDob(LocalDate.now());
	Optional<Customer> customer2=Optional.of(customer1);
	Mockito.when(customerRepo.findById("apothana")).thenReturn(customer2);
	customer1.setUserId("apothana12");
	Mockito.when(customerRepo.save(customer1)).thenReturn(customer1);
//	assertThat(iCustomerService.updateCustomer(customer1)).isEqualTo(customer1);
}
@Test
public void getAllCustomersTest() {
	Customer customer=new Customer();
	customer.setUserId("apothana");
	customer.setName("Arun");
	customer.setEmail("arunpothana@gmail.com");
	customer.setContactNo("9494611327");
	Customer customer2=new Customer();
	customer2.setUserId("sravanp");
	customer2.setName("sravan");
	customer2.setEmail("sravanpenthala@gmail.com");
	customer2.setContactNo("8247864127");
	iCustomerService.addCustomer(customer2);
	iCustomerService.addCustomer(customer);
}
}