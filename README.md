# Sportradar-live-odds-service

## Project Understanding:

### Live Football World Cup Scoreboard library: 
- Live Scores.
- Start New Match (Teams Home & Away) -> Default score 0-0.
- Update Score (Receive scores x, y and update Home -> x and Away -> y.
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