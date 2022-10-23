# WordlePeaks-Ai
Simple Wordle Peaks Solver that can quickly solve Wordle Peaks puzzles.

## Wordle Peaks
Wordle Peaks is a puzzling variant of Wordle in which the feedback given doesn't tell you whether its in the word or not, but instead, the feedback lets you know whether the letter is higher or lower than the input in terms of its position in the alphabet.

**EXAMPLE:** <br>
![image](https://user-images.githubusercontent.com/47650058/197369514-510993f9-0213-48ba-82e5-4598c6bcfc3c.png)

### Statistics
- 100% win rate
- Solvable in under 30 seconds

### Symbols
- The orange square marks the symbol indicating that the letter in that position stands in a higher position in the alphabet than the given input character.
- The blue square marks the symbol indicating that the letter in that position stands in a lower position in the alphabet than the given input character.
- The green squares mean you found the correct letter in the correct position.

### Rules
- Guess the 5 letter English Word using limited feedback as described as above.
- Make guesses and use the clues to make smarter guesses in the future.
- Win or lose if you can't guess the word in 6 tries maximum, you lose.

## Algorithms
- Calculate the best word that has the least difference from the tracked averages of each character simultaneously.
