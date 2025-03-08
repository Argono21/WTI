package WideTechIdProject.Repository;

import WideTechIdProject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Product, Long> {

}
