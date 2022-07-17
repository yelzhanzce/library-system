package kz.samgau.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Library library;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "shelve_id", referencedColumnName = "id")
    private Shelve shelve;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "book_categories",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories;

//    @ManyToOne
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    private Student student;
}
