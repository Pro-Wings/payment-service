package com.prowings.paymentservice.controller;

import com.prowings.paymentservice.model.Payment;
import com.prowings.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getPayments() {
        logger.info("Incoming request: GET /api/payments");
        List<Payment> payments = paymentService.getPaymentHistory();
        logger.debug("Returning {} payments", payments.size());
        return payments;
    }

    @GetMapping("/test")
    public String test() {
        return paymentService.processPayment();
    }
}

