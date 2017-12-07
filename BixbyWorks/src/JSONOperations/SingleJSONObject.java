package JSONOperations;

import java.util.ArrayList;

public class SingleJSONObject
{
	String ruleSetName;
	String ruleSetSubmitNum;
	
	public ArrayList<SinglePathDB> pathDB= new ArrayList<SinglePathDB>();
	
	
	
	public String getRuleSetName()
	{
		return ruleSetName;
	}
	public void setRuleSetName(String ruleSetName)
	{
		this.ruleSetName = ruleSetName;
	}
	public String getRuleSetSubmitNum()
	{
		return ruleSetSubmitNum;
	}
	public void setRuleSetSubmitNum(String ruleSetSubmitNum)
	{
		this.ruleSetSubmitNum = ruleSetSubmitNum;
	}
	public ArrayList<SinglePathDB> getPathDB()
	{
		return pathDB;
	}
	public void setPathDB(SinglePathDB pathDB)
	{
		this.pathDB.add(pathDB);
	}
	
	
}
