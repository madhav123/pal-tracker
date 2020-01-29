package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long Id);
    TimeEntry update(long Id, TimeEntry timeEntry);
    TimeEntry delete(long Id);

    List list();

}
