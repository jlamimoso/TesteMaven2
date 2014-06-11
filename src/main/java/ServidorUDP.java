
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlamimoso
 */
public class ServidorUDP {
    public static void main(String[] args) throws Exception 
    {
        new ServidorUDP().start();
    }
    
    public void start() throws Exception
    {
        int porta = 9090;
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(porta));
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        System.out.printf("Servidor UDP Java iniciando na porta %d\n", porta);
        
        while(true) 
        {
            InetSocketAddress sa = (InetSocketAddress)channel.receive(buf); 
            buf.flip();
            byte[] b = new byte[buf.limit()];
            buf.get(b);
            System.out.printf("Valor do buffer %d recebido %s de %s porta %d \n", b.length, new String(b), sa.getHostString(), sa.getPort());
            buf.clear();
        } //while
    } //main  
}
