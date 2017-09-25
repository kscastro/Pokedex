package br.com.infnet.pokedex;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDoItem extends AppCompatActivity {

    @BindView(R.id.tv_detail_name)
    TextView tTitulo;
    @BindView(R.id.iv_detail_pokemon)
    ImageView tvImagemText;
    @BindView(R.id.tv_detail_types)
    TextView tType;
    @BindView(R.id.tv_detail_attack)
    TextView tAttack;



    private Context context;


    public ActivityDoItem(){

    }

    public ActivityDoItem(Context context) {
        this.context = context;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_item);
        ButterKnife.bind(this);

        tTitulo = (TextView) findViewById(R.id.tv_detail_name);
        tvImagemText = (ImageView) findViewById(R.id.iv_detail_pokemon);
        tType = (TextView)findViewById(R.id.tv_detail_types);
        tAttack = (TextView)findViewById(R.id.tv_detail_attack);

        if (getIntent() != null && getIntent().hasExtra("POKEMON")) {

            Bundle bundle = getIntent().getExtras();

            final Pokemon item =  (Pokemon) bundle.getSerializable("POKEMON");

            tTitulo.setText(item.getName().toUpperCase());
            tAttack.setText(("Attack: " + String.valueOf(item.getAttack())));
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
