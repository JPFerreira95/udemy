package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;
    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;
    private final ApplicationDomainEventPublisher applicationDomainEventPublisher;

    // Second option
//    private final OrderDomainService orderDomainService;
//    private final OrderRepository orderRepository;
//    private final CustomerRepository customerRepository;
//    private final RestaurantRepository restaurantRepository;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper,
                                     OrderDataMapper orderDataMapper,
                                     ApplicationDomainEventPublisher applicationDomainEventPublisher,
                                     OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher,
                                     OrderDomainService orderDomainService,
                                     OrderRepository orderRepository,
                                     CustomerRepository customerRepository,
                                     RestaurantRepository restaurantRepository
                                     ) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
        this.applicationDomainEventPublisher = applicationDomainEventPublisher;

        // Second option
//        this.orderDomainService = orderDomainService;
//        this.orderRepository = orderRepository;
//        this.customerRepository = customerRepository;
//        this.restaurantRepository = restaurantRepository;
    }

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
        applicationDomainEventPublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder(), "Order created successfully");
    }

    // Second option
//    @Transactional
//    public CreateOrderResponse createOrder2(CreateOrderCommand createOrderCommand) {
//        checkCustomer(createOrderCommand.getCustomerId());
//        Restaurant restaurant = checkRestaurant(createOrderCommand);
//        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
//        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
//        Order orderResult = saveOrder(order);
//        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
//        applicationDomainEventPublisher.publish(orderCreatedEvent);
//        return orderDataMapper.orderToCreateOrderResponse(orderResult);
//    }
//
//    private void checkCustomer(UUID customerId) {
//        Optional<Customer> customer = customerRepository.findCustomer(customerId);
//        if (customer.isEmpty()) {
//            log.warn("Could not find customer with id {}", customerId);
//            throw new OrderDomainException("Could not find customer with id " + customerId);
//        }
//    }
//
//    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
//        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
//        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByRestaurantInformation(restaurant);
//        if (optionalRestaurant.isEmpty()) {
//            log.warn("Could not find restaurant with id {}", createOrderCommand.getRestaurantId());
//            throw new OrderDomainException("Could not find restaurant with id " + createOrderCommand.getRestaurantId());
//        }
//        return optionalRestaurant.get();
//    }
//
//    private Order saveOrder(Order order) {
//        Order orderResult = orderRepository.save(order);
//        if (orderResult == null) {
//            log.error("Could not save order!");
//            throw new OrderDomainException("Could not save order!");
//        }
//        log.info("Saved order with id: {}", orderResult.getId());
//        return orderResult;
//    }

}
