//classe que divide o arquivo de clientes em outros 10 arquivos não ordenados
package br.com.commbeach.entity.cms;

import java.util.List;
import java.io.IOException;


public class DivisorArquivo{


    //metodo que divide a lista em outras 10 listas menores
    public void divideLista(String nomeArquivo, int tamanho) throws IOException, ClassNotFoundException{
        
        ArquivoCliente paraDividir=new ArquivoCliente();
        paraDividir.abrirArquivo(nomeArquivo, "leitura", Cliente.class);
      
        for(int i=0;i<10;i++){
           //salva as listas com o nome subLista<numero>
            String nomeLista= "subLista".concat(Integer.toString(i));
            List<Cliente> clientes=paraDividir.leiaDoArquivo(tamanho/10);
            ArquivoCliente nova_sublista=new ArquivoCliente();
            nova_sublista.abrirArquivo(nomeLista,"escrita",Cliente.class);
            nova_sublista.escreveNoArquivo(clientes);
            nova_sublista.fechaArquivo();
        }
        
        paraDividir.fechaArquivo();
       

    }




}