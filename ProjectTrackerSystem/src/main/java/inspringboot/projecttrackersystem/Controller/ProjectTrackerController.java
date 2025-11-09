package inspringboot.projecttrackersystem.Controller;

import inspringboot.projecttrackersystem.ApiResponse.ApiResponse;
import inspringboot.projecttrackersystem.Model.ProjectTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project-tracker")
public class ProjectTrackerController {
    ArrayList<ProjectTracker> projectTrackers = new ArrayList<>() ;

    @PutMapping("/add")
    public ApiResponse add(ProjectTracker projectTracker){
    projectTrackers.add(projectTracker);
    return new ApiResponse("added successfully");
    }

    @GetMapping("/display")
    public ArrayList<ProjectTracker> display(){
        return projectTrackers ;
    }

    @PutMapping("/update")
    public ApiResponse update(){
        return new ApiResponse("update successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index){
        projectTrackers.remove(index);
        return new ApiResponse("delete successfully ");
    }


    @PatchMapping("/change-status/{index}")
    public ApiResponse changeStatus(@PathVariable int index, @RequestBody ProjectTracker updatedProject) {
        ProjectTracker existing = projectTrackers.get(index);
        existing.setStatus(updatedProject.isStatus());
        return new ApiResponse("status changed");
    }

    @GetMapping("/search-by-title/{title}")
    public ProjectTracker searchByTitle(@PathVariable String title){
        for(ProjectTracker p : projectTrackers){
            if(p.getTitle().equals(title)){
                return p ;
            }
        }
        return null ;
    }

    @GetMapping("/search-by-company/company")
    public ArrayList<ProjectTracker> searchByCompany(@RequestBody String company){
        ArrayList<ProjectTracker> byName = new ArrayList<>();
        for(ProjectTracker p : projectTrackers){
            if(p.getCompanyName().equals(company)){
                byName.add(p);
            }
        }
        return byName ;
    }

}