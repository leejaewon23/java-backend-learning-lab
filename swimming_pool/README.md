# 수영장 관리 프로젝트

## MySQL DB 쿼리
```
CREATE DATABASE swim_db DEFAULT CHARACTER SET utf8mb4;
CREATE USER 'swim_user'@'localhost' IDENTIFIED BY 'qwer1234!';
GRANT ALL PRIVILEGES ON swim_db.* TO 'swim_user'@'localhost';
FLUSH PRIVILEGES;
```

## 실행
```bash
./gradlew bootRun
```

기본 포트는 `8089` 입니다.

## Postman 테스트 순서

### 1. 수영장 등록
`POST http://localhost:8089/api/v1/swim-pools`

```json
{
  "id": 23,
  "name": "은평구립수영장",
  "tel": "02-1111-2222",
  "addr1": "서울시 은평구 은평로1",
  "addr2": "32-22",
  "lanes": "50M * 4, 100 * 2",
  "size": "350m2"
}
```

### 2. 강사 등록
`POST http://localhost:8089/api/v1/teachers`

```json
{
  "id": 89,
  "name": "박태환",
  "main": "자유형",
  "birthYear": 1990,
  "swimPoolId": 23
}
```

### 3. 조회
```http
GET http://localhost:8089/api/v1/swim-pools
GET http://localhost:8089/api/v1/swim-pools/23
GET http://localhost:8089/api/v1/teachers
GET http://localhost:8089/api/v1/teachers/89
```

### 4. 수정
`PATCH http://localhost:8089/api/v1/swim-pools/23`

```json
{
  "tel": "02-3333-4444"
}
```

`PATCH http://localhost:8089/api/v1/teachers/89`

```json
{
  "main": "접영"
}
```

### 5. 삭제
```http
DELETE http://localhost:8089/api/v1/teachers/89
DELETE http://localhost:8089/api/v1/swim-pools/23
```
