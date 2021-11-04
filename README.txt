# Bulls-and-Cows

Group members: Valerie, David and Catherine

Data structure used: 

- stack
  - character stack in MainGame class 
  Stack<Character> guess = new Stack<Character>();
      - act method (takes in user's guess in characters)
      - checkBullsAndCows method (takes the user guess and check the number of bulls and cows)
      - displayPreviousBullsAndCows method (converts the character stack into strings and displays        it in sidebox)
      
- ArrayList
  - string arraylist in MainGame class
  ArrayList<String> myList = new ArrayList<String>();
      - MainGame method (creates an ArrayList of words taken from another list of words 
      
- Array
  - character array in MainGame class
  char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
      - creates a character ArrayList of the alphabet 
