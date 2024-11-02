# Sportradar-live-odds-service

## Project Understanding:

### Live Football World Cup Scoreboard library: 
- Live Scores.
- Start New Match (Teams Home & Away) -> Default score 0-0.
- Update Score (Receive scores x, y and update Home -> x and Away -> y).
- Finish in progress match (matchInProgress = False) -> Remove from scoreboard.
- Summary of Scores (Sort in place based on total match score).

### Entities
  - **Match**
      - homeTeam
      - awayTeam
      - homeTeamScore
      - awayTeamScore
      - matchInProgress
      - StartMatch()
      - UpdateMatch()
      - finishMatch()
  - **ScoreBoard**
      - matches[]
      - StartMatch()
      - UpdateMatch()
      - finishMatch()
      - matchSummary()


### Assumptions
    1. There is no character limit/specifications for team names.
    2. The team name is case-insensitive.
    3. The matchNumber will be used to sort for teams with the same total score during the match.
    4. The maximum number of matches can be 2147483647 (Max limit of an integer match counter).
    5. The solution can be extended or implemented later (Scaleable).
    6. The requirement was to deliver a simple draft.
    7. User, who will use this library will manage/install dependencies on its own.

## Overview
Live Football World Cup scoreboard library is a live matches score updates library. The major requirements of this library design were the following:

    1. Start a new match, assuming the initial score is 0 – 0, and add it to the scoreboard. This should capture the following parameters:
        a. Home team
        b. Away team
    2. Update score. This should receive a pair of absolute scores: home team score and away team score.
    3. Finish match currently in progress. This removes a match from the scoreboard.
    4. Get a summary of matches in progress ordered by their total score. The matches with the same total score will be returned ordered by the most recently started match in the scoreboard.

This library is designed to fulfill these requirements.

### Downloading Library
To execute this repository, you need to download `junit-platform-console-standalone-1.11.3.jar` file and add it to the /lib directory on the root of the project. This JAR file can be downloaded from the following link:
`https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone/1.11.3`

### Usage
To use this library, you need to follow the steps below:

1. Clone the repository.
2. Download the JUnit JAR file from the Maven repository.
3. Create a `/lib` directory on the root of the project and add a JAR file into this directory.
4. Create an instance of `ScoreBoard` class.

    ```JAVA
    ScoreBoardInterface scoreboard = new ScoreBoard();
    ```

5. To start a match, use the `startMatch(TeamA, TeamB)` method.

    ```JAVA
    scoreboard.startMatch("Germany", "Canada");
    ```

6. To update the score of a match in progress use `updateScore(scoreA, scoreB)` method.

    ```JAVA
    scoreboard.updateScore(2, 3);
    ```

7. To finish a match, use `finishMatch()` method.

    ```JAVA
    scoreboard.finishMatch();
    ```

8. To retrieve a summary of all matches in progress sort my match total score using `matchesSummary()` method.

    ```JAVA
    scoreboard.matchesSummary();
    ```


### Running Unit Tests
There is a test runner class available to run all unit test cases of the project through JUnit. Run `TestRunner.java file to execute all test cases and it will show test case results.
