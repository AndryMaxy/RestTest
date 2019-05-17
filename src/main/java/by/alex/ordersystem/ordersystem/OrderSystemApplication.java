package by.alex.ordersystem.ordersystem;

import by.alex.ordersystem.ordersystem.domain.Order;
import by.alex.ordersystem.ordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class OrderSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSystemApplication.class, args);
    }

    @Configuration
    public class StartedData implements CommandLineRunner{

        @Autowired
        private OrderService orderService;

        @Override
        public void run(String... args) throws Exception {
            Order order1 = Order.builder()
                    .request("Помыть машину")
                    .bid(new BigDecimal("100.50"))
                    .date(LocalDate.now())
                    .build();
            Order order2 = Order.builder()
                    .request("Выгулять собаку")
                    .bid(new BigDecimal("17.99"))
                    .date(LocalDate.now())
                    .build();
            Order order3 = Order.builder()
                    .request("Покосить газон")
                    .bid(new BigDecimal("52.25"))
                    .date(LocalDate.now())
                    .build();
            Order order4 = Order.builder()
                    .request("Покосить газон")
                    .bid(new BigDecimal("52.25"))
                    .date(LocalDate.now())
                    .status(Order.Status.WORKING)
                    .build();
            orderService.save(order1);
            orderService.save(order2);
            orderService.save(order3);
            orderService.save(order4);
        }
    }

}
