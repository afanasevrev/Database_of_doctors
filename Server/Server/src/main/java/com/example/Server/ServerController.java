package com.example.Server;

import com.example.Server.db.Doctor;
import com.example.Server.db.Patient;
import com.example.Server.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Контроллер, управляет записями в БД
 * отвечает на запросы клиентов
 */
@RestController
public class ServerController {
    /**
     * Общий запрос, наберите в браузере http://localhost:8080/
     * вместо localhost - IP адрес сервера
     * @return "База данных поликлиники"
     */
    @GetMapping("/")
    private String getInfo() {
        return "База данных поликлиники";
    }
    /**
     * Метод записывает в БД нового врача
     * @param doctor
     */
    public synchronized void writeDoctor(Doctor doctor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Старт транзакции
            transaction = session.beginTransaction();
            // Добавим в БД клиента
            session.persist(doctor);
            // Коммит транзакции
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Метод записывает в БД нового пациента
     * @param patient
     */
    public synchronized void writePatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Старт транзакции
            transaction = session.beginTransaction();
            // Добавим в БД клиента
            session.persist(patient);
            // Коммит транзакции
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
