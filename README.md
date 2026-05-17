# javaproject

국비교육 과정에서 Java 기초부터 Spring Boot 기반 CRUD 실습까지 진행하며 작성한 학습용 프로젝트 모음입니다.

각 폴더는 독립적인 실습 단위로 구성되어 있으며, 일부는 Gradle 또는 Maven 프로젝트이고 일부는 IntelliJ에서 바로 실행한 단일 Java 예제입니다.

## 저장소 성격

- Java 문법, 객체지향, 예외 처리, 제네릭, 컬렉션, 람다, 스트림, 네트워크 프로그래밍 실습
- Gradle/Maven 빌드 도구 사용 연습
- JUnit, AssertJ, Gson 등 외부 라이브러리 사용 실습
- Spring Boot, JPA, MyBatis, REST API, 파일 업로드, DB 연동 실습
- MySQL, MariaDB, PostgreSQL Docker Compose 환경 구성 연습

이 저장소는 완성된 하나의 애플리케이션이 아니라, 교육 과정에서 단계별로 작성한 예제와 미니 프로젝트를 모아 둔 기록용 저장소입니다.

## 기술 스택

- Language: Java
- Build: Gradle, Maven
- Test: JUnit 4, JUnit 5, AssertJ
- Library: Gson, Lombok
- Backend: Spring Boot, Spring WebMVC, Spring Data JPA, MyBatis
- Database: MySQL, MariaDB, PostgreSQL
- Template: Mustache
- Tooling: IntelliJ IDEA, Docker Compose

## 주요 폴더 구성

| 폴더 | 내용 |
| --- | --- |
| `firstjava` | Java 실행 환경 확인, 첫 Java 프로그램, 구구단 등 입문 예제 |
| `chapter02` | 변수, 기본 타입, 문자열, 타입 변환, 형 변환 실습 |
| `chapter03` | 연산자와 기본 문제 풀이 |
| `chapter04`, `chapter04_practice` | 조건문, 반복문, 흐름 제어 실습 |
| `chapter05` | 배열, 열거형, 참조 타입 기초 |
| `chapter06`, `chapter06_1` | 클래스, 필드, 생성자, 메서드, 정적 멤버, 싱글톤, 은행 계좌 콘솔 예제 |
| `chapter07` | 상속, 다형성, 추상 클래스, 오버라이딩, 타입 변환 |
| `chapter08` | 인터페이스, 구현체 분리, 다중 인터페이스, DAO 패턴 기초 |
| `chapter10`, `chapter10_i` | Gson을 이용한 JSON 직렬화/역직렬화 실습 |
| `chapter11`, `chapter11_1` | 예외 처리, 사용자 정의 예외, 리소스 처리, 계산기/게임기/은행 예제 테스트 |
| `chapter12` | Java 기본 API, 날짜/시간, 포맷팅, 정규식, 리플렉션, 애너테이션 |
| `chapter13` | 제네릭 타입, 제네릭 메서드, 제한된 타입 파라미터, 컨테이너/페어 예제 |
| `Chapter14` | 스레드와 구구단 출력, 합계/평균 계산 등 과제형 실습 |
| `chapter15` | 컬렉션 프레임워크, DTO/DAO, 비교자, properties 리소스 |
| `chapter16` | 람다식, 함수형 인터페이스, 메서드 참조 |
| `Chapter17` | 스트림, 파일 읽기 리소스 실습 |
| `Chapter18` | 입출력 관련 기본 예제 |
| `Chapter19`, `NetworkTest` | TCP 소켓, 서버/클라이언트, 1:1 채팅, 멀티 클라이언트 채팅 실습 |
| `Chapter_20` | Spring Boot + MyBatis 기반 게임/사용자 CRUD 실습 |
| `PetApp` | Spring Boot + JPA + Mustache 기반 반려동물 CRUD 실습 |
| `cafe_kiosk`, `cafe_kiosk_sales` | Spring Boot + JPA 기반 카페 키오스크 CRUD 실습 |
| `cookies` | Spring Boot + JPA 기반 쿠키/재료/레시피/조리/파일 업로드 CRUD 실습 |
| `swimming_pool` | Spring Boot + JPA + Flyway 기반 수영장/강사 관리 API 실습 |
| `maven_lib`, `use_mvn_lib` | Maven 라이브러리 생성 및 사용 실습 |
| `use_gradle`, `use_gradle_lib` | Gradle 라이브러리 생성 및 사용 실습 |
| `docker` | MySQL, MariaDB, PostgreSQL Docker Compose 예제 |

## Spring Boot 실습 요약

### `Chapter_20`

- Spring Boot WebMVC + MyBatis 실습 프로젝트
- 게임 데이터 CRUD API
- 사용자 데이터 CRUD API
- MyBatis mapper XML 사용
- 정적 HTML, CSS, JavaScript 파일 포함

주요 패키지:

- `gamecrud`: `GameDto`, `GameService`, `GameRestController`, `GameMybatis`
- `userscrud`: `UserDto`, `UserService`, `UsersRestController`, `UserMybatis`

### `PetApp`

- Spring Boot + JPA + Mustache 실습 프로젝트
- 반려동물 등록, 수정, 삭제, 단건 조회, 검색 API
- Mustache 템플릿 화면 포함

주요 패키지:

- `pet.cntr`: REST 컨트롤러와 화면 컨트롤러
- `pet.dto`: Entity, DTO, 인터페이스
- `pet.svc`: Service, Repository

### `cafe_kiosk`, `cafe_kiosk_sales`

- Spring Boot + JPA 기반 카페 키오스크 CRUD 실습
- 카테고리, 상품, 판매 도메인 실습
- REST API, Entity, DTO, Repository, Service 계층 분리

`cafe_kiosk`는 카테고리/상품 중심이고, `cafe_kiosk_sales`는 판매 도메인까지 확장한 실습입니다.

### `cookies`

- Spring Boot + JPA 기반 쿠키 레시피 관리 실습
- 카테고리, 쿠키, 재료, 레시피, 조리, 첨부파일 도메인 구성
- `@EntityGraph`를 활용한 연관 데이터 조회 실습
- 파일 업로드 API 포함
- Postman 컬렉션과 화면 설계 문서 포함

### `swimming_pool`

- Spring Boot + JPA + Flyway 기반 수영장 관리 API 실습
- 수영장과 강사 도메인 CRUD
- 프로필별 설정 파일 분리: `local`, `dev`, `prod`
- Flyway 마이그레이션 SQL 포함
- 공통 응답 DTO와 전역 예외 처리 구성

## 실행 방법

각 프로젝트는 독립적으로 실행합니다. 실행하려는 하위 폴더로 이동한 뒤 해당 빌드 도구를 사용합니다.

### Gradle 프로젝트

```bash
cd chapter13
./gradlew test
./gradlew classes
```

대부분의 챕터형 Gradle 프로젝트는 `java` 플러그인 중심이라 `run` 태스크가 없을 수 있습니다. 이 경우 IntelliJ IDEA에서 `main` 메서드가 있는 클래스를 직접 실행합니다.

Spring Boot Gradle 프로젝트는 다음처럼 실행합니다.

```bash
cd cookies
./gradlew bootRun
```

### Maven 프로젝트

```bash
cd chapter11_1
./mvnw test
```

Spring Boot Maven 프로젝트는 다음처럼 실행합니다.

```bash
cd PetApp
./mvnw spring-boot:run
```

### Docker DB 실행

DB 실습용 Docker Compose 파일은 `docker` 폴더에 있습니다.

```bash
cd docker/mysql
docker compose up -d
```

MariaDB와 PostgreSQL도 각각 `docker/mariadb`, `docker/postgresql` 폴더에서 실행할 수 있습니다.

## 공개 저장소 업로드 전 점검

현재 저장소에는 교육 중 생성된 파일이 함께 남아 있습니다. GitHub Public 저장소로 올리기 전 아래 항목을 확인하는 것이 좋습니다.

- `.idea`, `out`, `build`, `target`, `bin`, `.gradle` 같은 IDE/빌드 산출물은 커밋 대상에서 제외
- `application.yaml`, `application.yml`, `docker-compose.yml`에 적힌 DB 계정과 비밀번호는 실제 운영 비밀번호가 아니더라도 공개 전 샘플값 또는 환경변수 방식으로 변경
- `application-dev.yml`처럼 평문 비밀번호가 있는 설정 파일은 `application-example.yml` 형태로 분리하는 것을 권장
- 로컬 IP, 개인 DB명, 개인 포트가 들어간 예제는 README에 실습용 값임을 명시
- 대용량 산출물과 자동 생성 리포트는 `.gitignore`에 추가

예시:

```yaml
spring:
  datasource:
    url: jdbc:mysql://${DB_HOST:localhost}:3306/${DB_NAME}
    username: ${DB_USER}
    password: ${DB_PASSWORD}
```

## 학습 흐름

1. `firstjava` ~ `chapter05`: Java 기본 문법과 제어문
2. `chapter06` ~ `chapter08`: 객체지향, 상속, 인터페이스
3. `chapter10` ~ `chapter12`: 라이브러리, 예외 처리, Java 기본 API
4. `chapter13` ~ `Chapter17`: 제네릭, 스레드, 컬렉션, 람다, 스트림
5. `Chapter19`, `NetworkTest`: 네트워크와 소켓 통신
6. `Chapter_20`, `PetApp`, `cafe_kiosk`, `cafe_kiosk_sales`, `cookies`, `swimming_pool`: Spring Boot 기반 웹/API 프로젝트

## 참고

- 폴더명이 `Chapter14`, `Chapter17`처럼 대문자로 시작하는 것과 `chapter13`처럼 소문자로 시작하는 것이 섞여 있습니다.
- `chapter04_practice`는 기존 `chapte04` 폴더명을 공개 저장소에서 알아보기 쉽도록 정리한 폴더입니다.
- 일부 프로젝트는 IntelliJ 설정 파일 또는 빌드 산출물이 포함되어 있을 수 있습니다.
- 여러 하위 프로젝트가 같은 포트나 같은 로컬 DB를 사용할 수 있으므로 동시에 실행할 때는 설정 파일을 확인해야 합니다.
