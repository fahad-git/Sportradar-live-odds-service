# Sportradar Live Odds Service

This project is a **Live Football World Cup Scoreboard Library** designed to manage and display ongoing football matches and their scores. It provides functionalities to start new matches, update scores, finish matches, and retrieve a summary of matches in progress, sorted by their total scores.

---

## Features

- **Live Scores:** Track and display real-time scores of ongoing football matches.
- **Start New Match:** Initialize a new match with home and away teams, starting with a default score of 0-0.
- **Update Score:** Update the scores for both home and away teams during a match.
- **Finish Match:** Mark a match as finished and remove it from the active scoreboard.
- **Match Summary:** Retrieve a summary of all matches in progress, sorted by total match score.

---

## Updated Usage

### Create an Instance of `ScoreBoard`

To begin using the library, create an instance of the `ScoreBoard` class.

```java
ScoreBoardInterface scoreboard = new ScoreBoard();
```

### Start a New Match

Start a new match by providing the home and away team names.

```java
scoreboard.startMatch("Germany", "Canada");
```

### Update the Score of an Ongoing Match

To update the score of an ongoing match, use the `updateScore` method. Pass the names of the home and away teams, along with their updated scores.

```java
scoreboard.updateScore("Germany", "Canada", 2, 3);
```

**Parameters:**
- `homeTeam`: The name of the home team (case-insensitive).
- `awayTeam`: The name of the away team (case-insensitive).
- `homeScore`: The updated score for the home team (must be a non-negative integer).
- `awayScore`: The updated score for the away team (must be a non-negative integer).

**Important Notes:**
- The team names must match those used when starting the match.
- Ensure that the match is active before updating scores.

### Finish a Match

To mark a match as finished, use the `finishMatch` method. Pass the names of the home and away teams.

```java
scoreboard.finishMatch("Germany", "Canada");
```

**Parameters:**
- `homeTeam`: The name of the home team (case-insensitive).
- `awayTeam`: The name of the away team (case-insensitive).

**Outcome:**
- The match is removed from the active scoreboard.

### Retrieve a Summary of Matches in Progress

To retrieve a summary of all ongoing matches, sorted by total score, use the `matchesSummary` method.

```java
List<Match> summary = scoreboard.matchesSummary();
```

**Output:**
- A list of `Match` objects representing ongoing matches, sorted by total score in descending order. Matches with the same score are displayed in the order they were added.

---

## Running Unit Tests

To execute all unit test cases using JUnit:

1. **Run `TestRunner.java`:**

   ```bash
   javac -cp "lib/junit-platform-console-standalone-1.11.3.jar:src" src/TestRunner.java
   java -cp "lib/junit-platform-console-standalone-1.11.3.jar:src" TestRunner
   ```

This will execute all test cases and display the results.
