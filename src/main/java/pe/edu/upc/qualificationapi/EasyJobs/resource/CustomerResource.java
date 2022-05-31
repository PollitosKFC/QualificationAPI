package pe.edu.upc.qualificationapi.EasyJobs.resource;

import lombok.Data;

@Data
public class CustomerResource {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Long phoneNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String district;
    private String gender;
    private Boolean activated;
}
