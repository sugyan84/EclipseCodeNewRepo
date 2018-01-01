package com.bharaththippireddy.trainings.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

public class PatientServiceImpl implements PatientService
{
	private long			currentId		= 123;
	Map<Long, Patient>		patients		= new HashMap<Long, Patient>();
	Map<Long, Prescription>	prescriptions	= new HashMap<Long, Prescription>();

	public PatientServiceImpl()
	{
		init();
	}

	final void init()
	{
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(currentId);
		patients.put(patient.getId(), patient);

		Prescription prescription = new Prescription();
		prescription.setDescription("prescription 223");
		prescription.setId(223);
		prescriptions.put(prescription.getId(), prescription);
	}

	public Response addPatient(Patient patient)
	{
		System.out.println("...invoking add Patient: " + patient.getId() + "--" + patient.getName());

		patient.setId(++currentId);
		patients.put(patient.getId(), patient);

		return Response.ok(patient).build();
	}

	public Patient getPatient(String id)
	{
		long tempId = Long.parseLong(id);

		Patient tempObj = patients.get(tempId);

		return tempObj;
	}

	public Response updatePatient(Patient updatedPatient)
	{
		Patient currentPatient = patients.get(updatedPatient.getId());

		Response res = null;

		if(currentPatient != null)
		{
			patients.put(updatedPatient.getId(), updatedPatient);
			res = res.ok().build();
		}
		else
		{
			res = res.notModified().build();
		}

		return res;
	}

	public Response deletePatients(String id)
	{
		long tempId = Long.parseLong(id);
		
		Response res = null;
		
		if(patients.containsKey(tempId))
		{
			patients.remove(tempId);
			res = res.ok().build();
		}
		else
		{
			res = res.notModified().build();
		}
		return res;
	}

	public Prescription getPrescription(String prescriptionId)
	{

		return null;
	}

}
