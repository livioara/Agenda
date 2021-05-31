package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.DAO.AlunoDAO;
import com.example.agenda.R;
import com.example.agenda.model.Aluno;


public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle("Novo aluno");

        AlunoDAO dao = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activty_formulario_nome);
        final EditText campoTelefone = findViewById(R.id.activty_formulario_telefone);
        final EditText campoemail = findViewById(R.id.activty_formulario_email);

        Button botao_Salvar = findViewById(R.id.activity_formulario_aluno_botao);
        botao_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoemail.getText().toString();

                Aluno alunocriado = new Aluno(nome, telefone, email);
                dao.salva(alunocriado);

                finish();



            }
        });
    }
}