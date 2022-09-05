package ir.mahdi.training.spring.ioc;

public class HelloWorld {
    private String msg;

    public String getMsg() {
        System.out.println(String.format("Your message is %s", msg));
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
