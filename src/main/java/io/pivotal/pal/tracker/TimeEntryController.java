package io.pivotal.pal.tracker;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;

    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate)
    {
        TimeEntry created = timeEntryRepository.create(timeEntryToCreate);

        return  new ResponseEntity(created, HttpStatus.CREATED);


    }

    @GetMapping("{Id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long Id) {
        TimeEntry found = timeEntryRepository.find(Id);
        if(found==null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(found, HttpStatus.OK);
    }

    @PutMapping("{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry found = timeEntryRepository.update(timeEntryId,expected);
        if(found==null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {

        return new ResponseEntity<>(timeEntryRepository.delete(timeEntryId),HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        return new ResponseEntity<>(timeEntryRepository.list(),HttpStatus.OK);
    }


    public long getId() {
        return 0L;
    }
}