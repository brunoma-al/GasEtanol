package devandroid.bruno.gasetanol.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import devandroid.bruno.gasetanol.database.GasEta;
import devandroid.bruno.gasetanol.model.Combustivel;
import devandroid.bruno.gasetanol.view.GasEtaActivity;

public class Controller extends GasEta {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public Controller(GasEtaActivity activity){
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel combustivel){
        ContentValues dados = new ContentValues();

        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao",combustivel.getRecomendacao());
        dadosPreferences.apply();

        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("Combustivel", dados);
    }

    private void salvarObjeto(String combustivel, ContentValues dados) {
    }
}
