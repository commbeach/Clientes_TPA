//classe que divide o arquivo de clientes em outros 10 arquivos não ordenados
package br.com.commbeach.entity.cms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class DivisorArquivo{
    private ArquivoCliente arquivoCliente;
    private int tamanhoSublistas;

    public void associaLista(ArquivoCliente arquivoCliente) {
        this.arquivoCliente = arquivoCliente;
        this.tamanhoSublistas = arquivoCliente.totalRegistros/10;
    }

    public void divideLista(String nomeArquivo, int tamanho) throws IOException, ClassNotFoundException{
        //System.out.println("entrou aqui1");
        ArquivoCliente paraDividir=new ArquivoCliente();
        //ArquivoCliente paraContar=new ArquivoCliente();
        //System.out.println("entrou aqui1");
        paraDividir.abrirArquivo(nomeArquivo, "leitura", Cliente.class);
        //paraContar.abrirArquivo(nomeArquivo, "leitura", Cliente.class);
        //System.out.println("entrou aqui1");
        //int n = paraContar.count();
        for(int i=0;i<10;i++){
            //System.out.println("entrou aqui2");
            String nomeLista= "subLista".concat(Integer.toString(i));
            List<Cliente> clientes=paraDividir.leiaDoArquivo(tamanho/10);
            System.out.println(Integer.toString(clientes.size())); 
            ArquivoCliente nova_sublista=new ArquivoCliente();
            nova_sublista.abrirArquivo(nomeLista,"escrita",Cliente.class);
            nova_sublista.escreveNoArquivo(clientes);
            nova_sublista.fechaArquivo();
        }
        //System.out.println(Integer.toString(n)); 
        System.out.println("feito");
        paraDividir.fechaArquivo();
        //paraContar.fechaArquivo();

    }




}