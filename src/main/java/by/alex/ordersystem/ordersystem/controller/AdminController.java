package by.alex.ordersystem.ordersystem;

import by.alex.ordersystem.ordersystem.domain.Order;
import by.alex.ordersystem.ordersystem.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/admin/")
public class AdminController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> orders = orderService.getAll();

        log.info("order size: " + orders.size());
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/update/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> changeOrderStatus(@RequestBody @Valid Order order) {
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("updated order: " + order.toString());
        orderService.save(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/orders/{status}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable String status){
        List<Order> orders = orderService.getOrdersByStatus(status);

        log.info("order size: " + orders.size());
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
