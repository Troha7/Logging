package ua.hillelit.lms.order;

import lombok.*;

/**
 * {@link Order}
 *
 * @author Dmytro Trotsenko on 2/2/23
 */

@Value
public class Order {

    @NonNull
    Integer num;
    @NonNull
    String name;

}
