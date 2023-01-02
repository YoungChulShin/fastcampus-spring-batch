package study.spring.batch.springbatchexample.part1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class HelloConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public HelloConfiguration(JobBuilderFactory jobBuilderFactory,
                              StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job helloJob() {
        return jobBuilderFactory.get("helloJob")    // job 이름
                .incrementer(new RunIdIncrementer())    // 실행 단위를 구분할 수 있는 incrementer
                                                        // RunIdIncrementer job이 실행할 때 parameter id를 생성
                .start(helloStep())    // job 실행 시 최초로 실행
                .build();
    }

    // step: job의 실행 단위. 1개의 job은 1개 이상의 step을 가질 수 있다
    @Bean
    public Step helloStep() {
        return stepBuilderFactory.get("helloStep")
                .tasklet((contribution, chunkContext) -> {
                   log.info("hello spring batch");
                   return RepeatStatus.FINISHED;
                }).build();
    }
}
