package br.com.infnet.pokedex.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaike on 03/09/2017.
 */

public class Pokemon implements Serializable{

    private int number;
    private String name;
    private String url;
    private Integer attack;
    private Integer defense;
    private String height;
    private Integer health;
    private Integer speed;


    public Pokemon(String name, Integer attack, Integer defense, String height, Integer health, Integer speed,  List<PokeType> pokeTypes) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.height = height;
        this.health = health;
        this.speed = speed;
        this.pokeTypes = pokeTypes;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    private List<PokeType> pokeTypes = new ArrayList<>();


    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public List<PokeType> getPokeTypes() {
        return pokeTypes;
    }

    public void setPokeTypes(List<PokeType> pokeTypes) {
        this.pokeTypes = pokeTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public String pokeTypesToString() {
        String types = "";
        for (int i = 0; i < pokeTypes.size(); i++) {
            if(i > 0)
                types += ", ";
            types += pokeTypes.get(i).getName();
        }
        return types;
    }


}



