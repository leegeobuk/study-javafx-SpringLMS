package woowa.lms.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Library {

    @Id @GeneratedValue
    @Column(name = "lib_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "library")
    private List<OwnerLibrary> ownerLibraries = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<OwnerLibrary> getOwnerLibraries() {
        return ownerLibraries;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return id.equals(library.id);
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                '}';
    }
}
