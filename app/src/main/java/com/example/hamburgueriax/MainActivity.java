package com.example.hamburgueriax;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void somar(View view) {
        quantidade = quantidade + 1;
        displayQuantidade(quantidade);

    }

    public void subtrair(View view) {
        if (quantidade > 0) {
            quantidade = quantidade - 1;
            displayQuantidade(quantidade);
        }
    }
    public void displayQuantidade(int qtd) {
        TextView qtdTextView = (TextView) findViewById(R.id.quantidade_tv);
        qtdTextView.setText("" + qtd);
    }

    public String criarMensagemPedido(String nome, int valor, boolean temQueijo, boolean temPicles, boolean temCebolaCaramelizada) {
        String mensagem = "Nome: " + nome;
        mensagem += "\nQueijo? " + temQueijo;
        mensagem += "\nPicles? " + temPicles;
        mensagem += "\nCebola Caramelizada? " + temCebolaCaramelizada;
        mensagem += "\nQuantidade: " + quantidade;
        mensagem += "\n\nTotal: R$ " + valor;
        return (mensagem);
    }

    public void enviarPedido(View view) {
        EditText campoNome = (EditText) findViewById(R.id.campo_nome);
        String nome = campoNome.getText().toString();

        CheckBox checkBoxQueijo = (CheckBox) findViewById(R.id.queijo);
        boolean temQueijo = checkBoxQueijo.isChecked();

        CheckBox checkBoxPicles = (CheckBox) findViewById(R.id.picles);
        boolean temPicles = checkBoxPicles.isChecked();

        CheckBox checkBoxCebolaCaramelizada = (CheckBox) findViewById(R.id.cebolacaramelizada);
        boolean temCebolaCaramelizada = checkBoxCebolaCaramelizada.isChecked();

        int valor = calculaPreco(temQueijo, temPicles, temCebolaCaramelizada);

        String pedido = criarMensagemPedido(nome, valor, temQueijo, temPicles, temCebolaCaramelizada);

        displayPedido(pedido);

    }

    public void displayPedido(String pedido) {
        TextView pedidoTextView = (TextView) findViewById(R.id.resumo_pedido);
        pedidoTextView.setText(pedido);
    }

    public int calculaPreco(boolean temQueijo, boolean temPicles, boolean temCebolaCaramelizada) {
        int precoBase = 20;

        if (temQueijo)
            precoBase += 2;
        if (temPicles)
            precoBase += 2;
        if (temCebolaCaramelizada)
            precoBase += 3;

        return precoBase * quantidade;

    }
}