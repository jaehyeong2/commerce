package ljh.commerce.commerce.controller;

import ljh.commerce.commerce.global.GlobalData;
import ljh.commerce.commerce.service.CategoryService;
import ljh.commerce.commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping({"/","/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("products",productService.getAllProducts());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("product",productService.getProductById(id).get());
        return "viewProduct";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "viewProduct";
    }

    @GetMapping("/cart/remove/{id}")
    public String cartItemRemove(@PathVariable int id){
        GlobalData.cart.remove(id);
        return "redirect:/cart";
    }

}
