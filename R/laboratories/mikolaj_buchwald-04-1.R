# filename: mikolaj_buchwald-01-1.R
# author: Mikolaj Buchwald

# Import a library.
library(tidyr)

# Define a data frame.
df1 <- read.table(text="X;Y;Z  
                  ID2; 2016-06; 566  
                  ID1; 2016-06; 10239  
                  ID6; 2016-06; 524  
                  ID2; 2016-07; 2360  
                  ID1; 2016-07; 13853  
                  ID6; 2016-07; 2352  
                  ID2; 2016-08; 3950  
                  ID1; 2016-08; 14738  
                  ID6; 2016-08; 4104",header=TRUE, sep=";")

# Spread data wide.
df1_wide <- spread(df1, key = Y, value = Z)
df1_wide_1 <- df1_wide[, 2:4]

############################################
#       Way 1:
#

sum_1 <- colSums(df1_wide_1)
# Merge
df1_summed_1 <- rbind(df1_wide_1, sum_1)
print("")
print("")
print("First way of dealing with the problem")
print(df1_summed_1)


############################################
#       Way 2:
#

# Remove column containing factors.
df1_wide_2 <- df1_wide
df1_wide_2[,1] <- NULL

# Sum up.
df1_summed_2 = addmargins(as.matrix(df1_wide_2))

print("")
print("")
print("Second way of dealing with the problem")
print(df1_summed_2)
print("")
print("")
