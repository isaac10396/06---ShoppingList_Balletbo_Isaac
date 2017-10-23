package edu.upc.eseiaat.pma.balletbo.isaac.shoppinglist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Usuario on 23/10/2017.
 */

public class ShoppingListAdapter extends ArrayAdapter<String> {
    public ShoppingListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    //Llama a ListView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //El convertView serveix per si hi ha molt elements,es reciclin a la pantalla com
        //una escala mecànica i quan tiris abaix i surtin de la pantalla, es mostrin per adalt
        View result = convertView;
        //Si no tenim suficients ítems, ho inflem pk funcioni el convertView
        if(result == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            result = inflater.inflate(R.layout.shopping_item, null);
        }

        //Se saca el elemento del Checkbox
        CheckBox shopping_item = (CheckBox) result.findViewById(R.id.shopping_item);
        //Se saca el ítem de los datos
        String item_text = getItem(position);
        //Se coge el Checkbox y se le pone como texto el item_text
        shopping_item.setText(item_text);
        return result;

    }
}
