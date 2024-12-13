Solitaire uses a classic 52-card deck. It involves setting up cards in 
piles in a specific order, going from Ace (the smallest) to King 
(the largest).

What we need for the game to work (WIP):

I.Setup

1. The 52-card deck spread across 4 suits, each with 14 consecutive cards.

Tasks: Adding the 4 suits. DONE
       Adding the 14 consecutive values. DONE

Solution: Use enums for the suits, add colors to
the suits. 
Place the ranks into a String array.

Task: Adding values to the ace and face cards.

2. Gameplay.Tableau: Deal the deck into 7 piles, the first pile has 1 card, the second 2,
and so on. Only the top card of the pile is face up, the rest face down.

Task: 1. Create the 7 piles.
         Move the cards into the piles.
         Hide the value of all except the last card placed.

Solution: Have the 7 piles be arrays where the cards go into.
          Use a conditional that shows the card in the last position
          of the array.

3. Gameplay.Foundations: Four empty spaces designed for foundation piles.

Task: Initialize these as four empty arrays.

4. Gameplay.Stockpile: The rest of the cards are placed down in the stockpile.

Task: Have the deck be able to exist in a dynamic way, where it can
hold the cards it no longer has. Perhaps could be achieved by temporarily
deleting the cards from the deck array.

5. Waste: Gameplay.Deck that cannot be played immediately from the stockpile
are placed in a waste pile.

II. The GUI.GUI.

1. Create the GUI.GUI and in it create:

The deck
The tableau
The foundation
The stockpile
The waste pile

III. Gameplay

1. Move the cards: move cards on the tableau by arranging them in descending,
alternating color order, e.g. black Ace on red two. 
1.1 Only kings can be placed on empty tableau spaces.
1.3 After correctly moving the top card of a tableau pile, turn over
and reveal the next card. 


2. Build the foundations: Move aces to the foundation piles when they
show up. Then place other cards on top until you reach the kings in
every pile.
    Move cards from one tableau pile to another.

3. Gameplay.Stockpile and waste pile interaction: Draw cards from the stockpile 
one at a time. If you can play a card, place it in a tableau or foundation.
Otherwise, discard it to the waste pile.
    After exhausting your stockpile, reshuffle the waste pile and use it
as your new stockpile. Reset the waste pile to 0. Continue until the game
is over.

IV. Difficulty levels:

1. Hard difficulty: do not draw the first card from the stockpile, always
draw the third from the top and place the first two into the waste pile.

