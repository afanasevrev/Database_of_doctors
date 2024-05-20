package com.example.Server;

import com.example.Server.db.Doctor;
import com.example.Server.db.MedicalRecord;
import com.example.Server.db.Patient;
import com.example.Server.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
     * По запросу от клиента добавляем в БД врача
     * @param firstName фамилия
     * @param specialty специальность
     * @param office рабочий кабинет
     * @param phone телефон
     * @return статус выполнения запроса
     */
    @GetMapping("/createDoctor/{firstName}&{specialty}&{office}&{phone}")
    private String createDoctor(@PathVariable String firstName, @PathVariable String specialty, @PathVariable String office, @PathVariable String phone) {
        Doctor doctor = new Doctor(firstName, specialty, office, phone);
        writeDoctor(doctor);
        return "Врач успешно добавлен в БД";
    }
    /**
     * По запросу от клиента добавляем в БД пациента
     * @param firstName фамилия
     * @param insuranceNumber номер страхового полиса
     * @param address адрес
     * @param section номер участка
     * @return статус выполнения запроса
     */
    @GetMapping("/createPatient/{firstName}&{insuranceNumber}&{address}&{section}")
    private String createPatient(@PathVariable String firstName, @PathVariable String insuranceNumber, @PathVariable String address, @PathVariable String section) {
        Patient patient = new Patient(firstName, insuranceNumber, address, section);
        writePatient(patient);
        return "Пациент успешно добавлен";
    }
    /**
     * По запросу клиента добавлет мед. карту в БД
     * @param patientID ID пациента
     * @param doctorID ID врача
     * @param diagnosis диагноз
     * @param prescription Назначение
     * @return статус выполнения запроса
     */
    @GetMapping("/createMedicalRecord/{patientID}&{doctorID}&{diagnosis}&{prescription}")
    private String createMedicalCard(@PathVariable String patientID, @PathVariable String doctorID, @PathVariable String diagnosis, @PathVariable String prescription) {
        try {
            int patient_ID = Integer.parseInt(patientID);
            int doctor_ID = Integer.parseInt(doctorID);
            writeMedicalRecord(doctor_ID, patient_ID, diagnosis, prescription);
            return "Медицинская карта успешно добавлена в БД";
        } catch (NumberFormatException e) {
            return "Ошибка при добавлении";
        }
    }
    /**
     * По запросу от клиента, метод вытягивает из БД список врачей
     * @return
     */
    @GetMapping("/getDoctors")
    private List<Doctor> getDoctorsList() {
        List<Doctor> doctorsList = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Старт транзакции
            transaction = session.beginTransaction();
            doctorsList = session.createQuery("from Doctor", Doctor.class).getResultList();
            // Коммит транзакции
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return doctorsList;
    }
    /**
     * По запросу от клиента, метод вытягивает из БД список пациентов
     * @return
     */
    @GetMapping("/getPatients")
    private List<Patient> getPatientsList() {
        List<Patient> patientsList = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Старт транзакции
            transaction = session.beginTransaction();
            patientsList = session.createQuery("from Patient", Patient.class).getResultList();
            // Коммит транзакции
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return patientsList;
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
            // Добавим в БД врача
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
            // Добавим в БД пациента
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
    /**
     * Метод записывает в БД новую медицинскую карту
     * @param doctorId - id лечащего врача
     * @param patientId - id пациента
     * @param diagnosis - диагноз пациента
     * @param prescription - лечение
     */
    private void writeMedicalRecord(int doctorId, int patientId, String diagnosis, String prescription) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Старт транзакции
            transaction = session.beginTransaction();
            // Выдергиваем из БД доктора
            Doctor doctor = session.get(Doctor.class, doctorId);
            // Выдергиваем из БД пациента
            Patient patient = session.get(Patient.class, patientId);
            // Создание новой медицинской карты
            MedicalRecord medicalRecord = new MedicalRecord();
            medicalRecord.setDoctor(doctor);
            medicalRecord.setPatient(patient);
            medicalRecord.setDiagnosis(diagnosis);
            medicalRecord.setPrescription(prescription);
            // Добавим в БД клиента
            session.persist(medicalRecord);
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
