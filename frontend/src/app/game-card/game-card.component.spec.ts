import { GameCardComponent } from "./game-card.component";
import { LobbyService } from "../../services/lobby.service";
import { EMPTY } from "rxjs";
import { Game, GameId } from "../../model/lobby";

describe("GameCardComponent", () => {
  let component: GameCardComponent;
  let lobbyServiceSpy: jasmine.SpyObj<LobbyService>;

  beforeEach(async () => {
    lobbyServiceSpy = jasmine.createSpyObj("LobbyService", ["deleteGame"]);
    component = new GameCardComponent(lobbyServiceSpy);
  });

  it("should successfully delete a game", () => {
    const gameId = { id: 123 } as GameId;
    component.game = {
      gameId: gameId,
    } as Game;
    lobbyServiceSpy.deleteGame.and.returnValue(EMPTY);

    component.deleteGame();

    expect(lobbyServiceSpy.deleteGame).toHaveBeenCalledWith(gameId);
  });
});
