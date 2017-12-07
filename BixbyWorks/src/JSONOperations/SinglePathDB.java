package JSONOperations;

import java.util.ArrayList;
import java.util.Arrays;

public class SinglePathDB
{
	int score;
	String pathRuleType;
	//sampleUtt
	String pathRuleID;
	int seqNum;
	String description;
	String intent;
	String executionType;
	boolean isConditional;
	
	public ArrayList<State> s = new ArrayList<State>();

	
	//---------------------------------
	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public String getPathRuleType()
	{
		return pathRuleType;
	}

	public void setPathRuleType(String pathRuleType)
	{
		this.pathRuleType = pathRuleType;
	}

	public String getPathRuleID()
	{
		return pathRuleID;
	}

	public void setPathRuleID(String pathRuleID)
	{
		this.pathRuleID = pathRuleID;
	}

	public int getSeqNum()
	{
		return seqNum;
	}

	public void setSeqNum(int seqNum)
	{
		this.seqNum = seqNum;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getIntent()
	{
		return intent;
	}

	public void setIntent(String intent)
	{
		this.intent = intent;
	}

	public ArrayList<State> getS()
	{
		return s;
	}

	public void setS(State[] s)
	{
		for(State i:s)
		{
			this.s.add(i);
		}
	}

	public String getExecutionType()
	{
		return executionType;
	}

	public void setExecutionType(String executionType)
	{
		this.executionType = executionType;
	}

	public boolean isConditional()
	{
		return isConditional;
	}

	public void setConditional(boolean isConditional)
	{
		this.isConditional = isConditional;
	}

	public void setS(ArrayList<State> s)
	{
		this.s = s;
	}
}
