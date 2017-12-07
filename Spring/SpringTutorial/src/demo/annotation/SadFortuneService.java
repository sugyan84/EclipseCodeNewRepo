package demo.annotation;

import demo.annotation.FortuneService;

public class SadFortuneService implements FortuneService
{

	@Override
	public String getFortune()
	{
		return "Sad Fortune Service";
	}

}
