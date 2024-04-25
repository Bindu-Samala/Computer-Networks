package com.tcpclientserver;
import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc=new Scanner(System.in);
            String messageToSend = sc.nextLine();
            out.println(messageToSend);
            System.out.println("Sent: " + messageToSend);

            String receivedString = in.readLine();
            System.out.println("Received: " + receivedString);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
