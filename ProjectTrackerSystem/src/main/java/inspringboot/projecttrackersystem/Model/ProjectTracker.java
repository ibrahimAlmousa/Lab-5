package inspringboot.projecttrackersystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTracker {
    private String ID ;
    private String title ;
    private String description ;
    private boolean status ;
    private String companyName ;

}
