package tzhmufl2.android_hellospring.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tzhmufl2.android_hellospring.R;
import tzhmufl2.android_hellospring.domain.Character;

/**
 * Created by tzhmufl2 on 17.06.14.
 */
public class CharacterListAdapter extends ArrayAdapter<Character>
{
    private final Context context;
    private final List<Character> characters;

    public CharacterListAdapter(Context context, int textViewResourceId, List<Character> characters)
    {
        super(context, R.layout.character_row, characters);
        this.context = context;
        this.characters = characters;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        Character character = characters.get(position);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.character_row, parent, false);

        TextView tvFirstname = (TextView)rowView.findViewById(R.id.tv_firstname);
        TextView tvLastname = (TextView)rowView.findViewById(R.id.tv_lastname);
        ImageView ivImage = (ImageView)rowView.findViewById(R.id.iv_image);

        tvFirstname.setText(character.getFirstname());
        tvLastname.setText(character.getLastname());
        // ivImage.setImageResource(character.getImageURL());

        return rowView;
    }
}