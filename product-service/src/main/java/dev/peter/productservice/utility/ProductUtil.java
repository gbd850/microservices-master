package dev.peter.productservice.utility;

import dev.peter.productservice.dto.ProductResponse;
import dev.peter.productservice.model.Product;

public final class ProductUtil {
    public static ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
