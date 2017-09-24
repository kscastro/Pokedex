package br.com.infnet.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import br.com.infnet.pokedex.PokemonResposta;

/**
 * Created by kaike on 03/09/2017.
 */

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonResposta> obterListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
}
