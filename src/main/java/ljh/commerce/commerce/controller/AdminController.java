package ljh.commerce.commerce.controller;


import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.dto.ProductResDto;
import ljh.commerce.commerce.service.CategoryService;
import ljh.commerce.commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminController {



    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("/admin")
    public String adminHome(){
        return "admin";
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

    @GetMapping("/admin/categories/delete/{id}")// form태그 이용하게 수정해야 deletemapping 할수 잇다고함
    public String deleteCat(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }
        return "404";
    }


}
