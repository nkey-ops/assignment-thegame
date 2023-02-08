# The Game

The current implementation of the game permits one player or one computer. 

The Game is a cooperative card game that can be played by 1 to 5
players. The goal is for the players to work together to discard all of the
cards in the deck by discarding the cards into one of four discard piles.

Two of the discard piles start at 1 and cards are played in ascending
order; only cards greater than the card on the top may be played unless
the card is exactly 10 less than the card on the top. For example, if the
top card on the pile is 27, then any card greater than 27 may be played
on the pile or a 17 may be played (because it is exactly 10 less).

The other two discard piles start at 100 and cards are played in
descending order; only cards less than the card on the top may be played
unless the card is exactly 10 more than the card on top. For example, if
the top card on the pile is 66, then any card less than 66 may be played
on the pile or a 76 may be played (because it is exactly 10 greater).

The deck contains 98 cards numbered from 2 to 99. Depending on the
number of players, each player is dealt a hand from 6 to 8 cards. On a
player's turn, they must play at least two cards (but may play as many
cards as they want). At the end of their turn, they draw enough cards to
replace any that they played.

The game is won if the players manage to play all of the cards in the
deck. If any player is unable to play at least two cards on their turn, the
game is lost.
