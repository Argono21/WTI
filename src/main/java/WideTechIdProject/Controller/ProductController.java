package WideTechIdProject.Controller;

import WideTechIdProject.Model.Product;
import WideTechIdProject.ServiceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @GetMapping("/orders")
    public Pair<Page<Product>, Long> getAllOrders(@RequestParam String id,
        @PageableDefault(size = 2, page = 0) Pageable pageable) {
        return this.productServiceImpl.getAllOrders(id, pageable);
    }

    @PostMapping("/createOrder")
    public Product createOrder(@RequestBody Product product) {
        return this.productServiceImpl.createOrder(product);
    }
}
