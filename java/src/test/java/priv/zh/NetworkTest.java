package priv.zh;


import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTest {
    @Test
    public  void networkTest(){

        ServerSocket server;
        try{
            server = new ServerSocket(65534);
            System.out.println("listening on 65534");
            while(true){
                final Socket clientSocket= server.accept();
                new Thread(()->{
                    System.out.println("handle request from "+clientSocket.getPort());
                    InputStream ioStream=null;
                    OutputStream outStream=null;
                    String serverMessage = "";
                    try{
                        ioStream=clientSocket.getInputStream();
                        outStream =clientSocket.getOutputStream();
                        PrintWriter pw =new PrintWriter(outStream);
                        Scanner scann= new Scanner(ioStream);
                        Scanner outScan = new Scanner(System.in);
                        while (true){
                            serverMessage=scann.nextLine();
                            if(serverMessage.equals("bye")){
                                pw.println("ok");
                                pw.flush();
                                break;
                            }
                            System.out.println("accept handle from "+clientSocket.getInetAddress().toString()+":"+clientSocket.getPort()+",say:"+ serverMessage);
                            //System.out.print("pls input message send to "+clientSocket.getPort()+":");
                            //String msg=outScan.nextLine();
                            pw.println("1234");
                            pw.flush();
                        }
                        System.out.println("server end connection");
                    }catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }finally {
                        if(ioStream!=null){
                            try{
                                ioStream.close();
                            }catch (Exception ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                        if(outStream!=null){
                            try{
                                outStream.close();
                            }catch (Exception ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                        if(clientSocket!=null){
                            try{
                                clientSocket.close();
                            }catch (Exception ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                    }

                }).start();
            }


        }catch (IOException ex){
            System.out.println("IO ERROR:"+ex.getMessage());
        }
    }

    @Test
    public  void client(){

    }
}