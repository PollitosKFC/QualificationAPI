package pe.edu.upc.qualificationapi.EasyJobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;

@Qualifier("appointmentHistoryRepository")
@Repository
public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistory, Long> {
    @Query(value ="SELECT count(ah) FROM AppointmentHistory ah WHERE ah.appointment.technician.id = ?1")
    Double countTechnicianQualificationByTechnicianId(Long id);
}
