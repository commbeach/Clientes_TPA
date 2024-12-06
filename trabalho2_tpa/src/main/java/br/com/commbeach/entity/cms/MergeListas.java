//classe que junta as sublistas
package br.com.commbeach.entity.cms;


import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;

public class MergeListas {

    BufferDeClientes[] buffers;
    BufferDeClientes saida;
    Queue<Cliente> fila;

//função que inicializa e setta os buffers
    public void inicializaBuffer(){
        Queue<Cliente> fila =new PriorityQueue<>();
        this.buffers=new BufferDeClientes[10];
        for(int i=0;i<10;i++){
            String arquivo = "subLista"+i;
            BufferDeClientes novo_buffer = new BufferDeClientes();
            this.buffers[i]=novo_buffer;
            novo_buffer.arqSequencial(arquivo, "leitura");
            novo_buffer.carregaBuffer();
            Cliente cliente=novo_buffer.proximoCliente();
            fila.add(cliente);
        }  
       this.fila=fila;
        BufferDeClientes saida = new BufferDeClientes();
        saida.arqSequencial("listaOrdenada","escrita");
        this.saida=saida;
    }

    //função que realiza o 10-wayMerge das listas    
    public void kwayMerge(){
        inicializaBuffer();
        while(!this.fila.isEmpty()){
            for(int i=0;i<10;i++){
                this.buffers[i].carregaBuffer();
                Cliente cliente=this.buffers[i].proximoCliente();
                if(cliente!=null){
                    this.fila.add(cliente);
                }
                if(i%2==0){
                    this.saida.adicionaAoBuffer(this.fila.poll());
                }
            }
    }
        saida.escreveBuffer();
}

}
