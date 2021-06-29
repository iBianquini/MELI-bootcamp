package saveTheRopa.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRoupa {

    private Map<Integer, List<Vestuario>> roupasArmazenadas;
    private int count;

    public GuardaRoupa() {
        this.count = 0;
        this.roupasArmazenadas = new HashMap<>();
    }

    public Integer guardarRoupas(List<Vestuario> roupas){
      this.roupasArmazenadas.put(count,roupas);
      return count++;
    }

    public void mostrarVestuario(){
        System.out.println(roupasArmazenadas.toString());
    }

    public List<Vestuario> devolverVestuarios(Integer id){
        return this.roupasArmazenadas.remove(id);
    }
}
