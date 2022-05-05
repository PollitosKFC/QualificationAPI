package pe.edu.upc.qualificationapi.EasyJobs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="tbl_technicianQualification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianQualification {
    @Id
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
    private Double qualificationAverage;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name ="technician_id",unique = true)
    private Technician technician;
}
