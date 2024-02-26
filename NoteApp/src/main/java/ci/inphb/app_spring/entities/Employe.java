package ci.inphb.app_spring.entities;

import ci.inphb.app_spring.enums.Sexe;
import ci.inphb.app_spring.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    private String typeContrat;

    private String fonction;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String CNI;

    private Double salaire;

    @Enumerated(value = EnumType.STRING)
    private Sexe sexe;

    private String adresse;

    @Column(nullable = false, unique = true)
    private String matricule;

    @Column(nullable = false, unique = true)
    private String telephone;

    private String nationnalite;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(length = 1000)
    private String notes;

    @Column(name = "created_at",nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Photo photo;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleUser> roles=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Grade grade;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Conge> congeList;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Absence> absences;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<DetailDoc> detailDocs;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Formation> formations;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Notification> notifications;

}
