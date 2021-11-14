package ljh.commerce.commerce.service;

import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Transactional
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategoryById(long id){
        categoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Category> getCategoryById(long id){
       return categoryRepository.findById(id);
    }
}
