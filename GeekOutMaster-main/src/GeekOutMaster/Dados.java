package GeekOutMaster;
import java.util.Random;

public class Dados {
    /**
     * This class to get a random value between 1-12 for the game cards

     */
    private int cara, caraOpuesta;
    private String caraString;

    public Dados () {
        this.cara = cara;
        this.caraOpuesta= caraOpuesta;
        this.caraString= caraString;

    }

    public int getCara() {
        Random aleatorio = new Random();
        this.cara = aleatorio.nextInt(6) + 1;

        return this.cara;
    }

    /**
     * Este metodo Devuelve la cara opuesta de los dados
    * */

    public int getCaraOpuesta(){
        switch (cara){

            case 1:
                caraOpuesta= 6;
                break;
            case 2:
                caraOpuesta=5;
                break;
            case 3:
                caraOpuesta= 4;
                break;
            case 4:
                caraOpuesta= 3;
                break;
            case 5:
                caraOpuesta=2;

                break;
            case 6:
                caraOpuesta=1;
                break;

        }
        return caraOpuesta;

    }




}