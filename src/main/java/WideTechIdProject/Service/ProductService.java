package WideTechIdProject.Service;


import WideTechIdProject.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;

public interface ProductService {
    Pair<Page<Product>, Long> getAllOrders (String id, Pageable pageable);

    Product createOrder (Product product);
}
