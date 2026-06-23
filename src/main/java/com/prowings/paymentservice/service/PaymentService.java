package com.prowings.paymentservice.service;

import com.prowings.paymentservice.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    /**
     * Returns a dummy list of payments. Uses Java 8 Stream API to generate mock data.
     */
    public List<Payment> getPaymentHistory() {
        logger.info("Retrieving payment history - generating dummy data");

        List<Payment> payments = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    String status = (i % 2 == 0) ? "FAILED" : "SUCCESS";
                    return new Payment("txn-" + i, "order-" + i, i * 10.0, status);
                })
                .collect(Collectors.toList());

        // Example of filtering using streams (keeps only SUCCESS payments)
        // List<Payment> successOnly = payments.stream()
        //        .filter(p -> "SUCCESS".equals(p.getPaymentStatus()))
        //        .collect(Collectors.toList());

        logger.debug("Generated {} dummy payments", payments.size());
        return payments;
    }
}

