package ch.zuehlke.fullstack.hackathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate template;


//    public void notifyMatchStart(final UUID matchId){
//        this.template.convertAndSendToUser();
//    }

//    private final GameService gameService;

//    public void notifyGameUpdate(GameId gameId) {
//        gameService.getGame(gameId.value())
//                .map(GameMapper::map)
//                .ifPresent(game -> template.convertAndSend("/topic/game/" + gameId.value(), new GameUpdate(game))
//                );
//    }
}
