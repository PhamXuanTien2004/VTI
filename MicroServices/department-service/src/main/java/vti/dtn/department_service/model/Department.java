package vti.dtn.department_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Department {
    private String name;
//    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
}
