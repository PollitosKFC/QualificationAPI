package pe.edu.upc.qualificationapi.EasyJobs.resource;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentResource {
    private Long id;
    private String name;
    private Date createdDate;
    private Date updateDate;
    private String status;
    private Date startDate;
    private Boolean delete;
}
