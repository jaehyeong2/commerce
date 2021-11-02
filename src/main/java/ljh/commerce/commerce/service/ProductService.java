package ljh.commerce.commerce.service;


import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void removeProduct(int id){
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProductByCategoryId(int categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }
}
