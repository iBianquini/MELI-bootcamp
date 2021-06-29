package laChiqui.domain;

import java.util.ArrayList;
import java.util.List;

public class FogosArtificio {
    private boolean isSingle;
    private List<FogosArtificio> pacotes;

    public FogosArtificio(boolean isSingle, List<FogosArtificio> pacotes) {
        if (isSingle){
            this.isSingle = true;
            this.pacotes = new ArrayList<>();
        }else{
            this.isSingle = false;
            this.pacotes = pacotes;
        }
    }

    public void acenderFogos(){
        if (isSingle)
            System.out.println("shhhhhhhh, vuupt, pow, pow, pow");
        else {
            pacotes.forEach(FogosArtificio::acenderFogos);
        }
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public List<FogosArtificio> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<FogosArtificio> pacotes) {
        this.pacotes = pacotes;
    }
}
