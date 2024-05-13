package edu.kh.project.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import edu.kh.project.websocket.handler.ChattingWebsocketHandler;
import edu.kh.project.websocket.handler.NotificationWebsocketHandler;
import edu.kh.project.websocket.handler.TestWebsocketHandler;
import lombok.RequiredArgsConstructor;

@Configuration // 서버 실행시 작성된 메서드를 모두 수행
@EnableWebSocket // 웹소켈 활성화 설정
@RequiredArgsConstructor
public class WebsocketConfig implements WebSocketConfigurer{

	// 웹소켓 처리 동작이 작성된 객체 의존성 주입(DI)
	private final TestWebsocketHandler testWebsocketHandler;
	
	// Bean으로 동륵된 SessionHandshakeInterceptor가 의존성 주입됨
 	private final HandshakeInterceptor handshakeInterceptor;
	
 	
 	// 알림 웹소켓 처리 객체 의존성 주입(DI)
 	private final NotificationWebsocketHandler notificationWebsocketHandler;
 	
 	// 채팅 웹소켓 처리 객체 의존성 주입(DI)
 	private final ChattingWebsocketHandler chattingWebsocketHandler;
 	
	
	
	
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		// addHandler(웹소켓 핸들러, 웹소켓 요청 주소)
		
		registry
			.addHandler(testWebsocketHandler, "/testSock")
			 // websocket://localhost/testSock으로
			 // 클라이언트가 요청을 하면 
			 // TestWebsocketHandler가 처리하도록 등록
			
			.addInterceptors(handshakeInterceptor)
			// 클라이언트 연결 시 HttpSession을 가로채
			// 핸들러에게 전달
			
			.setAllowedOriginPatterns("http://localhost",
									  "http://127.0.0.1/",
									  "http://192.168.10.27/")
			// 웹소켓 요청이 허용되는 ip/도메인 추가
			
			.withSockJS();
			// SockJS(websocket 보완) 지원 + 브라우저 호환성 증가
		
		
		// 알림 처리 핸들러와 주소 연결
		registry
			.addHandler(notificationWebsocketHandler, "/notification/send")
			.addInterceptors(handshakeInterceptor)
			.setAllowedOriginPatterns("http://localhost/", 
									  "http://127.0.0.1/", 
									  "http://192.168.10.27/")
			.withSockJS();
		
		// 채팅 처리 핸들러와 주소 연결
		registry
		.addHandler(chattingWebsocketHandler, "/chattingSock")
		.addInterceptors(handshakeInterceptor)
		.setAllowedOriginPatterns("http://localhost/", 
				"http://127.0.0.1/", 
				"http://192.168.10.27/")
		.withSockJS(); // SockJS 라이브러리 지원 
				
	}
}
