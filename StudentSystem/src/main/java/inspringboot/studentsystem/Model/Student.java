package inspringboot.studentsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;


@Data
@AllArgsConstructor
public class Student {
    private String ID ;
    private String name ;
    private int age ;
    private int degree ;
    private double GPA ;
}
