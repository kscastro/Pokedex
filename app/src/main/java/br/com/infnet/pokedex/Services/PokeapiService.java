package br.com.infnet.pokedex.Services;

import br.com.infnet.pokedex.Model.Status;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import br.com.infnet.pokedex.Model.PokemonResposta;

/**
 * Created by kaike on 03/09/2017.
 */

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonResposta> obterListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<Status> obterPokemon(@Path("id") int offset);
}
