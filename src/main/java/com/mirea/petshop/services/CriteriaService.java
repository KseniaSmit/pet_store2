package com.mirea.petshop.services;
import com.mirea.petshop.models.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Класс-сервис для фильтрации моделей по полю
 * @author Сметанникова Ксения
 */
@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CriteriaService {
    /**
     * Неизменяемый потокобезопасный объект с компилированным маппингом для одной базы данных
     */
    private final SessionFactory sessionFactory;
    /**
     * Однопоточный короткоживущий объект, который предоставляет связь между объектами приложения и базой данных
     */
    private Session session;
    /**
     * Конструктор определяющий session
     */
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    /**
     * Деструктор освобождающий session
     */
    @PreDestroy
    /**
     * Метод фильтрует модели продуктов по введенной строке
     * @param searchName Название продукта
     * @return Возвращает список продуктов, название которых соответствует переданной строке
     */
    void closeSession() {
        session.close();
    }
    public List<Product> getAllByName(String searchWord) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> orderCriteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = orderCriteriaQuery.from(Product.class);
        String searchNames = "%" + searchWord + "%";
        orderCriteriaQuery.select(root).where(builder.like(root.get("name"), searchNames));
        Query<Product> query = session.createQuery(orderCriteriaQuery);
        return query.getResultList();
    }

}

