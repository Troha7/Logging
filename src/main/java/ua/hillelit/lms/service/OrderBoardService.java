package ua.hillelit.lms.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.order.Order;

import java.util.Map;
import java.util.TreeMap;

/**
 * {@link OrderBoardService} is the class to control the issuance of orders.
 *
 * @author Dmytro Trotsenko on 2/2/23
 */

@NoArgsConstructor
@Service
@Slf4j
public class OrderBoardService {
    private final Map<Integer, String> orders = new TreeMap<>();

    /**
     * Add order to order board
     *
     * @param order {@link Order}
     */
    public void add(Order order) {
        log.info("Start added new order: {} in list", order);
        orders.put(order.getNum(), order.getName());
        log.info("Added order: {} in list is complete", order);
    }

    /**
     * Deliver first in queue order and remove order from order board
     *
     * @throws IllegalArgumentException when order list is empty
     */
    public void deliver() {
        try {
            Integer firstNum = orders.keySet().stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Order list is empty"));

            log.info("Start delivering order num: {}", firstNum);
            orders.remove(firstNum);
            log.info("Delivering order num: {} is completed", firstNum);

        } catch (Exception e) {
            log.error("Order cant be delivered ", e);
        }
    }

    /**
     * Deliver order by order number and remove order from order board
     *
     * @param num order number
     * @throws IllegalArgumentException when order {@param num} wasn't found
     */
    public void deliver(Integer num) {
        try {
            Integer orderNum = orders.keySet().stream()
                    .filter(n -> n.equals(num))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Order " + num + " wasn't found"));

            log.info("Start delivering order num: {}", num);
            orders.remove(orderNum);
            log.info("Delivering order num: {} is completed", num);
        } catch (Exception e) {
            log.error("Order cant be delivered ", e);
        }
    }

    /**
     * Draw orders at order board
     */
    public void draw() {
        log.info("Num | Name [is drawing in order board]");
        orders.forEach((num, name) -> log.info("{} | {}", num, name));
        log.info("Drawing FINISH");
    }

}
