package kz.samgau.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shelve")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shelve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "shelve_id")
    private String shelveId;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Library library;
}
