package com.company.experiment.web.claim;

import com.company.experiment.entity.Patient;
import com.haulmont.cuba.gui.components.*;
import com.company.experiment.entity.Claim;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ClaimEdit extends AbstractEditor<Claim> {
    @Inject
    protected TextField memberNumber;

    @Inject
    protected LookupField patient;

    @Inject
    protected CollectionDatasource<Patient, UUID> patientByMemberNumberDs;

    @Inject
    protected CollectionDatasource<Patient, UUID> patientByNamesDs;

    @Inject
    protected Table personsTable;

    @Inject
    protected Button searchByMemberNumber;

    @Inject
    protected TextField firstName;

    @Inject
    protected TextField lastName;

    @Inject
    protected Datasource<Claim>  claimDs;

 //   @Inject
//    protected  BoxLayout patientDetails;

    @Inject FieldGroup patientDetails;

    public void refreshPatientList() {
        Map<String, Object> params = new HashMap<>();

        if (memberNumber.isEnabled() && StringUtils.length(memberNumber.getValue())>=3) {
            params.put("memberNumber", memberNumber.getValue() + "%");
            patientByMemberNumberDs.refresh(params);
            personsTable.setDatasource(patientByMemberNumberDs);
        }

        else if (StringUtils.length(firstName.getValue())>=2 || StringUtils.length(lastName.getValue())>=2) {
            params.put("firstName", "(?i)"+StringUtils.trimToEmpty(firstName.getValue()) + "%");
            params.put("lastName", "(?i)"+StringUtils.trimToEmpty(lastName.getValue()) + "%");
            patientByNamesDs.refresh(params);
            showNotification("Searching by name " + params.toString(), NotificationType.HUMANIZED);
            personsTable.setDatasource(patientByNamesDs);
        }

        personsTable.refresh();
    }

    public void selectPatient() {
        //if (personsTable.getSingleSelected() != null) {
            //showNotification(((Patient)personsTable.getSingleSelected()).getFirstName(), NotificationType.HUMANIZED);
            claimDs.getItem().setPatient((Patient)personsTable.getSingleSelected());
            patientDetails.setVisible(false);
            patientDetails.setVisible(true);

        //}
    }


    @Override
    public void init(Map<String, Object> params) {
        personsTable.setItemClickAction(personsTable.getAction("selectPatient"));

        /*patient.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChanged(ValueChangeEvent e) {
            }
        });*/

    }

}