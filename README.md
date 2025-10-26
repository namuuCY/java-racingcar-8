# java-racingcar-precourse

- Application Service : use case 기반 서비스 - 비즈니스 로직 없음
- Domain Service : 비즈니스 로직 존재, Stateless

# TODO List

- [x] 프로젝트 세팅 및 README.md 정리
- [x] 각종 컨벤션 및 요구사항 정리
- [x] 기본 테스트 요구사항 및 `camp.nextstep.edu.missionutils.Randoms` 확인해보기
- [ ] 도메인 기능 구현
    - [x] VO 구현
        - [x] CarName
            - [x] CarNameTest 작성
            - [x] CarName 구현
        - [x] Coordinate
            - [x] CoordinateTest 작성
            - [x] Coordinate 구현
    - [x] Entity 구현
        - [x] Car
            - [x] CarTest 작성
            - [x] Car 구현
    - [ ] 도메인 서비스 구현
        - [ ] MoveStrategy
            - [x] MoveStrategy 인터페이스 작성
            - [ ] RandomMoveStrategy
                - [ ] RandomMoveStrategyTest 작성
                - [ ] RandomMoveStrategy 구현

---

screenshot

---

## 프로그래밍 요구 사항 1

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다 - 기본적으로 **Java Style Guide**를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://docs.junit.org/current/user-guide/)
        - [AssertJ User Guide](https://assertj.github.io/doc/)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## 라이브러리

- [ ] `camp.nextstep.edu.missionutils` 에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```java
Randoms.pickNumberInRange(0,9);
```

## 과제 진행 요구 사항

- [x] 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- [x] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.

기능 요구 사항
---

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# **커밋 메시지 형식**

[커밋 컨벤션 출처](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#allowed-type)

기본적인 형식은 다음과 같습니다.

```
<type>(<scope>): <subject>

<body>

<footer>
```

* 모든 줄은 100자를 넘지 않아야 합니다.

### **1. Subject (제목)**

제목 줄은 `<type>(<scope>): <subject>` 형식입니다.

* **`<type>`**: 커밋의 유형을 나타냅니다.
    * `feat`: 새로운 기능
    * `fix`: 버그 수정
    * `docs`: 문서
    * `style`: 코드 스타일 (포맷팅, 세미콜론 등)
    * `refactor`: 코드 리팩토링
    * `test`: 테스트 추가
    * `chore`: 유지보수 (빌드 스크립트 수정 등)
* **`<scope>`** (선택 사항): 커밋이 변경한 부분의 범위를 나타냅니다. (예: `$location`, `$browser`, `ngHref` 등)
* **`<subject>`**: 변경 사항에 대한 간결한 설명입니다.
    * **명령형, 현재 시제**를 사용합니다. (예: "change" - "changed"나 "changes" X)
    * 첫 글자를 대문자로 쓰지 않습니다.
    * 끝에 마침표(.)를 찍지 않습니다.

### **2. Body (본문)**

* 제목(Subject)과 한 줄을 비워(BLANK LINE) 분리합니다.
* **왜** 이 변경 사항이 필요한지, 그리고 **이전 동작과 어떻게 다른지** 설명합니다.
* 제목과 마찬가지로 명령형, 현재 시제를 사용합니다.

### **3. Footer (꼬리말)**

* 본문(Body)과 한 줄을 비워(BLANK LINE) 분리합니다.
* **Breaking Changes (주요 변경 사항)**: 하위 호환성을 깨뜨리는 변경 사항이 있다면 `BREAKING CHANGE:` 키워드로 시작하여 설명, 정당성, 마이그레이션 노트를 포함해야 합니다.
* **Referencing Issues (이슈 참조)**: 닫힌 이슈가 있다면 `Closes #123` 또는 `Closes #123, #245`와 같이 별도의 줄에 기재합니다.