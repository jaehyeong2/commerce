package ljh.commerce.commerce.service;


import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void addProduct(Product product){
        productRepository.save(product);
    }

    @Transactional
    public void removeProductById(long id){
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProductByCategoryId(long categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }
}
