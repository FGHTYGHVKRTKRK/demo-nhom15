package com.example.WebBanHang.service;

import com.example.WebBanHang.model.CartItem;
import com.example.WebBanHang.model.Order;
import com.example.WebBanHang.model.OrderDetail;
import com.example.WebBanHang.repository.OrderDetailRepository;
import com.example.WebBanHang.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CartService cartService;
    @Transactional
    public Order createOrder(String customerName,String sdt,String address,String email,String payment, List<CartItem> cartItems) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setSdt(sdt);
        order.setAddress(address);
        order.setEmail(email);
        order.setPayment(payment);
        order = orderRepository.save(order);
        for (CartItem item : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(item.getProduct());
            detail.setQuantity(item.getQuantity());
            orderDetailRepository.save(detail);
        }
        cartService.clearCart();
        return order;
    }
}
