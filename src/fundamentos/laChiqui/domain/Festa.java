package fundamentos.laChiqui.domain;

import java.util.ArrayList;
import java.util.List;

public class Festa {
    private List<Convidado> convidados;
    private List<FogosArtificio> fogos;

    public Festa() {
        this.convidados = new ArrayList<>();
        this.setGuests();
        this.fogos = new ArrayList<>();
    }

    public void apagarVelas(){
        System.out.println("Apagando velas....\n");
        for (FogosArtificio f: fogos) {
            f.acenderFogos();
        }
        for (Convidado c: convidados) {
            c.comer();
        }
    }
    
    private void setGuests(){
        for (int i = 0; i < 20; i++) {
            convidados.add(new Meli(String.valueOf(i)));
            convidados.add(new Regular(String.valueOf(i)));
        }
    }

    public List<Convidado> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<Convidado> convidados) {
        this.convidados = convidados;
    }

    public List<FogosArtificio> getFogos() {
        return fogos;
    }

    public void setFogos(List<FogosArtificio> fogos) {
        this.fogos = fogos;
    }
}
