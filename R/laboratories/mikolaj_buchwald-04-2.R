# filename: mikolaj_buchwald-01-2.R
# author: Mikolaj Buchwald

# Import a library.
library(tidyr)

# Define a data frame.
df2 <- data.frame(name = c("Dzesika", "Brajan", "Seba"),  
                  matma = c(2, 3, 5), 
                  polak = c(5, 5, 4))

# Long format of the data. 
df2_long <-gather(df2, key=name)

# Change column names to more informative ones.
colnames(df2_long)[2:3] <- c("subject", "grade")

# Reveal results.
print("")
print("")
print("Final data frame")
print(df2_long)
