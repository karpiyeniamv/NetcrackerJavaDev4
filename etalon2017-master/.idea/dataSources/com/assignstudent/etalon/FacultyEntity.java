package com.assignstudent.etalon;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "faculty", schema = "assignstudent", catalog = "")
public class FacultyEntity {
    private int id;
    private String facultyName;
    private Collection<com.assignstudent.etalon.RequestEntity> requestsById;
    private Collection<com.assignstudent.etalon.SpecialtyEntity> specialtiesById;
    private Collection<com.assignstudent.etalon.StudentEntity> studentsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "facultyName")
    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultyEntity that = (FacultyEntity) o;

        if (id != that.id) return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "facultyByFacultyId")
    public Collection<com.assignstudent.etalon.RequestEntity> getRequestsById() {
        return requestsById;
    }

    public void setRequestsById(Collection<com.assignstudent.etalon.RequestEntity> requestsById) {
        this.requestsById = requestsById;
    }

    @OneToMany(mappedBy = "facultyByFacultyId")
    public Collection<com.assignstudent.etalon.SpecialtyEntity> getSpecialtiesById() {
        return specialtiesById;
    }

    public void setSpecialtiesById(Collection<com.assignstudent.etalon.SpecialtyEntity> specialtiesById) {
        this.specialtiesById = specialtiesById;
    }

    @OneToMany(mappedBy = "facultyByFacultyId")
    public Collection<com.assignstudent.etalon.StudentEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<com.assignstudent.etalon.StudentEntity> studentsById) {
        this.studentsById = studentsById;
    }
}
