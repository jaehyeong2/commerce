package ljh.commerce.commerce.controller;


import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.global.GlobalData;
import ljh.commerce.commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CartController {

    private final ProductService productService;

    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
//        model.addAttribute("total", GlobalData.cart.stream().mapToInt(Product::getId));
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "checkout";
    }
}
