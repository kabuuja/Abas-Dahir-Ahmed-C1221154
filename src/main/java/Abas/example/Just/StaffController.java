package Abas.example.Just;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")

public class StaffController {
    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping
    public List<Staff> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable Long id) {
        Staff staff = service.getById(id);
        if (staff == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(staff);
    }

    @PostMapping
    public ResponseEntity<Staff> create(@RequestBody Staff staff) {
        Staff created = service.create(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> update(@PathVariable Long id, @RequestBody Staff staff) {
        return ResponseEntity.ok(service.update(id, staff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
