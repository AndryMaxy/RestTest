package by.alex.ordersystem.ordersystem.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(nullable = false)
    private String request;

    @Column(nullable = false)
    private BigDecimal bid;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.NEW;

    public enum Status{
        NEW,
        WORKING,
        REJECTED,
        CLOSED
    }
}
