package br.com.commbeach.entity.cms;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class OrdenarListas{

    public void ordenar(String nomeLista, int tamanhoLista) throws IOException, ClassNotFoundException{

        ArquivoCliente arquivo = new ArquivoCliente();
        arquivo.abrirArquivo(nomeLista,"leitura",Cliente.class);
        List<Cliente> clientes=arquivo.leiaDoArquivo(tamanhoLista);
        ordenarLista(clientes, tamanhoLista);
        ArquivoCliente arquivo_novo = new ArquivoCliente();
        arquivo_novo.abrirArquivo(nomeLista,"escrita",Cliente.class);
        arquivo_novo.escreveNoArquivo(clientes);
    }

    public void ordenarLista(List<Cliente> clientes, int n) throws IOException, ClassNotFoundException{
        if(n<=1){
            return;
    
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            String cliente1=clientes.get(i).getNome();
            String cliente2=clientes.get(i+1).getNome();

            if(cliente1.compareTo(cliente2)>0){
                Cliente temp=clientes.get(i);
                clientes.set(i,clientes.get(i+1));
                clientes.set(i+1,temp);
                count=count+1;
            }
        }
        if (count==0){
            return;
        
        }
        ordenarLista(clientes, n-1);
        

        
        
    }
   
   

    
}
