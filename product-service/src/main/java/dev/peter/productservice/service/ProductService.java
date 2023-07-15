package dev.peter.productservice.service;

import dev.peter.productservice.dto.ProductRequest;
import dev.peter.productservice.dto.ProductResponse;
import dev.peter.productservice.model.Product;
import dev.peter.productservice.repository.ProductRepository;
import dev.peter.productservice.utility.ProductUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductUtil::mapToProductResponse).toList();
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }
}
