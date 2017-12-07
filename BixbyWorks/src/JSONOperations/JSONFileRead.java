package JSONOperations;

import java.io.FileReader;

import excelOperations.*;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFileRead
{
	static JSONParser parser = new JSONParser();
	static JSONObject wholeObject=null;
	static Object obj=null;
	static JSONArray arrPathDB =null;
	
	static SingleJSONObject mainWholeObj= new SingleJSONObject();
	
	public static void main(String[] args)
	{
		

		try
		{

			obj = parser.parse(new FileReader("C:\\Users\\PIKS-PC\\Desktop\\Files\\file1.txt"));

			wholeObject = (JSONObject) obj;
			
			arrPathDB=  (JSONArray) wholeObject.get("PathDB");

			String varruleSetName= (String) wholeObject.get("RuleSet_Name");
			String varRuleSet_SubmitNumber= (String) wholeObject.get("RuleSet_SubmitNumber");
			
			mainWholeObj.setRuleSetName(varruleSetName);
			mainWholeObj.setRuleSetSubmitNum(varRuleSet_SubmitNumber);
			//String name = (String) jsonObject.get("resultCode");
			//JSONObject subObject = (JSONObject) jsonObject.get("agentResponses");
			//String commandName = (String) subObject.get("commandName");
			

			//System.out.println("Name: " + name);
			//System.out.println("commandName: " + commandName);
			//System.out.println("\nCompany List:");
			
			Iterator<String> iterator = arrPathDB.iterator();
			
			while (iterator.hasNext())
			{
				//Single Path DB Strings...
				Object o = (Object) iterator.next();
				JSONObject varsinglePathDB= (JSONObject)o;
				String varpathRuleType = (String) varsinglePathDB.get("pathRuleType");
				String varpathRuleId = (String) varsinglePathDB.get("pathRuleId");
				String varcreateTime = (String) varsinglePathDB.get("createTime");
				String vardescription = (String) varsinglePathDB.get("description");
				String varintent = (String) varsinglePathDB.get("intent");
				String varexecutionType = (String) varsinglePathDB.get("executionType");
				
				//Extracting it's States...
				JSONArray arrStates = (JSONArray) varsinglePathDB.get("states");
					
					SinglePathDB objSinglePathDB = new SinglePathDB();
						objSinglePathDB.setPathRuleType(varpathRuleType);
						objSinglePathDB.setPathRuleID(varpathRuleId);
						objSinglePathDB.setDescription(vardescription);
						objSinglePathDB.setIntent(varintent);
						objSinglePathDB.setExecutionType(varexecutionType);
						objSinglePathDB.setS(extractStates(varsinglePathDB));
						
						
					/*	System.out.println("varpathRuleType = "+varpathRuleType);
						System.out.println("varpathRuleId = "+varpathRuleId);
						System.out.println("varcreateTime = "+varcreateTime);
						System.out.println("vardescription = "+vardescription);
						System.out.println("varintent = "+varintent);
						System.out.println("varexecutionType = "+varexecutionType);
						System.out.println("States: "+arrStates);
						System.out.println("States size: "+objSinglePathDB.s.size());*/
						
						mainWholeObj.setPathDB(objSinglePathDB);
						
				//System.out.println("-----------------------------------\n");
			}
			
			//System.out.println("PathDB: "+arrPathDB);
			System.out.println("PathDB Arr length: "+arrPathDB.size());
			
			System.out.println("No. of objSinglePathDB= "+mainWholeObj.pathDB.size());
			
			WriteExcel.writeObejctToExcel(mainWholeObj);
			
			//printDetails(mainWholeObj);		
			
			

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	public static State[] extractStates(JSONObject p)
	{
		JSONArray arrStates = (JSONArray) p.get("states");
		
		State[] arrState= new State[arrStates.size()];
		int i=0;
		
		Iterator itr = arrStates.iterator();
		
		while(itr.hasNext())
		{
			//Single State Strings...
			Object o = (Object) itr.next();
			JSONObject varSingleState= (JSONObject)o;
			
			String varappName = (String) varSingleState.get("appName");
			String varstateId = (String) varSingleState.get("stateId");
			String varstateDescription = (String) varSingleState.get("stateDescription");
			String varsubIntent = (String) varSingleState.get("subIntent");
			boolean varisNestingState = (boolean) varSingleState.get("isNestingState");
			boolean varisScreenlessState = (boolean) varSingleState.get("isScreenlessState");
			boolean varisLandingState = (boolean) varSingleState.get("isLandingState");
			long varseqNum = (Long) varSingleState.get("seqNum");
			boolean varspot_state = (boolean) varSingleState.get("spot_state");
			
			State s = new State();
			s.setAppName(varappName);
			s.setStateID(varstateId);
			s.setStateDesc(varstateDescription);
			s.setSubIntent(varsubIntent);
			s.setNesting(varisNestingState);
			s.setScreenlessState(varisScreenlessState);
			s.setLandingState(varisLandingState);
			s.setSeqNum(Long.valueOf(varseqNum));
			s.setSpot_State(varspot_state);
			
			JSONArray arrParameters = (JSONArray) p.get("parameters");
			
			if(arrParameters!=null)
			s.setP(extractParams(varSingleState));
			
			
			arrState[i++]=s;
			
		}
		
		return arrState;
	}
	
	
	public static Parameters[] extractParams(JSONObject p)
	{
		JSONArray arrParameters = (JSONArray) p.get("parameters");
		
		System.out.println("TEST: "+arrParameters);
		if(arrParameters!=null)
		{
			Parameters[] arrParam= new Parameters[arrParameters.size()];
			int i=0;
			
			Iterator itr = arrParameters.iterator();
			
			while(itr.hasNext())
			{
				//Single State Strings...
				Object o = (Object) itr.next();
				JSONObject varSingleParam= (JSONObject)o;
				
				String varslotType = (String) varSingleParam.get("slotType");
				String varslotValueType = (String) varSingleParam.get("slotValueType");
				String varslotName = (String) varSingleParam.get("slotName");
				String varparameterName = (String) varSingleParam.get("parameterName");
				String varparameterType = (String) varSingleParam.get("parameterType");
				boolean varisMandatory = (boolean) varSingleParam.get("isMandatory");
				boolean varisNLUParameter = (boolean) varSingleParam.get("isNLUParameter");
				
				
				Parameters s = new Parameters();
				s.setSlotType(varslotType);
				s.setSlotValueType(varslotValueType);
				s.setSlotName(varslotName);
				s.setParamName(varparameterType);
				s.setParamType(varparameterType);
				s.setMandatory(varisMandatory);
				s.setNLUParam(varisNLUParameter);
				
				arrParam[i++]=s;
				
				
			}
			return arrParam;
		}
		
		return null;
		
	}
	
	
	
	public static void printDetails(SingleJSONObject p)
	{
		Iterator ipathDB= p.pathDB.iterator();
    	
    	while(ipathDB.hasNext())
    	{
    		SinglePathDB onePathDBObj = (SinglePathDB) ipathDB.next();
    		
    		System.out.println("Pathrule ID: "+onePathDBObj.getPathRuleID());
    		/*System.out.println("--"+onePathDBObj.getPathRuleType());
    		//sampleUtt
    		System.out.println("--"+onePathDBObj.getIntent());
    		System.out.println("--"+onePathDBObj.getDescription());
    		System.out.println("--"+String.valueOf(onePathDBObj.getSeqNum()));
    		System.out.println("--"+onePathDBObj.getPathRuleID());*/
    		
    		Iterator iState= onePathDBObj.s.iterator();
    		
    		System.out.println("No.of States: "+onePathDBObj.s.size());
    		
    		while(iState.hasNext())
    		{
    			State oneState = (State) iState.next();
    			
    			System.out.println("St-- "+oneState);
    			
    			if(oneState!=null)
    			{
    				System.out.println("State ID: "+oneState.getStateID());
        			/*System.out.println("--"+oneState.getStateDesc());
        			System.out.println("--"+oneState.getSubIntent());
        			System.out.println("--"+String.valueOf(oneState.isNesting()));
        			System.out.println("--"+String.valueOf(oneState.isScreenlessState()));
        			System.out.println("--"+String.valueOf(oneState.isLandingState()));
        			*/
        			
    			}
    			
    			
    			System.out.println("------------");
    		}
    		
     	}
    	
	}

}
