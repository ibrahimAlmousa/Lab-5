package inspringboot.eventsystem.controller;

import inspringboot.eventsystem.ApiResponse.ApiResponse;
import inspringboot.eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @PutMapping("/add")
    public ApiResponse add(@RequestBody Event event){
        events.add(event);
        return new ApiResponse("added successfully");
    }

    @GetMapping("/display")
    public ArrayList<Event> display(){
        return events;
    }

    @PutMapping("/update/{index}")
    public ApiResponse update(@PathVariable int index, @RequestBody Event event){
        events.set(index, event);
        return new ApiResponse("update successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index){
        events.remove(index);
        return new ApiResponse("delete successfully");
    }

    @PatchMapping("/change-capacity/{index}")
    public ApiResponse changeCapacity(@PathVariable int index, @RequestBody Event updatedEvent){
        Event existing = events.get(index);
        existing.setCapacity(updatedEvent.getCapacity());
        return new ApiResponse("capacity changed");
    }

    @GetMapping("/search-by-id/{id}")
    public Event searchById(@PathVariable int id){
        for(Event e : events){
            if(e.getID().equals(id)) {
                return e;
            }
        }
        return null;
    }
}
