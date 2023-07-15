package dev.peter.orderservice.utility;

import dev.peter.orderservice.dto.OrderLineItemsDto;
import dev.peter.orderservice.model.OrderLineItems;

public final class OrderUtil {
    public static OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }
}
