package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Payment;



/************************************************************************************************      
 *          Description     IPaymentRepository is an interface which extends JPA repository.
 *          				This class belongs to DAO layer. It is used to perform CRUD operations
 *          				with our entities by defining JPA repositories for automatic 
 *          				and intelligent implementations.                     					  
 **************************************************************************************************/
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}

