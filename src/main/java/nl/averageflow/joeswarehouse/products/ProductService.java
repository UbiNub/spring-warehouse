package nl.averageflow.joeswarehouse.products;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductResponse getProducts() {
        return new ProductResponse(this.repository.findAll());
    }

    public Optional<Product> getProductByID(Long id) {
        return this.repository.findById(id);
    }
}
