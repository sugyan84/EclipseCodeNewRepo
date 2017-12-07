package demo.JavaBased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.annotation.Coach;
import demo.annotation.FortuneService;
import demo.annotation.SadFortuneService;
import demo.annotation.SwimCoach;

@Configuration
public class SpringConfig
{
	//define bean for FortuneService
	@Bean
	public FortuneService sadFortuneObj()
	{
		return new SadFortuneService();
	}
	
	
	//define bean for swim coach
	@Bean
	public Coach swimCoachObj()
	{
		return new SwimCoach(sadFortuneObj());
	}
}
