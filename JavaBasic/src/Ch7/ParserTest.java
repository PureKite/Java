package Ch7;

interface Parseable {
    public abstract void parse(String fileName);
}
class ParserManager{
    public static Parseable getFarser(String type){
        if(type.equals("XML")){
            return new XMLParser();
        }else{
            Parseable p = new HTMLParser();
            return p;
        }
    }
}
class XMLParser implements Parseable{
    public void parse(String fileName){
        System.out.println(fileName + "-XML parsing completed.");
    }
}
class HTMLParser implements Parseable{
    public void parse(String fileName){
        System.out.println(fileName + "-HTML parsing completed.");
    }
}
class ParserTest{
    public static void main(String[] args) {
        Parseable parser = ParserManager.getFarser("XML");
        parser.parse("document.xml");
        parser = ParserManager.getFarser("HTML");
        parser.parse("document2.html");
    }
}