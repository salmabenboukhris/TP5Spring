package test;

import dao.IDao;
import entities.Product;
import entities.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean(IDao.class);

        Category category = new Category();
        category.setName("Informatique");

        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(1200);
        product.setCategory(category);

        productDao.create(product);

        System.out.println("Produit avec catégorie sauvegardé !");
    }
}