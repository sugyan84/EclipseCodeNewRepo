package com.bharaththippireddy.trainings.jaxrs;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public interface PatientService {

	Patient getPatient(String id);

	Response updatePatient(Patient patient);

	Status addPatient(Patient patient);

	Response deletePatients(String id);

	Prescription getPrescription(String prescriptionId);

}