# AE2DMS-CW-20513868-20518223

## Platformer Game - Escape Beyond

>**Escape Beyond** is a JavaFX-based 2D platformer game where players explore themed levels (Glacier, Desert and more), overcome obstacles, collect supplies, and race against time to escape.



### Design Patterns

**MVC Pattern**:
The game adopts the model-view-controller (MVC) architecture, divides the packages into three categories, and uses Controllers like `ScoreController` to separate game logic from views (.fxml), which enhances modularity and maintainability of the game components.

1. **Singleton pattern**: The `Main` class ensures only one instance of the game is running globally, which centralizes access to game state, UI, and controllers, preventing multiple conflicting instances


2. **Strategy Pattern**: `MovableNode` and its subclasses (e.g., MummyNode, FireDragonNode) use the `Movable` interface to dynamically assign movement behaviors like `LineMove` and `NoMove`, which allows different types of movements for various game entities without changing the node's structure. 

3. **Observer Pattern**: The `PlayerModel` (ObservedSubject) notifies PlayerView when the player’s position changes， which ecouples the model and view, ensuring UI updates dynamically without tight coupling.

4. **Factory Pattern**: `EntityCreator` creates game objects like platforms, enemies, and supplies based on input parameters, which implifies object creation logic and centralizes it to promote scalability.
   
5. **Adapter Pattern**: In the game, `InitContentAdapter` standardizes content initialization for maps, backgrounds, and entities, which abstracts complex content setup logic and solve the problem of interface incompatibility between different classes.

## Additions

1. **High Score Management System**
- **Where**: Stores scores for different levels using serialization and deserialization.
- **How**: The `ScoreManager` class handles persistent storage in `scores.dat`.
- **Why**: Allows players to track progress and compare scores.

2. **Dynamic Background Switching**
- **What**: Background images dynamically change each time a level is loaded to enhance visual variety.
- **How**: The `Map` class implements the getRandomMapBackground method, which uses the `RandomNumberGenerator` utility to randomly select a background image.
- **Why**: Provides visual variety, making the game more engaging and aesthetically appealing.

3. **Dynamic Movement Behaviors** 
- **What**: Enemies and objects dynamically adopt movement strategies.
- **How**: Strategy Pattern implemented with `Movable` and its concrete classes.
-**Why**: Provides flexible and scalable behavior customization for various game entities.

4. **Countdown Timer System**
- **What**: A game timer dynamically updates the UI and triggers game-over when time ends.
- **How**: Implemented with AnimationTimer. Above the screen, a countdown `timerLabel` shows the remaining time.
- **Why**: Enhances gameplay by creating urgency and challenge.


5. **Interactive Supply Collection**
- **What**: Players collect supplies (e.g., water, cookies), contributing to score calculation.
- **How**: `SupplyBlock` nodes are registered and tracked in the game state.
- **Why**: Adds interactivity and replayability.

6. **Showcase Character Mirroring** : As the player moves left or right, the character mirrors its direction.








### Test cases (not includes 500 words): 

1.  **Test case 0**: MainTest, which starts the entry function of the javafx application, so that tester can directly test the completion of the entire game.

2.  **Test case 1**: HomePageTest, it lets tester come to the home screen.

3.  **Test case 2**: OptionPageTest, used to test the Option page after entering the game interface, in which you can select the character and save it in GameState.

4.  **Test case 3**: MapPageTest, it can select the map and save it in GameState.

5.  **Test case 4**: InformationPageTest, it can check some information about this game.

6.  **Test case 5**: ScorePageTest, it can set the value of GameState to control the score displayed in ScorePage.

7.  **Test case 6**: Level1Test, it can test the first level.

8. **Test case 7**: Level2Test, it can test the second level.
   







