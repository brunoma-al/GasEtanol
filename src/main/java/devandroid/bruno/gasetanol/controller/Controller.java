package devandroid.bruno.gasetanol.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

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

    public List<Combustivel> getListaDeDados(){
        List<Combustivel> listarDados = null;
        return null;
    }

    public void alterar(Combustivel combustivel){

        ContentValues dados = new ContentValues();

        dados.put("id",combustivel.getId());
        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        alterarObjeto("Combustivel",dados);

    }

    public void deletar(int id){
        deletarObjeto("Combustivel",id);
    }


    public void limpar(){

        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
