package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Category;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import co.edu.escuelaing.cvds.lab7.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService ProductService) {
        this.productService = ProductService;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllproducts();
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }
    @DeleteMapping("/product/{id}")
    @ResponseBody
    public void delProduct(@PathVariable int id){
        productService.deleteproduct(id);
    }
    @PutMapping("/Product/{id}")
    @ResponseBody
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }
    @PostMapping("/product")
    @ResponseBody
    public Product createProduct(@RequestBody Product Product) {
        return productService.addproduct(Product);
    }
    @PatchMapping("product/{id}")
    public Product patchProduct(@PathVariable int id, @RequestBody Product product) {
        Product productParcial = productService.getProduct(id);

        if(product.getName() != null){
            productParcial.setName(product.getName());
        }
        if(product.getDescription() != null){
            productParcial.setDescription(product.getDescription());
        }
        if(product.getCategory() != null){
            productParcial.setCategory(product.getCategory());
        }
        if(product.getRating() != -1){
            productParcial.setRating(product.getRating());
        }
        if(product.getPrice() != -1){
            productParcial.setPrice(product.getPrice());
        }
        if(product.getQuantity() != -1){
            productParcial.setQuantity(product.getQuantity());
        }
        Product updatedProduct = productService.updateProduct(id, productParcial);

        return updatedProduct;
    }
}