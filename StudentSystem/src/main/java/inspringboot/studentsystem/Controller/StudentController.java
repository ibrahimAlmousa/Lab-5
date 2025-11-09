package inspringboot.studentsystem.Controller;

import inspringboot.studentsystem.ApiResponse.ApiResponse;
import inspringboot.studentsystem.Model.Student;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Data
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();


    @PostMapping ("/add")
    public ApiResponse addStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("added successfully ");
    }

    @GetMapping("/get")
    public ArrayList<Student> display(){
        return students ;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody Student student ,@PathVariable int index ){
        students.set(index , student);
        return new ApiResponse("update successfully ");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("delete successfully");
    }

    @GetMapping("/classify/{ID}")
    public ApiResponse classify(@PathVariable String ID){
        double honer = 0;
        for(Student s : students){
            if(s.getID().equals(ID)){
                honer = s.getGPA() ;
            }
        }
        if(honer>=4.75){
            return new ApiResponse("first honer");
        }
        else if (honer<4.75 && honer>=4.25) {
            return new ApiResponse("second honer");
        }
        else{
            return new ApiResponse("without honer");
        }
    }

    @GetMapping("display-above-average")
    public ArrayList<Student> displayAboveAverage(){
        ArrayList<Student> aboveAverage = new ArrayList<>();
        double sum = 0 ;
        double average = 0 ;
        for (Student s : students){
            sum = sum + s.getGPA() ;
        }
        average = sum/students.size();

        for (Student s :students){
            if(s.getGPA()>=average){
                aboveAverage.add(s);
            }
        }
        return aboveAverage ;
    }




}
