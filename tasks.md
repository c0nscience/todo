# List all my todos
As Karl
I want to retrieve all my todos  
So that I can look at them after I created them  

Given I have some todos  
When call the endpoint to get all todos  
Then the I see all todos  

# I want to star my favorite todo
As Karl
I want to star my favorite todos  
So that I can find them faster  

Given I have some todos  
When I star one of the todos  
Then the todos that are starred have a star flag  

# I want my starred todos to be pinned to the top of the list
As Karl
I want to pin my starred todos to be at the top of the list  
So that I can find them faster  

Given I have some starred and unstarred todos  
When retrieve all todos  
Then the todos that are starred are at the top of the list
