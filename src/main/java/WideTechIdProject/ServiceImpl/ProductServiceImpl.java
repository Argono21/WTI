package WideTechIdProject.ServiceImpl;

import WideTechIdProject.Model.Product;
import WideTechIdProject.Repository.OrderRepository;
import WideTechIdProject.Service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Pair<Page<Product>, Long> getAllOrders(String id, Pageable pageable) {
        List<Product> productList = this.orderRepository.findAll();

        List<Product> filteredProducts = productList.stream()
                .filter(product -> product.getCustomerName().equals(id))
                .toList();
        Long total = filteredProducts.stream()
                .mapToLong(totalPrice -> totalPrice.getPrice() * totalPrice.getQuantity())
                .sum();

        List<Product> paginatedProducts = setPagination(pageable, filteredProducts);
        return Pair.of(new PageImpl<>(paginatedProducts, pageable, filteredProducts.size()), total);
    }

    private static List<Product> setPagination(Pageable pageable, List<Product> filteredProducts) {
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), filteredProducts.size());
        return filteredProducts.subList(start, end);
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
