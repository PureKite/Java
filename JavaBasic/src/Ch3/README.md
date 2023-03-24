## 연산자(Operator)

---
### ❓ 연산자란?
|         종류         | 우선순위 |
|:------------------:|:----:|
| [단항 연산자](#-단항-연산자) |  높음  |
| [산술 연산자](#-산술-연산자) |      |
| [비교 연산자](#-비교-연산자) |      |
| [논리 연산자](#-논리-연산자) |      |
| [삼항 연산자](#-삼항-연산자) |      |
| [대입 연산자](#-대입-연산자) |  낮음  |

1. 산술 > 비교 > 논리 > 대입, 대입은 제일 마지막에 수행
2. 단항(1) > 이항(2) > 삼항(3), 단항 연산자의 우선순위가 이상 연산자보다 높음
3. 단항 연산자와 대입 연산자를 제외한 모든 연산의 진행방향은 왼쪽에서 오른쪽

### ❓ 단항 연산자
- 증감 연산자
  - 증가 연산자(++) : 피연산자의 값을 1 증가
  - 감소 연산자(--) : 피연산자의 값을 1 감소
  - 전위형 : 값이 참조되기 전에 값 변경
  - 후위형 : 값이 참조된 후에 값 변경
- 부호 연산자
  - +, - : 피연산자의 부호를 변경
  - '+' : 양수 1을 곱한 결과
  - '-' : 음수 1을 곱한 결과
- 비트전환 연산자
  - '~' : 정수형과 char형에만 사용
  - 피연산자를 2진수로 표한했을 때, 0은 1로 1은 0으로 변경
- 논리부정 연산자
  - '!' : boolean형에서만 사용
  - true는 false로, false는 true로

### ❓ 산술 연산자
- 사칙 연산자, 나머지 연산자, 쉬프트 연산자는 모두 두개의 피연산자를 취하는 이항 연산자
  - 모든 이항 연산자는 연산을 수행하기 전에
  - 크기가 4byte이하인 자료형을 int형으로 변환(byte, char, short -> int)
  - 피연산자들의 타입을 서로 일치시킴
- 사칙 연산자
  - '+', '-', '*', '/'
  1. int형(4 byte)보다 크기가 작은 자료형은 int형으로 형변환 후에 연산을 수행
     -  byte + short -> int + int -> int
  2. 두 개의 피연산자 중 자료형의 표현범위가 큰 쪽에 맞춰서 형변환 된 후 연산을 수행
     - int + float -> float + float -> float
  3. 정수형 간의 나눗셈에서 0으로 나누는 것은 금지
- 나머지 연산자
  - '%' : 왼쪽의 피연산자를 오른쪽 피연산자로 나누고 난 나머지 값을 돌려주는 연산자
- 쉬프트 연산자
  - '<<', '>>', '>>>' : 정수형 변수에만 사용할 수 있는데, 피연산자의 각 자리(2진수로 표현했을 때)를 오른쪽 또는 왼쪽으로 이동
  - x << n = x * 2의 n승
  - x >> n = x / 2의 n승

### ❓ 비교 연산자
- 두 개의 변수 또는 리터럴을 비교, 연산 결과는 true 또는 false
- 대소비교 연산자
  - '<', '>', '<=', '>=' : 두 피연산자의 크기를 비교하는 연산자
  - 기본형 중에서는 boolean형을 제외한 나머지 자료형에 다 사용할 수 있지만 참조형에는 사용 X
- 등가비교 연산자
  - '==', '!=' : 두 피연산자에 저장되어 있는 값이 같은지 또는 다른지를 비교하는 연산자
  - 기본형은 물론 참조형, 즉 모든 자료형에 사용할 수 있다.

### ❓ 논리 연산자
- '&&', '||' : 피연산자로 boolean형 또는 boolean형 값을 결과로 하는 조건식만을 허용
- '&&'가 '||'보다 연산순위가 높음

### ❓ 비교 연산자
- 이진 비트연산을 수행
- '&' : 피연산자 양 쪽이 모두 1이어야 1을 결과로 얻음. 그 외는 0
- '|' : 피연산자 중 한 쪽의 값이 1이면, 1을 결과로 얻음. 그 외는 0
- '^' : 피연산자의 값이 서로 다를 때만 1을 결과러 얻음. 같을 때는 0을 얻음.

### ❓ 삼항 연산자
- (조건식) ? 식1 : 식2
  - ex) result = (x > 0) ? x : -x;

### ❓ 대입 연산자
- 변수에 값 또는 수식의 연산결과를 저장
- 대입 연산자의 왼쪽에는 반드시 변수가 위치, 오른쪽에는 리터럴이나 변수 또는 수식
- 변수 앞에 키워드 'final'을 붙이면 상수
- 모든 연산자들 중에서 가장 낮은 연산순위
### ❗ 회독
|  1회독  | 2회독  | 3회독  | 4회독  |  5회독  |
|:-----:|:----:|:----:|:----:|:-----:|
|   ⭕   |