package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.DbConfig;
import ru.geekbrains.dao.Dao;
import ru.geekbrains.dao.product.JdbcTemplateProductDao;
import ru.geekbrains.dao.product.NamedParameterJDBCTemplateProductDao;
import ru.geekbrains.dao.product.OldJdbcProductDao;
import ru.geekbrains.dao.product.SpringJDBCProductDao;
import ru.geekbrains.entity.Product;

public class ShopApp {

    public static void main(String[] args) {
        printProducts(new OldJdbcProductDao());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

        printProducts(context.getBean(SpringJDBCProductDao.class));

        printProducts(context.getBean(NamedParameterJDBCTemplateProductDao.class));

        printProducts(context.getBean(JdbcTemplateProductDao.class));

//        AnnotationConfigApplicationContext contextHibernate = new AnnotationConfigApplicationContext(
//                HibernateConfig.class);
//        printProducts(contextHibernate.getBean(Dao.class));
    }

    static void printProducts(Dao<Product> dao) {
        System.out.println("-----------------" + dao.getClass().getSimpleName() + "--------------------");
        System.out.println("------findById-------");
        System.out.println(dao.findById(3L));
        System.out.println("------findNameById-------");
        System.out.println(dao.findNameById(5L));
        System.out.println("------findAll-------");
        Iterable<Product> products = dao.findAll();
        if (products == null) {
            System.out.println("empty");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
