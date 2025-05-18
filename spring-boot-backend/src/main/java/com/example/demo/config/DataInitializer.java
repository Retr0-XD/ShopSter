package com.example.demo.config;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            CustomerRepository customerRepository,
            EmployeeRepository employeeRepository,
            OrderRepository orderRepository,
            PaymentRepository paymentRepository) {
        
        return args -> {
            // Only initialize if the database is empty
            if (categoryRepository.count() == 0) {
                System.out.println("Initializing sample data...");
                
                // Create categories
                Category electronics = new Category();
                electronics.setName("Electronics");
                electronics.setDescription("Electronic devices and gadgets");
                categoryRepository.save(electronics);
                
                Category clothing = new Category();
                clothing.setName("Clothing");
                clothing.setDescription("Apparel and fashion items");
                categoryRepository.save(clothing);
                
                Category books = new Category();
                books.setName("Books");
                books.setDescription("Books and reading materials");
                categoryRepository.save(books);
                
                // Create products
                Product laptop = new Product();
                laptop.setName("Laptop");
                laptop.setDescription("High-performance laptop");
                laptop.setPrice(1299.99);
                laptop.setStock(50);
                laptop.setCategory("Electronics");
                productRepository.save(laptop);
                
                Product smartphone = new Product();
                smartphone.setName("Smartphone");
                smartphone.setDescription("Latest smartphone model");
                smartphone.setPrice(799.99);
                smartphone.setStock(100);
                smartphone.setCategory("Electronics");
                productRepository.save(smartphone);
                
                Product tShirt = new Product();
                tShirt.setName("T-Shirt");
                tShirt.setDescription("Cotton t-shirt");
                tShirt.setPrice(19.99);
                tShirt.setStock(200);
                tShirt.setCategory("Clothing");
                productRepository.save(tShirt);
                
                Product novel = new Product();
                novel.setName("Novel");
                novel.setDescription("Bestselling novel");
                novel.setPrice(12.99);
                novel.setStock(150);
                novel.setCategory("Books");
                productRepository.save(novel);
                
                // Create customers
                Customer customer1 = new Customer();
                customer1.setName("John Doe");
                customer1.setEmail("john.doe@example.com");
                customer1.setPhone("555-123-4567");
                customer1.setAddress("123 Main St, Anytown, USA");
                customerRepository.save(customer1);
                
                Customer customer2 = new Customer();
                customer2.setName("Jane Smith");
                customer2.setEmail("jane.smith@example.com");
                customer2.setPhone("555-987-6543");
                customer2.setAddress("456 Oak Ave, Somewhere, USA");
                customerRepository.save(customer2);
                
                // Create employees
                Employee employee1 = new Employee();
                employee1.setName("Alice Johnson");
                employee1.setEmail("alice.johnson@shopster.com");
                employee1.setPhone("555-111-2222");
                employee1.setRole("Manager");
                employeeRepository.save(employee1);
                
                Employee employee2 = new Employee();
                employee2.setName("Bob Wilson");
                employee2.setEmail("bob.wilson@shopster.com");
                employee2.setPhone("555-333-4444");
                employee2.setRole("Sales Associate");
                employeeRepository.save(employee2);
                
                // Create orders
                Order order1 = new Order();
                order1.setCustomerId(customer1.getId());
                order1.setTotalAmount(1299.99);
                order1.setOrderDate(LocalDateTime.now().minusDays(5));
                order1.setStatus("Completed");
                orderRepository.save(order1);
                
                Order order2 = new Order();
                order2.setCustomerId(customer2.getId());
                order2.setTotalAmount(32.98);
                order2.setOrderDate(LocalDateTime.now().minusDays(2));
                order2.setStatus("Processing");
                orderRepository.save(order2);
                
                // Create payments
                Payment payment1 = new Payment();
                payment1.setOrderId(order1.getId());
                payment1.setAmount(1299.99);
                payment1.setMethod("Credit Card");
                payment1.setPaymentDate(LocalDateTime.now().minusDays(5));
                payment1.setStatus("Completed");
                paymentRepository.save(payment1);
                
                Payment payment2 = new Payment();
                payment2.setOrderId(order2.getId());
                payment2.setAmount(32.98);
                payment2.setMethod("PayPal");
                payment2.setPaymentDate(LocalDateTime.now().minusDays(2));
                payment2.setStatus("Processing");
                paymentRepository.save(payment2);
                
                System.out.println("Sample data initialization complete!");
            }
        };
    }
}
