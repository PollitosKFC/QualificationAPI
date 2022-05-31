package pe.edu.upc.qualificationapi.EasyJobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Appointment;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Customer;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;
import pe.edu.upc.qualificationapi.EasyJobs.repository.AppointmentRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.CustomerRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.TechnicianRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final TechnicianRepository technicianRepository;

    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment, Long customerId, Long technicianId) {
        Appointment newAppointment = new Appointment();
        if (customerRepository.existsById(customerId) && technicianRepository.existsById(technicianId)) {
            newAppointment.setCustomer(customerRepository.findById(customerId).orElse(null));
            newAppointment.setTechnician(technicianRepository.findById(technicianId).orElse(null));
            newAppointment.setName(appointment.getName());
            newAppointment.setCreatedDate(new Date());
            newAppointment.setUpdateDate(new Date());
            newAppointment.setStartDate(new Date());
            newAppointment.setDelete(false);
            newAppointment.setStatus(appointment.getStatus());
            newAppointment.setAppointment_history(null);
            return appointmentRepository.save(newAppointment);
        }
        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Technician createTechnician(Technician technician) {
        Technician newTechnician = new Technician();
        newTechnician.setUserName(technician.getUserName());
        newTechnician.setRegisterDate(new Date());
        newTechnician.setUpdatedDate(new Date());
        newTechnician.setFirstName(technician.getFirstName());
        newTechnician.setLastName(technician.getLastName());
        newTechnician.setEmail(technician.getEmail());
        newTechnician.setVerified(technician.getVerified());
        newTechnician.setPassword(technician.getPassword());
        newTechnician.setPhoneNumber(technician.getPhoneNumber());
        newTechnician.setAddress(technician.getAddress());
        newTechnician.setCity(technician.getCity());
        newTechnician.setDistrict(technician.getDistrict());
        newTechnician.setGender(technician.getGender());
        newTechnician.setType("TECHNICIAN");
        newTechnician.setVerified(false);
        newTechnician.setActivated(true);
        newTechnician.setIdentificationType(technician.getIdentificationType());
        newTechnician.setIdentificationNumber(technician.getIdentificationNumber());
        newTechnician.setTechnician_appointment(null);
        newTechnician.setTechnician_qualification(null);
        return technicianRepository.save(newTechnician);
    }

    @Override
    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setUserName(customer.getUserName());
        newCustomer.setRegisterDate(new Date());
        newCustomer.setUpdatedDate(new Date());
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setCity(customer.getCity());
        newCustomer.setDistrict(customer.getDistrict());
        newCustomer.setGender(customer.getGender());
        newCustomer.setType("CUSTOMER");
        newCustomer.setActivated(true);
        return customerRepository.save(newCustomer);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
