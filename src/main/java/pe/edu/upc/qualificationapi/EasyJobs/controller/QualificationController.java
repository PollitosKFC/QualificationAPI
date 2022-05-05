package pe.edu.upc.qualificationapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.qualificationapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.qualificationapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.qualificationapi.EasyJobs.service.TechnicianQualificationService;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value="/Qualification")
public class QualificationController {

    @Autowired
    private TechnicianQualificationService technicianQualificationService;

    @PostMapping("/createTechnicianQualification")
    public ResponseEntity<AppointmentHistory> updateAppointmentHistoryQualification(@RequestBody AppointmentHistory appointmentHistory,
                                                                                    @RequestParam(name = "technicianId",required = false) Long technicianId) {
        AppointmentHistory appointmentCreated = technicianQualificationService.updateAppointmentHistoryQualificationAverage(appointmentHistory, technicianId);
        return ResponseEntity.ok(appointmentCreated);
    }
    @PostMapping("/editTechnicianQualification")
    public ResponseEntity<TechnicianQualification> editTechnicianQualification(@RequestParam(name = "technicianId",required = false) Long TechnicianId,
                                                                               @RequestParam(name = "qualification",required = false) Double qualification) {
        TechnicianQualification technicianQualification = technicianQualificationService.editTechnicianQualification(TechnicianId, qualification);
        return ResponseEntity.ok(technicianQualification);
    }

    @GetMapping("/TechnicianQualificationByTechnicianId")
    public ResponseEntity<TechnicianQualification> findTechnicianQualificationByTechnicianId(@RequestParam(name = "technicianId",required = false) Long technicianId) {
        TechnicianQualification technicianQualification = technicianQualificationService.findTechnicianQualificationByTechnicianId(technicianId);
        if (technicianQualification == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicianQualification);
    }

}
