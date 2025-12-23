
import controller.Nasabah_C030;
import model.Nasabah_M030;
import view.Nasabah_V030;

public class Main {

    public static void main(String[] args) {
        Nasabah_V030 view = new Nasabah_V030();
        Nasabah_M030 model = new Nasabah_M030();
        new Nasabah_C030(view, model);

        view.setVisible(true);
    }
}
