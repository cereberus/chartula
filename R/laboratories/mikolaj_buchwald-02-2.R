df <- data.frame(animal = c("wild animals", "domestic animals", "both", "neither"))

# Te percent values on the website are rounded.
# Sum of the percents doesn't equal 100.
df[,2] <- c(18, 10, 19, 52)
names(df)[2] = "percent"

participants <- 949
df[,3] <- as.integer(df$percent / 100 * participants)
names(df)[3] = "raw"

supposed_participants <- 345
df[,4] <- as.integer(df$percent / 100 * supposed_participants)
names(df)[4] = "supposed"

print(df)
most <- max(df$supposed)
print("Number of people in the most numerous category")
print(most)
