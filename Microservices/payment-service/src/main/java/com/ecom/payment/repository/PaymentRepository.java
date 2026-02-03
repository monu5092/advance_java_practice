package com.ecom.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
