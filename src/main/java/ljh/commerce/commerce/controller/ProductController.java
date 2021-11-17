package ljh.commerce.commerce.controller;

import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.dto.ProductDto;
import ljh.commerce.commerce.service.CategoryService;

import ljh.commerce.commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class ProductController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
//    public static String uploadDir = "/home/ec2-user/app/git/repository";

    private final ProductService productService;
    private final CategoryService categoryService;

    //PRODUCT SECTION
    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDto",new ProductDto());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDto") ProductDto productDto,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("imgName")String imgName) throws IOException {

//        UUID uuid = UUID.randomUUID();
//        String imageFileName = uuid+"_"+reqDto.getFile().getOriginalFilename();

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());

        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        String imageUUID;
        if(!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path filenamePath = Paths.get(uploadDir,imageUUID);
            Files.write(filenamePath,file.getBytes());
        } else{
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());

        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String productDelete(@PathVariable int id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String productUpdate(@PathVariable int id,Model model){
        Product product = productService.getProductById(id).get();
        ProductDto productResDto = new ProductDto();
        productResDto.setId(product.getId());
        productResDto.setCategoryId(product.getCategory().getId());
        productResDto.setPrice(product.getPrice());
        productResDto.setName(product.getName());
        productResDto.setImageName(product.getImageName());

        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("productDto",productResDto);

        return "productsAdd";
    }
}
