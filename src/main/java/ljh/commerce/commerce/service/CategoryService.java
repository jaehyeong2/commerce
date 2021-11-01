package ljh.commerce.commerce.service;

import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }


    public void addCategory(Category category){
        categoryRepository.save(category);
    }
}
