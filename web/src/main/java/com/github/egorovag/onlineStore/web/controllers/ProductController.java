package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import com.github.egorovag.onlineStore.service.OrderOfGoodsService;
import com.github.egorovag.onlineStore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("listOfProduct")
    public String readListOfProductByName(@RequestParam(value = "productName") ProductName productName, Model map,
                                          HttpSession session) {
        session.setAttribute("productName",productName);
        List<Product> listOfProduct = productService.getProductByProductNameService(productName);
        if (listOfProduct == null || listOfProduct.isEmpty()) {
            map.addAttribute("listOfProduct", null);
        } else {
            map.addAttribute("listOfProduct", listOfProduct);
        }
        return "listOfProduct";
    }

    @PostMapping("delete")
    public String deleteProductById(@RequestParam(value = "id") Long id,
                                    @RequestParam(value = "productName") ProductName productName, Model map) {
        productService.deleteProductByIdService(id);
        map.addAttribute("productName", productName);
        List<Product> listOfProduct = productService.getProductByProductNameService(productName);
        if (listOfProduct == null || listOfProduct.isEmpty()) {
            map.addAttribute("listOfProduct", null);
        } else {
            map.addAttribute("listOfProduct", listOfProduct);
        }
        return "listOfProduct";
    }

    @GetMapping("edit")
    public String editProduct(Product editProduct, Model map) {
        map.addAttribute("editProduct", editProduct);
        return "editProduct";
    }


    @PostMapping("edit")
    public String updateProduct(Product product, Model map) {
        productService.updateProductService(product);
        map.addAttribute("productName", product.getProductName());
        return "redirect:/product/listOfProduct";
    }

    @GetMapping("add")
    public String addProductPage() {
//        session.getAttribute("productName");
//        map.addAttribute("productName", productName);
        return "addProduct";
    }

    @PostMapping("add")
    public String addProduct(Product product, Model map) {
        productService.saveProductService(product);
        map.addAttribute("productName", product.getProductName());
        return "redirect:/product/listOfProduct";
    }
}
