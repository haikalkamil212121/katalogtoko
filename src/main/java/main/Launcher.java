package main;

// Main class yang tidak extends Application, supaya JavaFX (di classpath Maven)
// bisa dijalankan dari NetBeans: Run, Run File, maupun Debug.
public class Launcher {

    public static void main(String[] args) {
        MainApp.main(args);
    }
}
