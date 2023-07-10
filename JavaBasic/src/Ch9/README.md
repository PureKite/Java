## java.lang 패키지
- 자바프로그래밍에 가장 기본이 되는 클래스들을 포함
  - java.lang패키지의 클래스들은 import문 없이도 사용 가능
---
### ❓ Object 클래스
- 모든 클래스들의 최고 조상 => 모든 클래스에서 바로 사용 가능
- Object클래스의 메서드
  - protected Object clone() => 객체 자신의 복사본을 반환
  - public boolean equals(Object obj) => 객체 자신과 객체 obj가 같은 객체인지 알려줌(같으면 true)
  - protected void finalize() => 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출, 수행되어야하는 코드가 있는 경우에만 오버라이딩
  - public Class getClass() => 객체 자신의 클래스 정보를 담고 있는 Class인스턴스를 반환
  - public int hashCode() => 객체 자신의 해시코드 반환
  - public string toString() => 객체 자신의 정보를 문자열로 반환
  - public void notify() => 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨움
  - public void notifyAll() => 객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨움
  - public void wait() / wait(long timeout) / wait(long timeout, int nanos) => 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos)동안 기다리게 함(timeout은 천 분의 1초, nanos는 10^9분의 1초)
- Object클래스는 멤버변수는 없고 오직 11개의 메서드만 가지고 있음
- equals메서드
  - 매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려주는 역할
  - 코드
    ```agsl
    public boolean equals(Object obj){
        return (this == obj)
    }
    ```
  - 서로 다른 두 객체를 equals메서드로 비교하면 항상 false를 결과로 얻음
  - 객체를 생성할 때, 메모리의 비어있는 공간을 찾아 생성하므로 서로 다른 두 개의 객체가 같은 주소를 갖는 일은 있을 수 없음
  - 두 개 이상의 참조변수가 같은 주소값을 갖는 것(한 객체를 참조하는 것)은 가능
  - equals메서드는 결국 두 개의 참조변수가 같은 객체를 참조하고 있는지, 두 참조변수에 저장된 값(주소값)이 같은지를 판단하는 기능밖에 할 수 없다
- hashCode메서드
  - 해싱(hashing)기법에 사용되는 해시함수(hash function)를 구현한 것
    - 해싱? 데이터관리기법 중의 하나로 다량의 데이터를 저장하고 검색하는데 유용
  - 해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드(hash code)를 반환
  - 일반적으로 해시코드가 같은 두 객체가 존재하는 것은 가능
  - but, Object클래스에 정의된 hashCode메서드는 객체의 주소값을 이용해서 해시코드를 만들어 반환하기 때문에 한번의 실행에서 서로 다른 두 객체는 결코 같은 해시코드를 가질 수 없음
  - 생성된 객체의 해시코드는 프로그램이 실행될 때마다 할당받는 메모리주소가 다를 것이므로 매번 실행할 때마다 다른 값을 갖지만, 적어도 프로그램이 시작된 후부터 종료될 때까지는 같은 값을 유지하기 때문
  - 해싱기법을 사용하는 HashMap이나 HashSet과 같은 클래스에 저장할 객체라면 반드시 hashCode메서드를 오버라이딩해야함
  - String클래스는 문자열의 내용이 같으면, 동일한 해시코드를 반환하도록 hashCode메서드를 오버라이딩함 
    => 같은 문자열이면 항상 동일한 해시코드값
  - System.identitiyHashCode(Object x)는 객체의 주소값으로 해시코드를 생성하기 때문에 => 모든 객체에 대해 항상 다른 해시코드값을 반환
- toString 메서드
  - toString()은 인스턴스에 대한 정보를 문자열(String)로 제공할 목적으로 정의한 것
  - Object클래스에 정의된 toString()
    ```agsl
    public String toString(){
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    ```
- clone메서드
  - 자신을 복제하여 새로운 인스턴스를 생성하는 일을 함
  - 원래의 인스턴스는 보존하고 cloneㅁ\ap서드를 이용해서 새로운 인스턴스를 생성하여 작업을 하면 작업이전의 값이 보존되므로 작업에 실패해서 원래의 상태로 되돌리거나 변경되기 전의 값을 참고하는데 도움이 됨
  - Object클래스에 정의된 clone메서드는 단순히 멤버변수의 값만을 복사하기 때문에 배열이나 인스턴스가 멤버로 정의되어 있는 클래스의 인스턴스는 완전한 복제가 이루어지지 않음
  - Cloneable인터페이스를 구현한 클래스의 인스턴스만 clone()을 통한 복제가 가능 => 인스턴스 복제는 데이터를 복사하는 것이기 때문에 데이터를 보호하기 위해서, 클래스 작성자가 복제를 허용하는 경우, Cloneable인터페이스를 구현한 경우에만 복제가 가능하도록 하기 위해서

### ❓ String 클래스
- 문자열을 위한 클래스
- String클래스의 특징
  - 문자열을 저장하기 위해서 문자형 배열 변수(char[]) value를 인스턴스 변수로 정의
  - 인스턴스 생성 시 생성자의 매개변수로 입력받는 문자열은 인스턴스변수(value)에 문자형 배열(char[])로 저장되는 것
  - 한번 생성된 String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있고 변경할 수는 없음
  - '+'연산자를 이용해서 문자열을 결합하는 경우 인스턴스내의 문자열이 바뀌는 것이 아니라 새로운 문자열이 담긴 String인스턴스가 생성되는 것
    - 매 연산시마다 새로운 문자열을 가진 String인스턴스가 생성되어 메모리공간을 차지하게 되므로 가능한 한 결합횟수를 줄이는 것이 좋음
  - 문자열간의 결합이나 추출 등 문자열을 다루는 작업이 많이 필요한 경우 =>> StringBuffer클래스를 사용하는 것이 좋음
    - StringBuffer인스턴스는 저장된 문자열은 변경이 가능하므로, 하나의 StringBuffer인스턴스만으로도 문자열을 다루는 것이 가능
  - 문자열을 만드는 방법 => 등가비교연산자로 비교했을 때 결과가 다름
    - 문자열 리터럴을 지정하는 방법
      - 같은 내용의 문자열들을 모두 하나의 String인스턴스를 참조
    - String클래스의 생성자를 사용해서 만드는 방법
      - new 연산자에 의해서 메모리할당이 이루어지기 때문에 항상 새로운 String인스턴스가 생성
  - 일반적으로 문자열들을 비교하기 위해서 equals메서드를 사용하지만, equals메서드로 문자열의 내용을 비교하는 것보다는 등가비교연산자(==)를 이용해서 주소를 비교하는 것이 더 빠름
  - 참조변수 s는 멤버변수이기 때문에 따로 초기화 해주지 않으면, 자신의 타입에 해당하는 기본값인 null로 초기화됨
    - String = "";와 같이 변수의 선언과 함께 빈 문자열로 초기화해주어야함
- 빈 문자열(empty string)
  - 크기가 0인 배열이 존재
  - char형 배열도 크기가 0인 배열을 생성할 수 있음 => 내부적으로 가지고 있는 문자열이 바로 빈 문자열
  - String s = "";처럼 char c = ''; 표현은 가능하지 않음
    - char형 변수에는 반드시 하나의 문자를 지정해줘야함 => char c = ' ';
- String클래스의 생성자와 메서드
  - p.383~385 참고
  - 기본형 값을 문자열로 바꾸는 방법
    - valueOf메서드는 매개변수로 기본형 변수와 객체를 지정할 수 있으며, 그 결과로 String을 얻을 수 있음
    - 덧셈연산자는 두 개의 피연산자 중 어느 한 쪽이라도 String이면 연산결과는 String이 됨
      - 변수에 빈 문자열을 더하면, 그 결과로 String을 얻을 수 잇음
    - => valueOf메서드를 사용하는 것이 더 성능이 좋음
  - 기본형 -> 문자열
    - String valueOf(boolean b)
    - String valueOf(char c)
    - String valueOf(int i)
    - String valueOf(long l)
    - String valueOf(float f)
    - String valueOf(double d)
  - 문자열 => 기본형
    - boolean Boolean.getBoolean(String s)
    - byte Byte.parseInt(String s)
    - short Short.parseShort(String s)
    - int Integer.parseInt(String s)
    - long Long.parseLong(String s)
    - float Float.parseFloat(String s)
    - double Double.parseDouble(String s)

### ❓ StringBuffer 클래스
- StringBuffer클래스의 특징
  - 내부적으로 문자열 편집을 위한 버퍼(buffer)를 가지고 있으며,  StringBuffer인스턴스를 생성할 때 그 크기를 지정할 수 있음
  - StringBuffer클래스는 String클래스와 같이 문자열ㅇ르 저장하기 위한 char형 배열의 참조 변수를 인스턴스변수로 선언해 놓고 있음
  - StringBuffer인스턴스가 생성될 때, char형 배열이 생성되며 이 때 생성된 char형 배열을 인스턴스변수 value가 참조하게 됨
- StringBuffer클래스의 생성자
  - StringBuffer인스턴스를 생성할 때는 생성자 StringBuffer(int length)를 사용해서 StringBuffer인스턴스에 저장될 문자열의 크기를 고려하여 충분히 여유있는 크기로 지정하는 것이 좋음
    - 버퍼의 크기를 지정해주지 않으면 16개의 문자를 저장할 수 있는 크기의 버퍼를 생성
- StringBuffer인스턴스의 비교
  - StringBuffer클래스는 equals메서드를 오버라이딩하지 않아서 StringBuffer클래스의 equals메서드를 사용해도 등가비교연산자(==)로 비교한 것과 같은 결과
  - toString()은 오버라이딩되어 있어서 StringBuffer인스턴스에 toString()을 호출하면, 담고있는 문자열 String으로 반환
  - StringBuffer인스턴스에 담긴 문자열을 비교하기 위해서 toString()을 호출해서 String인스턴스를 얻은 다음 equals메서드를 사용해서 비교
- StringBuffer클래스의 생성자와 메서드
  - p392~393 참고

### ❓ Math 클래스
- Math클래스
  - 기본적인 수학계산에 유용한 메서드로 구성
  - Math클래스의 생성자는 접근 제어자가 private이기 때문에 다르클래스에서 Math인스턴스를 생성할 수 없도록 되어있음
    - 클래스 내에 인스턴스변수가 하나도 없어서 인스턴스를 생성할 피룡가 없기 때문에
- Math클래스의 메서드
  - p385 참고

### ❓ wrapper클래스
- wrapper클래스
  - 기본형(primitive type) 변수도 때로는 객체로 다루어져야하는 경우
    - 예) 매개변수로 객체를 요구할 때, 기본형 값이 나닌 객체로 저장해야할 때, 객체간의 비교가 필요할 때 등
      - 기본형 값들을 객체로 변환하여 작업을 수행 => 이 때 사용
  - wrapper클래스의 생성자는 매개변수로 문자열이나 각 자료형의 값들을 인자로 받음
    - 주의해야할 점 : 생성자의 매개변수로 문자열을 제공할 때, 각 자료형에 알맞은 문자열을 사용해야한다는 것
  - wrapper클래스들은 객체생성 시에 생성자의 인자로 주어진 각 자료형에 알맞은 값을 내부적으로 저장하고 있음
  - wrapper클래스들은 모두 equals()가 오버라이딩되어 있어서 주소값이 아닌 객체가 가지고 있는 값을 비교
  - 래퍼클래스
    - Boolean
    - Character
    - Byte
    - Short
    - Integer
    - Long
    - Float
    - Double
  - wrapper클래스의 '타입.parse타입(String s)' 형식의 메서드와 '타입.valueOf()'메서드 정리
    - 둘 다 문자를 숫자로 바꿔주는 일을 하지만, 전자는 반환값이 기본형, 후자는 반환값이 wrapper클래스 타입
    - 문자열 -> 기본형
      - byte b = Byte.parseByte();
      - short s = Short.parseShort();
      - int i = Integer.parseInt();
      - long l = Long.parseLong();
      - float f = Float.parseFloat();
      - double d = Double.parseDouble();
    - 문자열 -> wrapper 클래스
      - Byte b = Byte.valueOf();
      - Short s = Short.valueOf();
      - Integer i = Integer.valueOf();
      - Long l = Long.valueOf();
      - Float f = Float.valueOf();
      - Double d = Double.valueOf();
  - 오토박싱(autoboxing) 기능 때문에 반환값이 기본형일 때와 wrapper클래스일 때의 차이가 없어짐
    - 기본형과 참조형간의 형변환도 가능할 뿐 아니라, 참조형 간의 연산도 가능
    - 컴파일러가 제공하는 편리한 기능일 뿐 Java의 근본적인 원칙이 바뀐 것으 ㄴ아님
    - 오토박싱 사용법
      - 컴파일 전 코드 : Integer intg = (Integer)i;
      - 컴파일 후 코드 : Integer intg = Integer.valueOf(i);
- Number클래스
  - 추상클래스로 내부적으로 숫자를 멤버변수로 갖는 클래스들의 조상
  - 기본형 중에서 숫자와 관련된 wrapper클래스들은 모두 Number클래스의 자손
  - Number클래스 자손으로 BigInteger와 BigDecimal 등이 있음
    - BigInteger는 long으로도 다룰 수 없는 큰 범위의 정수를 처리하기 위한 것
    - BigDecimal은 double로도 다룰 수 없는 큰 범위의 부동 소수점수를 처리하기 위한 것

### ❗ 회독
|  1회독  | 2회독  | 3회독  | 4회독  |  5회독  |
|:-----:|:----:|:----:|:----:|:-----:|
|   ⭕   |