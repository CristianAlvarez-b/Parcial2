package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addproduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(int productId) {
        // Obtener la lista de empleados que coinciden con el ID proporcionado
        List<Product> products = productRepository.findByProductId(productId);

        // Verificar si la lista tiene algún empleado
        if (!products.isEmpty()) {
            // Si la lista tiene empleados, devolver el primero
            return products.get(0);
        } else {
            // Si la lista está vacía, no se encontró ningún empleado con el ID proporcionado
            return null;
        }
    }

    public List<Product> getAllproducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(int id, Product product) {
        // Obtener la lista de empleados que coinciden con el ID proporcionado
        List<Product> products = productRepository.findByProductId(id);
        // Verificar si la lista no está vacía, lo que significa que el empleado existe
        if (!products.isEmpty()) {
            // Guardar el empleado actualizado en la base de datos
            return productRepository.save(product);
        } else {
            // Si la lista está vacía, el empleado no existe en la base de datos
            return null;
        }
    }

    public void deleteproduct(int productId) {
        productRepository.deleteById(productId);
    }

}