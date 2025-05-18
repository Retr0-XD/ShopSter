package com.example.demo.service;

import com.example.demo.dto.OrderSummaryDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.Payment;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrder(Long id, Order order) {
        return orderRepository.findById(id).map(existing -> {
            existing.setCustomerId(order.getCustomerId());
            existing.setTotalAmount(order.getTotalAmount());
            existing.setOrderDate(order.getOrderDate());
            existing.setStatus(order.getStatus());
            return orderRepository.save(existing);
        });
    }

    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
    
    public Optional<OrderSummaryDTO> getOrderSummary(Long orderId) {
        return orderRepository.findById(orderId).map(order -> {
            OrderSummaryDTO summary = new OrderSummaryDTO();
            summary.setOrderId(order.getId());
            summary.setTotalAmount(order.getTotalAmount());
            summary.setOrderDate(order.getOrderDate());
            summary.setOrderStatus(order.getStatus());
            
            // Get customer details
            customerRepository.findById(order.getCustomerId()).ifPresent(customer -> {
                summary.setCustomerName(customer.getName());
                summary.setCustomerEmail(customer.getEmail());
            });
            
            // Get payment details
            List<Payment> payments = paymentRepository.findByOrderId(order.getId());
            if (!payments.isEmpty()) {
                Payment payment = payments.get(0); // Get the first payment
                summary.setPaymentMethod(payment.getMethod());
                summary.setPaymentStatus(payment.getStatus());
            }
            
            return summary;
        });
    }
}
