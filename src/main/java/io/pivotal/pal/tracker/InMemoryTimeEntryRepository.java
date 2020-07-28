package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Long count = 0L;

    //List<TimeEntry> dummyData = new ArrayList<>();
    HashMap<Long,TimeEntry> repo = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        ++count;
        timeEntry.setId(count);
        repo.put(count,timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return repo.get(id);
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if(find(id) == null){
            return null;
        }
        timeEntry.setId(id);
        repo.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
      repo.remove(id);

    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(repo.values());
    }


    }
