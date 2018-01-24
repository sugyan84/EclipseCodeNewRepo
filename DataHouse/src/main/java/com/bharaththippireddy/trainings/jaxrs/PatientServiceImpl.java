package com.bharaththippireddy.trainings.jaxrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.exceptions.NoDataFoundException;

@Path("/patients")
public class PatientServiceImpl/* implements PatientService */
{
	static private long			currentId	= 123;
	static Map<Long, Patient>	patients	= new HashMap<Long, Patient>();
	// Map<Long, Prescription> prescriptions = new HashMap<Long,
	// Prescription>();

	public PatientServiceImpl()
	{

	}

	static
	{
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(currentId++);
		patients.put(patient.getId(), patient);

		Patient patient2 = new Patient();
		patient2.setName("Sugyan");
		patient2.setId(currentId++);
		patients.put(patient2.getId(), patient2);

		/*
		 * Prescription prescription = new Prescription();
		 * prescription.setDescription("prescription 223");
		 * prescription.setId(223); prescriptions.put(prescription.getId(),
		 * prescription);
		 */
	}

	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getAllPatients()
	{

		List<Patient> list = new ArrayList<Patient>(patients.size());

		Iterator<Entry<Long, Patient>> s = patients.entrySet().iterator();

		while (s.hasNext())
		{
			Entry<Long, Patient> e = s.next();

			Patient p = e.getValue();

			list.add(p);
		}

		return list;
	}

	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Status addPatient(Patient patient)
	{

		patient.setId(currentId++);

		patients.put(patient.getId(), patient);

		return Response.Status.CREATED;
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("id") Long id)
	{
		Patient retVal = null;

		if(patients.containsKey(id))
		{
			retVal = patients.get(id);
		}
		else
		{
			throw new NoDataFoundException("No Patient with the id = "+id+" was found in our database!");
		}

		return retVal;

	}

	/*@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePatient(Patient updatedPatient)
	{

		return null;
	}

	public Response deletePatients(String id)
	{

		return null;
	}

	public Prescription getPrescription(String prescriptionId)
	{

		return null;
	}*/

}
