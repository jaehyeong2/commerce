package ljh.commerce.commerce.controller;


import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.service.CategoryService;
import ljh.commerce.commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @DeleteMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    @PutMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }
        return "404";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(Model model, @PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    //PRODUCT SECTION
    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String getProductAdd(Model model){
        model.addAttribute("product", new Product());
        return "productsadd";
    }

    @DeleteMapping("admin/products/delete/{id}")
    public String deleteProduct(Model model, @PathVariable int id){
        productService.removeProduct(id);
        return "redircect:/admin/categories";
    }
}
