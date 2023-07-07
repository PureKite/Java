package Ch7;

class Product {
    int price;
    int bonusPoint;

    Product(int price){
        this.price = price;
        bonusPoint = (int) (price/10.0);
    }
}
class Tv2 extends Product{
    Tv2(){
        // 조상클래스의 생성자 Product(int price) 호출
        super(100); // Tv의 가격
    }
    public String toString(){ // Object클래스의 toString()을 오버라이딩
        return "Tv";
    }
}
class Computer extends Product{
    Computer(){
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}
class Buyer{
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "을/를 구입하셨습니다.");
    }
}
class PolyArgumentTest{
    public static void main(String[] args) {
        Buyer b = new Buyer();
        Tv2 tv = new Tv2();
        Computer com = new Computer();

        b.buy(tv);
        b.buy(com);

        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
    }
}