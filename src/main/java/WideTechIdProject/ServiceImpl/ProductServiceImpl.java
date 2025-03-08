package WideTechIdProject.ServiceImpl;

import WideTechIdProject.Model.Product;
import WideTechIdProject.Repository.OrderRepository;
import WideTechIdProject.Service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Pair<List<Product>, Long> getAllOrders(String id) {
        List<Product> productList = this.orderRepository.findAll();
        Long total = 0L;
        for (Product product : productList) {
            if (product.getCustomerName().equals(id)) {
                total+= product.getPrice();
            }
        }
        return Pair.of(productList, total);
    }

    @Override
    public Product createOrder (Product product) {
        return orderRepository.save(setProduct(product));
    }

    private Product setProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setType(product.getType());
        newProduct.setCustomerName("Alfan");
        newProduct.setCustomerAddress("Address");
        return newProduct;
    }
}
