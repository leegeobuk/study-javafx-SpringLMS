package woowa.lms.back.domain.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woowa.lms.back.domain.rental.Rental;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor
@Getter
public abstract class Account {

    @Id
    @Column(name = "account_id", length = 15)
    private String id;

    @Column(nullable = false, length = 15)
    @Setter
    private String pw;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "auth", nullable = false)
    protected AccountType accountType;

    @Column(nullable = false, length = 30)
    @Setter
    private String name;

    @Column(nullable = false, length = 11)
    @Setter
    private String contact;

    @OneToMany(mappedBy = "account")
    private List<Rental> rentals = new ArrayList<>();

    protected Account(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
