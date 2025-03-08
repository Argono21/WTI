package WideTechIdProject.Service;


import WideTechIdProject.Model.Product;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ProductService {
    Pair<List<Product>, Long> getAllOrders (String id);

    Product createOrder (Product product);
}
