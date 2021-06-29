package laChiqui;

import laChiqui.domain.Festa;
import laChiqui.domain.FogosArtificio;

import java.util.ArrayList;
import java.util.Arrays;

public class MainParty {

    public static void main(String[] args) {
        Festa festa = new Festa();

        ArrayList<FogosArtificio> pacote1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            pacote1.add(new FogosArtificio(true,new ArrayList<>()));
        }

        FogosArtificio finalFogo = new FogosArtificio(false,pacote1);

        festa.setFogos(Arrays.asList(finalFogo));

        festa.apagarVelas();
    }
}
