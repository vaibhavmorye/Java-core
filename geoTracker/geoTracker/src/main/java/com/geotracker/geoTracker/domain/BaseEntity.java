package com.geotracker.geoTracker.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private Long	createdBy;
    @Column(name = "created_date", nullable = false)
    @CreatedDate
    private Date createdDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long	id;
    @Column(name = "updated_by")
    @LastModifiedBy
    private Long	updatedBy;
    @Column(name = "updated_date")
    @LastModifiedDate
    private Date	updatedDate;

    /**
     * This flag must be used for the Objects being created without the User's
     * Login, Which will be used to bypass the Creator/Updater Audit
     */
    @Transient
    private boolean withoutLogin = false;

    public Long getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Long getId() {
        return id;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public boolean isWithoutLogin() {
        return withoutLogin;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setWithoutLogin(boolean withoutLogin) {
        this.withoutLogin = withoutLogin;
    }

}
