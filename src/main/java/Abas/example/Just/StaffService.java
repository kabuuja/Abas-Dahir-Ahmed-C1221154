package Abas.example.Just;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class StaffService {
    private final Map<Long, Staff> staffMap = new HashMap<>();
    private long nextId = 1;

    public List<Staff> getAll() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getById(Long id) {
        return staffMap.get(id);
    }

    public Staff create(Staff staff) {
        staff.setId(nextId++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Staff update(Long id, Staff updatedStaff) {
        updatedStaff.setId(id);
        staffMap.put(id, updatedStaff);
        return updatedStaff;
    }

    public void delete(Long id) {
        staffMap.remove(id);
    }

}
