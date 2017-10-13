package br.com.infnet.pokedex.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import br.com.infnet.pokedex.Model.Pokemon;
import br.com.infnet.pokedex.Model.Status;
import br.com.infnet.pokedex.R;
import br.com.infnet.pokedex.Services.PokeapiService;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detail extends AppCompatActivity {

    private Retrofit retrofit = new Retrofit.Builder().
            baseUrl("http://pokeapi.co/api/v2/").
            addConverterFactory(GsonConverterFactory.create()).
            build();

    @BindView(R.id.tv_detail_name)
    TextView tTitulo;
    @BindView(R.id.iv_detail_pokemon)
    ImageView tvImagemText;
    @BindView(R.id.tv_detail_types)
    TextView tType;
    @BindView(R.id.tv_detail_attack)
    TextView tAttack;
    @BindView(R.id.tv_detail_defense)
    TextView tDefense;
    @BindView(R.id.tv_detail_speed)
    TextView tSpeed;
    @BindView(R.id.tv_detail_special_defense)
    TextView tSpDefense;
    @BindView(R.id.tv_detail_special_attack)
    TextView tSpAttack;


    private Context context;


    public Detail() {

    }

    public Detail(Context context) {
        this.context = context;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_item);
        ButterKnife.bind(this);

        tTitulo = (TextView) findViewById(R.id.tv_detail_name);
        tvImagemText = (ImageView) findViewById(R.id.iv_detail_pokemon);
        tType = (TextView) findViewById(R.id.tv_detail_types);
        tAttack = (TextView) findViewById(R.id.tv_detail_attack);
        tDefense = (TextView) findViewById(R.id.tv_detail_defense);
        tSpeed = (TextView)findViewById(R.id.tv_detail_speed);
        tSpDefense = (TextView) findViewById(R.id.tv_detail_special_defense);
        tSpAttack = (TextView) findViewById(R.id.tv_detail_special_attack);

        if (getIntent() != null && getIntent().hasExtra("POKEMON")) {

            Bundle bundle = getIntent().getExtras();

            final Pokemon item = (Pokemon) bundle.getSerializable("POKEMON");

            retrofit.create(PokeapiService.class)
                    .obterPokemon(Integer.parseInt(item.getUrl().split("/")[item.getUrl().split("/").length - 1]))
                    .enqueue(new Callback<Status>() {
                        @Override
                        public void onResponse(Call<Status> call, Response<Status> response) {
                            Log.d("Detail", "onResponse: " + response.body().toString());
                            for (Status.StatsBean b : response.body().getStats()) {
                                if (b.getStat().getName().equalsIgnoreCase("attack")) {
                                    tAttack.setText(("Attack: " + String.valueOf(b.getBase_stat())));
                                }if (b.getStat().getName().equalsIgnoreCase("defense")){
                                    tDefense.setText(("Defense: " + String.valueOf(b.getBase_stat())));
                                }if(b.getStat().getName().equalsIgnoreCase("speed")){
                                    tSpeed.setText(("Speed:" + String.valueOf(b.getBase_stat())));
                                }if(b.getStat().getName().equalsIgnoreCase("special-defense")){
                                    tSpDefense.setText(("Special Defense:" + String.valueOf(b.getBase_stat())));
                                }if(b.getStat().getName().equalsIgnoreCase("special-attack")){
                                    tSpAttack.setText(("Special Attack:" + String.valueOf(b.getBase_stat())));
                                }

                            }
                            for(Status.TypesBean a: response.body().getTypes()){
                                    tType.setText(String.valueOf(a.getType().getName().toUpperCase()));

                            }

                        }

                        @Override
                        public void onFailure(Call<Status> call, Throwable t) {
                            Log.d("Detail", "onFailure: ", t);
                        }
                    });
            tTitulo.setText(item.getName().toUpperCase());
            tAttack.setText("Attack: carregando..");
            tDefense.setText("Defense: carregando..");
            tSpeed.setText("Defense: carregando..");
            tSpDefense.setText("Special Defense: carregando..");
            tSpAttack.setText("Special Attack: carregando..");
            tType.setText("");
            Glide.with(this)
                    .load("http://pokeapi.co/media/sprites/pokemon/" + item.getNumber() + ".png")
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(tvImagemText);


        } else {
            Toast.makeText(this, "Nada para mostrar :(", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
