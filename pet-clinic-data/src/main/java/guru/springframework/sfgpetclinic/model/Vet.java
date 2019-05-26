package guru.springframework.sfgpetclinic.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    //FetchType ManyToMany icin lazy olarak gelir. Eager yaparak butun typelarin cagirilmasini beklemeden bir anda yuklenmesi saglanmistir.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specilities", joinColumns = @JoinColumn(name = "vet_specilities"), inverseJoinColumns = @JoinColumn(name = "specility_id"))
    private Set<Speciality> specialities = new HashSet<>();


    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}