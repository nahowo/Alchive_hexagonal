[![branches](.github/badges/branches.svg)](https://github.com/nahowo/Alchive_hexagonal/actions/workflows/cicd.yml)
### 지속 가능한 소프트웨어 설계를 위한 육각형 아키텍처

테스트 코드 작성을 위해, 더 나아가서는 소프트웨어의 지속적 성장이 가능하도록 하기 위해 레이어드 아키텍처를 육각형 아키텍처로 리팩토링하는 레포지토리입니다. 레이어드 아키텍처로 작성된 레포지토리는 [여기](https://github.com/Alchive/backend)에 있습니다. 

<img width="904" alt="image111" src="https://github.com/user-attachments/assets/f1aaa178-d4ce-4047-b749-21b39d151572" />

가장 중심에 회색 원, 즉 도메인 계층이 존재합니다. 도메인을 감싸는 파란색 육각형은 애플리케이션 서비스 계층을 의미합니다. 이런 구조를 통해 도메인 계층이 어떤 의존성도 가지지 않고 비즈니스 로직에만 집중할 수 있도록 합니다. 

### 디렉토리 구조

핵심 디렉토리 구조는 아래와 같습니다. 

```
├── adapter
│   ├── in
│   │   └── web
│   │       ├── controller
│   │       └── dto
│   │           ├── request
│   │           └── response
│   └── out
│       └── persistence
│           ├── adapter
│           ├── entity
│           └── repository
├── application
│   ├── command
│   ├── port
│   │   ├── in
│   │   └── out
│   └── service
└── model
```

### 예시 흐름

회원가입 로직을 예시로 하는 흐름은 아래와 같습니다. 


1. UserCreateRequestDTO를 signUpCommand로 변환
2. useCase의 signUp() 메서드 호출 → UserService의 signUp() 구현 메서드 호출
    1. signUpCommand를 Domain으로 전환
    2. 생성된 User 도메인 객체에서 createUser() 메서드 호출(비즈니스 로직 호출)
    3. createUserPort의 createUser() 메서드 호출(생성된 User 도메인 객체 저장) → UserPersistenceAdapter의 createUser() 구현 메서드 호출
        1. 요청받은 User 도메인 객체를 Entity로 변환
        2. UserRepository로 데이터베이스에 엔티티 객체 저장
        3. 저장된 엔티티 객체를 Domain으로 변환해 return
    4. return 받은 도메인을 UserResponseDTO로 변환해 return
3. return 받은 DTO를 ok 코드와 함께 return
