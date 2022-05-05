package pe.edu.upc.qualificationapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.qualificationapi.EasyJobs.entity.Technician;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;

@Service
public interface TechnicianQualificationService {
    TechnicianQualification findTechnicianQualificationByTechnicianId(Long id);
    TechnicianQualification editTechnicianQualification(Long id, Double qualification);
    AppointmentHistory updateAppointmentHistoryQualificationAverage(AppointmentHistory appointmentHistory, Long technicianId);
    TechnicianQualification createTechnicianAverageQualification(Long technicianId, Double qualification);
}
