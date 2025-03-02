package ch.zuehlke.fullstack.hackathon.model;

import ch.zuehlke.common.cards.Card;
import ch.zuehlke.common.GameStatus;
import ch.zuehlke.fullstack.hackathon.model.exception.CardStackException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

@RequiredArgsConstructor
public class Game {

    @Getter
    @Setter
    private GameStatus status = GameStatus.NOT_STARTED;

    @Getter
    private final UUID id;
    @Getter
    private final List<PlayerHand> players;
    private final CardStack cardStack;

    public Optional<PlayerHand> findPlayer(final UUID playerId) {
        return this.players.stream()
                .filter(playerHand -> playerHand.player().id().equals(playerId))
                .findAny();
    }

    /**
     * Returns the card on top of the discarded pile without removing it.
     *
     * @return The card on top of the discarded pile.
     */
    public Card peekDiscarded() {
        return this.cardStack.peekDiscarded();
    }

    /**
     * Removes the card on top of the discarded pile.
     *
     * @return The card on top of the discarded pile.
     */
    public Card getLastDiscarded() {
        return this.cardStack.getLastDiscarded();
    }

    /**
     * Gets the card on top of the stack and removes it.
     *
     * @return The card on top of the stack.
     */
    public Card getFromStack() {
        return this.cardStack.getFromStack();
    }

    /**
     * Discards a card by adding it on top of the discard pile
     *
     * @param card The card to be discarded
     * @throws CardStackException If the card is still on the stack or already on the discarded pile
     */
    public void discard(final Card card) throws CardStackException {
        this.cardStack.discard(card);
    }
}
