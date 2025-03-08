package WideTechIdProject.Controller;

import WideTechIdProject.Model.Product;
import WideTechIdProject.ServiceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @GetMapping("/orders")
    public Pair<List<Product>, Long> getAllOrders(@RequestParam String id) {
        return this.productServiceImpl.getAllOrders(id);
    }

    @PostMapping("/createOrder")
    public Product createOrder(@RequestBody Product product) {
        return this.productServiceImpl.createOrder(product);
    }
}
