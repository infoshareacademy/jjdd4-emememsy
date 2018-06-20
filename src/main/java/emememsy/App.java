package emememsy;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        new App().run();
    }

    private void run() {

        try {
            InputOutput.checkReader();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
