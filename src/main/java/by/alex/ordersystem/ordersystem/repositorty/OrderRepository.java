package by.alex.ordersystem.ordersystem.repositorty;

import by.alex.ordersystem.ordersystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getOrdersByStatus(Order.Status status);
}
