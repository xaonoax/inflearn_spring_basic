package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(  // @Component가 붙은 클래스를 찾아 자동으로 스프링 빈으로 등록해준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)  // @ComponentScan이 스캔하는 과정에서 특정 클래스나 어노테이션을 제외하도록 필터링한다.
)
public class AutoAppConfig {

}
