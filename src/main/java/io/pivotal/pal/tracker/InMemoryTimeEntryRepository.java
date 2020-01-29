package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryTimeEntryRepository implements  TimeEntryRepository {

    HashMap<Long, TimeEntry> data = new HashMap<Long, TimeEntry>();
    long id =0L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++id);
        data.put(timeEntry.getId(),timeEntry);
        return find(id);

    }

    @Override
    public TimeEntry find(long Id) {
        return data.get(id);
    }

    @Override
    public TimeEntry update(long Id, TimeEntry timeEntry) {
        timeEntry.setId(Id);
        //if(data.containsValue(timeEntry)) {
        if(data.get(Id)!=null){
            data.put(Id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    @Override
    public TimeEntry delete(long Id) {
        TimeEntry old = find(Id);
        data.remove(Id);
        return old;
    }

    @Override
    public List list() {
        return new ArrayList(data.values());
    }
}