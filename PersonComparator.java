import java.util.Comparator;


public class PersonComparator implements Comparator<FichaDeCliente> {

    public int compare(FichaDeCliente f1, FichaDeCliente f2) {
        return f1.getNome().compareTo(f2.getNome());
    }
}