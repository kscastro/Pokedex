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

    @BindView(R.id.tv_titulo)
    TextView tTitulo;
    @BindView(R.id.fotoImageView)
    ImageView tvImagemText;

    private Context context;


    public ActivityDoItem(Context context) {
        this.context = context;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_item);
        ButterKnife.bind(this);

        if (getIntent() != null && getIntent().hasExtra("POKEMON")) {
            final Pokemon item = getIntent().getParcelableExtra("POKEMON");
            tTitulo.setText(item.getName());
            Glide.with(context)
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
