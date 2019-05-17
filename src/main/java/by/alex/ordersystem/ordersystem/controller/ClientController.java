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
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/client/")
public class ClientController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "new/order/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid Order order) {
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info("new order: " + order.toString());
        orderService.save(order);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "order/status/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) {
        Optional<Order> optionalOrder = orderService.getById(id);

        if (!optionalOrder.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Order order = optionalOrder.get();
        log.info("order: " + order.toString());

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
