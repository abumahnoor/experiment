package com.company.experiment.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "EXPERIMENT_CLAIM")
@Entity(name = "experiment$Claim")
public class Claim extends StandardEntity {
    private static final long serialVersionUID = -8595628006688490143L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    protected Patient patient;

    @Temporal(TemporalType.DATE)
    @Column(name = "CLAIM_DATE")
    protected Date claimDate;

    @Column(name = "PROVIDER_NAME")
    protected String providerName;

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }


}