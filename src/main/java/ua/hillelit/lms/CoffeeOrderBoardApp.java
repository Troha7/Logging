package ua.hillelit.lms;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.hillelit.lms.order.Order;
import ua.hillelit.lms.service.OrderBoardService;

@SpringBootApplication
@RequiredArgsConstructor
public class CoffeeOrderBoardApp {

    private final OrderBoardService orderBoard;

    public static void main(String[] args) {
        SpringApplication.run(CoffeeOrderBoardApp.class, args);
    }

    /**
     * Run application after all initialization steps.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        orderBoard.add(new Order(34, "John Snow"));
        orderBoard.add(new Order(33, "Obi-van"));
        orderBoard.add(new Order(14, "Alen"));
        orderBoard.add(new Order(27, "Yoda"));
        orderBoard.add(new Order(19, "Darth Vader"));

        orderBoard.deliver();

        orderBoard.deliver(34);

        orderBoard.draw();

    }

}
