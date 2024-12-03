package br.com.commbeach.entity.cms;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class OrdenarListas{

    public void ordenar(String nomeLista, int tamanhoLista) throws IOException, ClassNotFoundException{

        ArquivoCliente arquivo = new ArquivoCliente();
        //System.out.println("entrou aqui1");
        arquivo.abrirArquivo(nomeLista,"leitura",Cliente.class);
        List<Cliente> clientes=arquivo.leiaDoArquivo(tamanhoLista);
        ordenarLista(clientes, tamanhoLista);
        ArquivoCliente arquivo_novo = new ArquivoCliente();
        //System.out.println("entrou aqui1");
        arquivo_novo.abrirArquivo(nomeLista,"escrita",Cliente.class);
        arquivo_novo.escreveNoArquivo(clientes);
        //System.out.println("entrou aqui1");
    }

    public void ordenarLista(List<Cliente> clientes, int n) throws IOException, ClassNotFoundException{
        for(Cliente c : clientes){
            //System.out.println(c.toString());
        }
       
        if(n<=1){
            //System.out.println("entrou aqui:3");
            return;
    
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            //System.out.println("entrou aqui:3");
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
