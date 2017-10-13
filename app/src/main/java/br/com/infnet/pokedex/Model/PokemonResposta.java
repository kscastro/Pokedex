package br.com.infnet.pokedex.Model;

import java.util.ArrayList;

import br.com.infnet.pokedex.Model.Pokemon;

/**
 * Created by kaike on 03/09/2017.
 */

public class PokemonResposta {
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
