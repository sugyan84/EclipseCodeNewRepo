package JSONOperations;

import java.util.ArrayList;

public class State
{
	String appName;
	String stateID;
	String stateDesc;
	String subIntent;
	boolean isNesting;
	boolean isScreenlessState;
	boolean isLandingState;
	long seqNum;
	boolean spot_State;
	
	ArrayList<Parameters> p = new ArrayList<Parameters>();
	
	
	
	//------------------------------------

	public String getAppName()
	{
		return appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	public String getStateID()
	{
		return stateID;
	}

	public void setStateID(String stateID)
	{
		this.stateID = stateID;
	}

	public String getStateDesc()
	{
		return stateDesc;
	}

	public void setStateDesc(String stateDesc)
	{
		this.stateDesc = stateDesc;
	}

	public String getSubIntent()
	{
		return subIntent;
	}

	public void setSubIntent(String subIntent)
	{
		this.subIntent = subIntent;
	}

	public long getSeqNum()
	{
		return seqNum;
	}

	public void setSeqNum(int seqNum)
	{
		this.seqNum = seqNum;
	}

	

	public ArrayList<Parameters> getP()
	{
		return p;
	}

	public void setP(Parameters[] p)
	{
		for(Parameters i: p)
		{
			this.p.add(i);
		}
	}

	public boolean isNesting()
	{
		return isNesting;
	}

	public void setNesting(boolean isNesting)
	{
		this.isNesting = isNesting;
	}

	public boolean isScreenlessState()
	{
		return isScreenlessState;
	}

	public void setScreenlessState(boolean isScreenlessState)
	{
		this.isScreenlessState = isScreenlessState;
	}

	public boolean isLandingState()
	{
		return isLandingState;
	}

	public void setLandingState(boolean isLandingState)
	{
		this.isLandingState = isLandingState;
	}

	public void setSeqNum(long seqNum)
	{
		this.seqNum = seqNum;
	}

	public void setSpot_State(boolean spot_State)
	{
		this.spot_State = spot_State;
	}

	public boolean isSpot_State()
	{
		return spot_State;
	}
}
