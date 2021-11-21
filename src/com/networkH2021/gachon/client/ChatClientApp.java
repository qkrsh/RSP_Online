package com.networkH2021.gachon.client;

import com.networkH2021.gachon.Game;
import com.networkH2021.gachon.GameLauncher;
import com.networkH2021.gachon.MainLobby;
import com.networkH2021.gachon.server.ChatServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

import static com.networkH2021.gachon.GameLauncher.*;

public class ChatClientApp {
	
	private static final String SERVER_IP = "14.47.251.177";//시우집 컴퓨터 WAN 아이피랑 외부 포트
	private static final int SERVER_PORT = 13802;
	//private MainLobby  mainLobby = new MainLobby();
	public ChatClientApp(MainLobby mainLobby) {
		String name = null;


//		while( true ) {
//
//			System.out.println("대화명을 입력하세요.");
//			System.out.print(">>> ");
//			//name = GameLauncher.getUser().getUserName();
//			//name = "siwoo";
//			//name = GameLauncher.getUser().getUserNickname();
//
////			System.out.println(ChatServer.checkNickname(name));
////			if (ChatServer.checkNickname(name)==0) {
////				break;
////			}
//
//			if (name.isEmpty() == false) {
//				break;
//			}
//
//
//			System.out.println("사용할 수 없는 닉네임 입니다.\n");
//
//		}
		name = GameLauncher.getUserDAO().getNickname();
		// 1. 소켓 만들고
		Socket socket = null;
		try {
			// 1-1 소켓 생성
			socket = new Socket();

			// 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 2. iostream 구현
			BufferedReader br = new BufferedReader(
							new InputStreamReader(socket.getInputStream(), "utf-8"));

			PrintWriter pw = new PrintWriter(
							new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);

			// 3. join 프로토콜  -> 서버가 닉네임 받아서 처리 / 성공하면 다음 실행
			pw.println("join:"+ name);
			String ack = br.readLine();  // blocking
//			System.out.println("------->" + ack);

			//GameLauncher.MakeMainLobby();
			//MainLobby mainLobby = GameLauncher.getMainLobby();
			//mainLobby.setTitle("TestTestTest");
			//System.out.println(mainLobby);
			//GameLauncher.getMainLobby().Chatting(name,socket,ack);
			//mainLobby.Chatting(name, socket,ack);
			ChatWindow chatWindow = new ChatWindow(name,socket,ack);
			chatWindow.show();
		} catch(IOException e) {
			System.out.println("서버가 존재하지 않습니다.");
		}

	}

}









