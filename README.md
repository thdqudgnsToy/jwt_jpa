# jwt_jpa

이번에는 Member 테이블을 만들어서 회원 관련된 작업을 해보려 합니다. 회원의 로그인 관리를 위해 JWT를 사용할 것이고, DB 연동은 MyBatis가 아니라 JPA로 해볼 것입니다.
- [JPA 설정 참고](https://dev-coco.tistory.com/85)
- [인텔리제이 Gradle](https://www.jetbrains.com/help/idea/gradle.html)
- [김영한님 JPA 예제](https://github.com/holyeye/jpabook)

작업 환경은 다음과 같습니다.
- Tool: <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/d57a8f5c-e70f-4c61-b5e4-afd47501864e" width="25px" height="25px"> IntelliJ Ultimate / <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/1b1d14d1-25fa-453f-95f4-4be7c6e2b1fd" width="25px" height="25px"> MySQL Workbench
- Version: <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/09ce7b6b-bdac-4046-984c-02caf8a1547c" width="25px" height="25px"> JDK 11 / <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/e8234082-8874-4def-8741-e72ab4316258" width="25px" height="25px"> <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/7e040771-cb4e-41c4-b1fe-90efa4719c8c" width="25px" height="25px"> Spring Boot 2.7.12 (Gradle) / <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/a9f29ed4-4ee9-4a6e-b2ea-46d90cab6b49" width="25px" height="25px"> MySQL 8.0.32
