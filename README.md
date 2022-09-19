# TeamsCalc
Tracks ongoing points and streaks for a browser game where teams gain points each day

I wrote this to help create blog posts for a browser game where 4 teams would gain points each day during a month-long event. 

During previous events, it was noted that teams who felt they were losing or had less active players would give up, therefore creating a self-fulfilling prophesy.
As this was the first event where each teams points were announced daily, I wanted to check whether this would hold up when teams could see their own progress

The program tracks the running totals for each team, as well as how much their efforts had changed from the previous day, and the points separating them

I aimed to show people how much their efforts were aiding the team. 
For example, if the losing team put in the same effort tomorrow as they had on day X, they could overtake the winning team

Program takes in each team's points from the previous day
As I wrote this to aid in writing blog posts, it also takes in a URL for whatever image or screenshot I used to announce the blog that day

Output is stylised with HTML tags and unicode trophies, and pasted into a .txt file for each day

Program also includes undo function to remove previous day's points
