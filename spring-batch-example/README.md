# 저장소 설명
스프링배치 기본 예제 실습

# 메모
스프링 배치 활성화
```
@EnableBatchProcessing 애노테이션 사용
```

Job
```
스프링 배치의 작업 단위
```

Step
```
job의 실행 단위
```

Step은 Task와 Chunk로 구분할 수 있다
- Task: 한번에 실행
- Chunk: 나누어서 실행
   - ItemReader, ItemProcessor, ItemWriter

DB Table
- `org.springframework.batch:spring-batch-core`에서 확인 가능하다

Job 실행
- Parameter 값이 들어가는데, 1개의 잡은 동일한 파라미터로 새로 시작될 수 없다. 
- 재실행된다