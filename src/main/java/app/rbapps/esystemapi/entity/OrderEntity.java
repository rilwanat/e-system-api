package app.rbapps.esystemapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String jobInfo;
    private String fileUrl;

}
