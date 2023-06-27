# jwt_jpa

이번에는 Member 테이블을 만들어서 회원 관련된 작업을 해보려 합니다. 회원의 로그인 관리를 위해 JWT를 사용할 것이고, DB 연동은 MyBatis가 아니라 JPA로 해볼 것입니다.
- [JPA 설정 참고](https://dev-coco.tistory.com/85)
- [인텔리제이 Gradle](https://www.jetbrains.com/help/idea/gradle.html)
- [김영한님 JPA 예제](https://github.com/holyeye/jpabook)

작업 환경은 다음과 같습니다.
- Tool: <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/d57a8f5c-e70f-4c61-b5e4-afd47501864e" width="25px" height="25px"> IntelliJ Ultimate / <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/1b1d14d1-25fa-453f-95f4-4be7c6e2b1fd" width="25px" height="25px"> MySQL Workbench
- Version: <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/09ce7b6b-bdac-4046-984c-02caf8a1547c" width="25px" height="25px"> JDK 11 / <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/e8234082-8874-4def-8741-e72ab4316258" width="25px" height="25px"> <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/7e040771-cb4e-41c4-b1fe-90efa4719c8c" width="25px" height="25px"> Spring Boot 2.7.12 (Gradle) / <img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/a9f29ed4-4ee9-4a6e-b2ea-46d90cab6b49" width="25px" height="25px"> MySQL 8.0.32

---

JWT를 적용시키기 전에, JPA 연동과 테스트코드 작성을 먼저 했습니다. (2023.06.27)

<img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/36ad53f5-f2a7-44c7-8072-6d9e67b5b3db" width="800px">

- Gradle 적용 : 지난 board 토이프로젝트에서는 Maven으로 빌드했었는데, 이번에는 Gradle로 했습니다. Maven은 익숙해서 편했습니다. pom.xml로 라이브러리를 가져오고, [mvnrepository 사이트](https://mvnrepository.com/)에서 필요한 라이브러리들을 가져오는 것도 괜찮았습니다. 그러다 Gradle의 빌드 성능이 좋다는 말을 듣고 처음 적용시켰습니다. 실제 Gradle과 Maven의 성능 차이를 보겠습니다.
<img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/85466ed8-6dd4-4cff-a98c-867a8f7b8d8b" width="500px">
<img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/98b7f728-7d04-413a-9f53-7854a2fed183" width="500px">
<img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/76d5765a-4566-49ed-a1d3-5ffcf88d1b84" width="500px">
<img src="https://github.com/thdqudgnsToy/jwt_jpa/assets/92148521/640da5f1-3940-40b4-a6f0-c27134daf51c" width="500px">

(출처 : [coco3o](https://dev-coco.tistory.com/65))

성능이 좋을 뿐더러 가독성도 좋습니다.
