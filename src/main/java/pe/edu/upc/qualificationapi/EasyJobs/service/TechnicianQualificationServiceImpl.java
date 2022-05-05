package pe.edu.upc.qualificationapi.EasyJobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.qualificationapi.EasyJobs.repository.AppointmentHistoryRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.TechnicianQualificationRepository;

@Service
@RequiredArgsConstructor
public class TechnicianQualificationServiceImpl implements TechnicianQualificationService {

    @Autowired
    private final TechnicianQualificationRepository technicianQualificationRepository;

    @Autowired
    private final AppointmentHistoryRepository appointmentHistoryRepository;


    @Override
    public TechnicianQualification createTechnicianAverageQualification(Long technicianId, Double qualification) {
        TechnicianQualification newTechnicianQualification = new TechnicianQualification();
        newTechnicianQualification.setId(technicianId);
        newTechnicianQualification.setQualificationAverage(qualification);
        return technicianQualificationRepository.save(newTechnicianQualification);
    }

    @Override
    public AppointmentHistory updateAppointmentHistoryQualificationAverage(AppointmentHistory technicianQualification, Long technicianId) {
        if(technicianQualificationRepository.findTechnicianQualificationByTechnicianId(technicianId) == null) {
            createTechnicianAverageQualification(technicianId, technicianQualification.getQualification());
        }
        return appointmentHistoryRepository.save(technicianQualification);
    }

    @Override
    public TechnicianQualification findTechnicianQualificationByTechnicianId(Long id) {
        return technicianQualificationRepository.findTechnicianQualificationByTechnicianId(id);
    }

    @Override
    public TechnicianQualification editTechnicianQualification (Long id, Double qualification) {
        TechnicianQualification technicianQualification = technicianQualificationRepository.findTechnicianQualificationByTechnicianId(id);
        Double qualificationAverage = ((technicianQualification.getQualificationAverage()) + qualification/appointmentHistoryRepository.countTechnicianQualificationByTechnicianId(id));
        technicianQualification.setQualificationAverage(qualificationAverage);
        return technicianQualificationRepository.save(technicianQualification);
    }
}
