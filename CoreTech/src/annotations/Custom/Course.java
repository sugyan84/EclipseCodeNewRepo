package annotations.Custom;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Course
{
	String cid() default "C-111";

	String cname() default "Java Programming";

	int ccost() default 10000;
}
