package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.cts.model.Payment;
import com.cts.repository.PaymentRepository;
import com.cts.service.PaymentServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceImplTests {

    @Mock
    private PaymentRepository repository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    void testMakePayment() {
        Payment payment = new Payment();
        
        when(repository.save(payment)).thenReturn(payment);
        
        String result = paymentService.makePayment(payment);
        assertEquals("Payment is Successfully Completed", result);
    }
}
