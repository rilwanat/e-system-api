package app.rbapps.esystemapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String jobInfo;
    private String fileUrl;
}
