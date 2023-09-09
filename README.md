# Simple TODO (Spring Boot Kotlin Security)

Simple TODO는 Spring Boot와 Kotlin을 사용하여 구현된 간단한 할 일 관리 웹 애플리케이션입니다. 

이 프로젝트는 Spring Security를 통해 사용자 인증과 권한 관리를 구현하였습니다.

## 프로젝트 설치 및 실행

1. Git 저장소를 클론합니다.

    ```bash
    git clone https://github.com/cmsong111/Simple_todo.git
    ```
2. 프로젝트 루트 디렉토리로 이동합니다.
    ```bash
    cd Simple_todo
    ```
3. 프로젝트를 빌드합니다.
    ```bash
    ./gradlew build
    ```
4. 빌드가 완료되면 Spring Boot 애플리케이션을 실행합니다.



애플리케이션은 기본적으로 8080 포트에서 실행됩니다. 웹 브라우저에서 `http://localhost:8080`로 접속하여 애플리케이션을 사용할 수 있습니다.

## 주요 기능

- 할 일 목록 조회
- 할 일 추가, 수정, 삭제
- 사용자 등록 및 로그인

## 기술 스택

- Spring Boot
- Kotlin
- Spring Security
- Thymeleaf
- 데이터베이스 (H2)

## 프로젝트 구조

- `src/main/kotlin/com/namju/simpletodo` : Kotlin 코드 및 패키지
- `src/main/resources` : 리소스 파일 및 템플릿
- `build.gradle.kts` : 프로젝트 의존성 및 설정 파일
- ...

## 기여

1. 이 저장소를 포크합니다.
2. 새로운 기능 또는 버그 수정을 위한 브랜치를 생성합니다.
3. 변경 사항을 커밋하고 푸시합니다.
4. Pull Request를 생성합니다.

## 라이선스

이 프로젝트는 MIT 라이선스 하에 라이선스가 부여됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하세요.
