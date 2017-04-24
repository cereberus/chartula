df <- data.frame(litary = c("X","B","Y","D"), liczby = c("1","2","3,0","4,0"), braki = c(NA,1,NA,1), stringsAsFactors = FALSE)
names(df)[1] <- "litery"
df[1,1] <- "A"
df[3,1] <- "B"
df$liczby <- as.integer(sub(",", ".", df$liczby, fixed = TRUE))
df$braki[is.na(df$braki)] = 0
print(df)
