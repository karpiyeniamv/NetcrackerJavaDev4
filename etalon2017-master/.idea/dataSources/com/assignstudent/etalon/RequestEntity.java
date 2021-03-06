package com.assignstudent.etalon;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "request", schema = "assignstudent", catalog = "")
public class RequestEntity {
    private int id;
    private int companyId;
    private Date dateFrom;
    private Date dateTo;
    private int quantity;
    private Integer facultyId;
    private Integer specialtyId;
    private Integer score;
    private Collection<com.assignstudent.etalon.AssignrequestEntity> assignrequestsById;
    private com.assignstudent.etalon.CompanyEntity companyByCompanyId;
    private com.assignstudent.etalon.FacultyEntity facultyByFacultyId;
    private com.assignstudent.etalon.SpecialtyEntity specialtyBySpecialtyId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "companyId")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "dateFrom")
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "dateTo")
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "facultyId")
    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    @Basic
    @Column(name = "specialtyId")
    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestEntity that = (RequestEntity) o;

        if (id != that.id) return false;
        if (companyId != that.companyId) return false;
        if (quantity != that.quantity) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;
        if (facultyId != null ? !facultyId.equals(that.facultyId) : that.facultyId != null) return false;
        if (specialtyId != null ? !specialtyId.equals(that.specialtyId) : that.specialtyId != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + companyId;
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (facultyId != null ? facultyId.hashCode() : 0);
        result = 31 * result + (specialtyId != null ? specialtyId.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "requestByRequestId")
    public Collection<com.assignstudent.etalon.AssignrequestEntity> getAssignrequestsById() {
        return assignrequestsById;
    }

    public void setAssignrequestsById(Collection<com.assignstudent.etalon.AssignrequestEntity> assignrequestsById) {
        this.assignrequestsById = assignrequestsById;
    }

    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "id", nullable = false)
    public com.assignstudent.etalon.CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(com.assignstudent.etalon.CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    @ManyToOne
    @JoinColumn(name = "facultyId", referencedColumnName = "id")
    public com.assignstudent.etalon.FacultyEntity getFacultyByFacultyId() {
        return facultyByFacultyId;
    }

    public void setFacultyByFacultyId(com.assignstudent.etalon.FacultyEntity facultyByFacultyId) {
        this.facultyByFacultyId = facultyByFacultyId;
    }

    @ManyToOne
    @JoinColumn(name = "specialtyId", referencedColumnName = "id")
    public com.assignstudent.etalon.SpecialtyEntity getSpecialtyBySpecialtyId() {
        return specialtyBySpecialtyId;
    }

    public void setSpecialtyBySpecialtyId(com.assignstudent.etalon.SpecialtyEntity specialtyBySpecialtyId) {
        this.specialtyBySpecialtyId = specialtyBySpecialtyId;
    }
}
