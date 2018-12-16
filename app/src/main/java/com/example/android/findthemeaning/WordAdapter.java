package com.example.android.findthemeaning;

import android.content.Context;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.findthemeaning.model.Entry;
import com.example.android.findthemeaning.model.LexicalEntry;
import com.example.android.findthemeaning.model.Pronunciation;
import com.example.android.findthemeaning.model.Sense;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordView> {

    private List<LexicalEntry> lexicalEntries;
    String word_id;
    private Context context;

    public WordAdapter(List<LexicalEntry> lexicalEntries, Context context,String word_id) {

        this.lexicalEntries = lexicalEntries;
        this.context = context;
        this.word_id = word_id;
    }

    public void setLexicalEntries(List<LexicalEntry> lexicalEntries) {
        this.lexicalEntries = lexicalEntries;

    }

    @NonNull
    @Override
    public WordView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WordView(LayoutInflater.from(context).inflate(R.layout.layout_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull WordView wordView, int position) {

        LexicalEntry lexicalEntry = lexicalEntries.get(position);
        Entry entry = lexicalEntry.getEntries().get(0);

        //Pronunciation pronunciation = lexicalEntry.getPronunciations().get(0);
        //String audio = pronunciation.getAudioFile();

        Sense sense = entry.getSenses().get(0);


        wordView.wordText.setText(word_id);
        wordView.definition.setText(sense.getDefinitions().get(0));
        wordView.lexical.setText(lexicalEntry.getLexicalCategory());

    }

    @Override
    public int getItemCount() {
        return lexicalEntries.size();
    }



    static class WordView extends RecyclerView.ViewHolder {
        TextView definition;
        TextView lexical;
        TextView wordText;


        public WordView(View v) {
            super(v);

            this.definition = v.findViewById(R.id.definition);
            this.lexical = v.findViewById(R.id.lexical);
            this.wordText = v.findViewById(R.id.word);
        }
    }
}
