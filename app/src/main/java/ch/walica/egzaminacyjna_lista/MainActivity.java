package ch.walica.egzaminacyjna_lista;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNewItem;
    private Button btnAdd;
    private ListView listView;
    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNewItem = findViewById(R.id.etNewItem);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        items.add("Zakupy: chleb, masło, ser");
        items.add("Do zrobienia: obiad, umyć podłogi");
        items.add("weekend: kino, spacer z psem");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_view, R.id.tvItem, items);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(view -> {
            String item = etNewItem.getText().toString().trim();
            if (!item.isEmpty()) {
                items.add(item);
                adapter.notifyDataSetChanged();
            }
        });

    }
}