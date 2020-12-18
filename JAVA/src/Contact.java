public class Contact {
    private String name;
    private String num;

    public Contact(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }
    public static Contact mycont(String name,String num)
    {
        return new Contact(name,num);

    }

}
