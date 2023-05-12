## 배열(Array)

---
### ❓ 배열이란?
- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
- ex) 학생 5명의 점수를 저장하기 위해 배열을 사용한다면
```agsl
int[] score = new int[5]; // 5개의 int 값을 저장할 수 있는 배열 생성
```
### ❓ 배열 선언
```agsl
타입[] 변수이름;
타입 변수이름[];
```
- 배열을 선언한 다음에는 배열을 생성해야 함
- 배열얼 선언하는 것은 단지 생성된 배열을 다루기 위한 참조변수를 위한 공간이 만들어지는 것
### ❓ 배열 생성
- 배열을 생성해야만 비로소 데이터를 저장할 수 있는 공간이 만들어지는 것
```agsl
int[] score; // 배열을 선언한다.(생성된 배열에 다루는데 사용될 참조변수 선언)
score = new int[5]; //배열을 생성한다.(5개의 int값을 저장할 수 있는 공간 생성)
```
- 배열도 객체이기 때문에 멤버변수와 메서드를 갖고 있으며, 멤버변수 length는 배열의 크기에 대한 정보를 담고 있음
- 배열은 한번 생성되면 크기를 변경할 수 없기 때문에 배열의 length는 변하지 않음
- 타입에 따른 변수의 기본값

|   자료형   |     기본값     |
|:-------:|:-----------:|
| boolean |    false    |
|  char   |  '\u0000'   |
|  byte   |      0      |
|  short  |      0      |
|   int   |      0      |
|  long   |     0L      |
|  float  |    0.0f     |
| double  | 0.0d 또는 0.0 |
| 참조형 변수  |    null     |

### ❓ 배열 초기화
- 배열은 생성과 동시에 자동적으로 자신의 타입에 해당하는 기본값으로 초기화됨
- 즉, 배열을 사용하기 전에 초기화를 해주지 않아도 되지만, 원하는 값으로 초기화
```agsl
int[] score = new int[3]; // 크기가 5인 int형 배열을 생성
score[0] = 100; // 각 요소에 직접 값을 저장
score[1] = 90;
score[2] = 80;
```
- 이처럼 배열의 각 요소를 하나씩 초기화하는 것은 불편
- 간편한 초기화 방법들을 제공
```agsl
int[] score = {100, 90, 80}; // 1번
int[] score = new int[]{100, 90, 80}; // 2번 : 선언과 초기화를 따로 해야하는 경우
```
### ❓ 배열 활용
- 배열의 각 저장공간에 값을 저장하고 또는 저장된 값을 읽어오기 위해서는 배열 참조변수와 인덱스 이용
- 배열의 인덱스?
  - 배열의 각 저장공간에 자동적으로 주어지는 일련번호
- for 문을 활용하는 경우에는 배열의 속성인 length를 사용하는 것이 더 견고한 코드를 만듦
  - 만약 배열의 크기가 변경되었을 때 조건의 범위도 변경해주어야 하는데, 잊고 실행한다면 for문은 배열의 유효한 인덱스 범위를 넘어섬
    - ArrayIndexOutOfBoundsException : 배열의 index가 배열의 범위를 벗어났다는 에러
  - length는 배열의 크기가 변경됨에 따라 자동적으로 변경된 배열의 크기를 갖기 때문에 for문의 조건식을 일일히 변경해주지 않아도 됨

### ❓ 다차원 배열
- 자바에서는 1차원 배열뿐만 아니라 2차우너 이상의 다차원 배열도 허용
- but, 특별한 경우를 제외하고는 2차원 이상의 배열은 잘 사용하지 않음
- 2차원 배열 선언 방법
```agsl
타입[][] 변수이름;
타입 변수이름[][];
타입[] 변수이름[];
```
- 2차원 배열 생성
```agsl
int[][] score = new int[5][3]; // 5행 3열의 2차원 배열 생성
```
- 2차원 배열 생성과 초기화
```agsl
int[][] score = new int[][]{  // new int[][]는 생략 가능
                    [100, 100, 100], 
                    [20, 20, 20], 
                    [30, 30, 30]
}
```
### ❓ 가변 배열
- 자바에서는 2차원 이상의 배열에 대해서 '배열의 배열'의 형태로 처리
- 2차원 이상의 다차원 배열을 생성할 때 전체 배열 차수 중 마지막 차수의 크기를 지정하지 않고, 추후에 각기 다른 크기의 배열을 생성함으로써 고정된 형태가 아닌 유동적인 가변 배열 구성
```agsl
int[][] score = new int[5][3]; // 5행 3열의 2차원 배열 생성
// 위 코드를 다음과 같이 표현
int[][] score = new int[5][];
score[0] = new int[3];
score[1] = new int[3];
score[2] = new int[3];
score[3] = new int[3];
score[4] = new int[3];
```
### ❓ 배열의 복사
- 배열은 한번 생성하면 크기를 변경할 수 없기 때문에 더 많은 저장공간이 필요하다면 보다 큰 배열을 새로 만들고 이전 배열로부터 내용을 복사해야함
- 배열 간의 내용을 복사하려면 for문을 사용하거나 System 클래스의 arraycopy()를 사용
```
System.arraycopy(arr1, 9, arr2, 9, arr1.length())
// arr1[0]에서 arr2[0]으로 arr1.length개의 데이터를 복사
```

### ❗ 회독
|  1회독  | 2회독  | 3회독  | 4회독  |  5회독  |
|:-----:|:----:|:----:|:----:|:-----:|
|   ⭕   |