package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.HibernateConfig;
import ru.geekbrains.dao.ManufacturerDao;

public class ShopApp {

    public static void main(String[] args) {
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//
//
//        for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
        System.out.println(manufacturerDao.findById(3L));
        System.out.println(manufacturerDao.findNameById(5L));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }
    }
}
