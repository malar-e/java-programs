import mypackage.Camera;

public class MultipleInterface {
    public static void main(String[] args){
        Camera obj1 = new SmartPhone();
        obj1.takePhoto();
        System.out.println();
        SmartPhone obj2 = new SmartPhone();
        obj2.takePhoto();
        obj2.connect();

    }
}
interface WiFi {
    void connect();
}
class SmartPhone implements Camera, WiFi {
    public void takePhoto() {
        System.out.println("Taking a photo using smartphone camera");
    }

    public void connect() {
        System.out.println("Connecting to WiFi network");
    }
}