package ljh.commerce.commerce.service;

import ljh.commerce.commerce.domain.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductOrderService {

    private final OrderRepository orderRepository;


}
