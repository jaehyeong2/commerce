package ljh.commerce.commerce.controller;


import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.dto.ProductDto;
import ljh.commerce.commerce.service.CategoryService;
import ljh.commerce.commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    //PRODUCT SECTION
    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String ProductAddGet(Model model){
        model.addAttribute("productDto",new ProductDto());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String ProductAddPost(@ModelAttribute("productDto") ProductDto productDto,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName) throws IOException {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageName(productDto.getImageName());
        product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());

        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("admin/products/delete/{id}")
    public String deleteProduct(Model model, @PathVariable int id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable int id,Model model){
        Product product = productService.getProductById(id).get();
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setName(product.getName());
        productDto.setImageName(product.getImageName());

        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("productDto",productDto);

        return "productsAdd";
    }
}
