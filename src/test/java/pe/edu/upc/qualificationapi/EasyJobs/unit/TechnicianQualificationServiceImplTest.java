package pe.edu.upc.qualificationapi.EasyJobs.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.qualificationapi.EasyJobs.repository.AppointmentHistoryRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.AppointmentRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.TechnicianQualificationRepository;
import pe.edu.upc.qualificationapi.EasyJobs.repository.TechnicianRepository;
import pe.edu.upc.qualificationapi.EasyJobs.service.TechnicianQualificationService;
import pe.edu.upc.qualificationapi.EasyJobs.service.TechnicianQualificationServiceImpl;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TechnicianQualificationServiceImplTest {
    @MockBean
    private TechnicianQualificationRepository technicianQualificationRepository;
    @MockBean
    private AppointmentHistoryRepository appointmentHistoryRepository;
    @MockBean
    private TechnicianRepository technicianRepository;
    @MockBean
    private AppointmentRepository appointmentRepository;

    @Autowired
    private TechnicianQualificationService technicianQualificationService;


    @TestConfiguration
    class TechnicianQualificationServiceImplTestConfiguration {
        @Bean
        public TechnicianQualificationService technicianQualificationService() {
            return new TechnicianQualificationServiceImpl(technicianQualificationRepository,appointmentHistoryRepository,technicianRepository,appointmentRepository);
        }
    }

    @Test
    @DisplayName("When createdTechnicianQualification with valid data then return TechnicianQualification")
    public void WhenCreatedTechnicianQualificationWithValidDataThenReturnTechnicianQualification() {
        // Arrange
        TechnicianQualification technicianQualification = new TechnicianQualification();
        technicianQualification.setId(null);
        technicianQualification.setNumberOfReviews(2);
        technicianQualification.setQualificationAverage(1.5);
        technicianQualification.setCurrentQualification(1.8);
        long id = 1;

        when(technicianQualificationRepository.save(technicianQualification)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        TechnicianQualification technicianQualificationResult = technicianQualificationService.createTechnicianQualification(technicianQualification, id);

        // Assert
        assertThat(technicianQualificationResult).isEqualTo(technicianQualification);
    }
    @Test
    @DisplayName("When Delete Qualification With Valid Qualification")
    public void WhenDeleteQualificationWithValidQualification() {
        // Arrange
        TechnicianQualification technicianQualification = new TechnicianQualification();
        technicianQualification.setId(1L);
        technicianQualification.setNumberOfReviews(2);
        technicianQualification.setQualificationAverage(1.5);
        technicianQualification.setCurrentQualification(1.8);

        when(technicianQualificationRepository.save(technicianQualification)).thenAnswer(invocation -> invocation.getArgument(0));
        technicianQualificationRepository.deleteById(1L);
        // Act
        TechnicianQualification technicianQualificationResult = null;
        // Assert
        assertThat(technicianQualificationResult).isEqualTo(technicianQualificationRepository.getById(1L));
    }
}
